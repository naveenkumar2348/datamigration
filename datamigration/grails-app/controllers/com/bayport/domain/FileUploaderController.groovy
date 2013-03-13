package com.bayport.domain

import com.bayport.enums.MasterDataSheetType
import com.bayport.enums.MigrationStatus
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.commons.CommonsMultipartFile

class FileUploaderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def XLSImporterService;

    def masterDataImporterService;

    def mailService;

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fileUploaderInstanceList: FileUploader.list(params), fileUploaderInstanceTotal: FileUploader.count()]
    }

    def create() {
        [fileUploaderInstance: new FileUploader(params)]
    }


    def save() {

        def fileUploaderInstance = new FileUploader(params)
        MasterDataSheetType sheetType = params?.dataSheetType
        CommonsMultipartFile uploadedFile = params?.('masterDataSheet')
        fileUploaderInstance.setUploadedFileName(uploadedFile?.getName())

        if (!uploadedFile?.getFileItem()?.name && uploadedFile?.size <= 0){

            flash.errorMessage = message(code: 'com.bayport.domain.stagingagent.masterDataSheet.empty', default: 'You have uploaded blank XLS file,Please upload proper file.')
            render(view: "create", model: [fileUploaderInstance: fileUploaderInstance])
            return
        }else if (!uploadedFile.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                && !uploadedFile?.getContentType().equalsIgnoreCase("application/vnd.ms-excel")){

            flash.errorMessage = message(code: 'com.bayport.domain.stagingagent.masterDataSheet.filetype', default: 'Allowed XLS or XLSX file types only')
            render(view: "create", model: [fileUploaderInstance: fileUploaderInstance])
            return

        }
        FileUploader fileUploaderError = XLSImporterService.uploadXLSSheet(sheetType,uploadedFile);
        Set<FileUploaderError> errors = fileUploaderError?.getErrorList()

        if (errors?.size() > 0){
            fileUploaderInstance.setErrorList(errors)
            if (fileUploaderInstance?.emailId){
                mailService.sendMail {
                    to ""+fileUploaderInstance?.emailId
                    subject "${sheetType} File Upload Status"
                    body 'Please resolved the below errors and upload again '+errors.each { error ->
                        error?.columnNumber
                        error?.rowNumber
                        error?.errorMessage

                    }
                }
            }

            render(view: "create", model: [fileUploaderInstance: fileUploaderInstance])
            return

        }else {
            if (fileUploaderInstance?.emailId){
                mailService.sendMail {
                    to ""+fileUploaderInstance?.emailId
                    subject "${sheetType} File Upload Status"
                    /*body 'File data is successfully uploaded into Staging Area' +
                            '' +
                            'Regards,' +
                            'Data Migration Team'*/
                    html g.render(template:"successEmailTemplate",model: [username:fileUploaderInstance?.uploadedBy])
                }
            }
            fileUploaderInstance.setStatus(MigrationStatus.InStagingArea)
            fileUploaderInstance.setIsExportedToFlexifin(false)
            if (!fileUploaderInstance.save(flush: true)) {
                render(view: "create", model: [fileUploaderInstance: fileUploaderInstance])
                return
            }
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), fileUploaderInstance.id])
        redirect(action: "show", id: fileUploaderInstance.id)
    }

    def show() {
        def fileUploaderInstance = FileUploader.get(params.id)
        if (!fileUploaderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "list")
            return
        }

        [fileUploaderInstance: fileUploaderInstance]
    }

    def edit() {
        def fileUploaderInstance = FileUploader.get(params.id)
        if (!fileUploaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "list")
            return
        }

        [fileUploaderInstance: fileUploaderInstance]
    }

    def update() {
        def fileUploaderInstance = FileUploader.get(params.id)
        if (!fileUploaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fileUploaderInstance.version > version) {
                fileUploaderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'fileUploader.label', default: 'FileUploader')] as Object[],
                          "Another user has updated this FileUploader while you were editing")
                render(view: "edit", model: [fileUploaderInstance: fileUploaderInstance])
                return
            }
        }

        fileUploaderInstance.properties = params

        if (!fileUploaderInstance.save(flush: true)) {
            render(view: "edit", model: [fileUploaderInstance: fileUploaderInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), fileUploaderInstance.id])
        redirect(action: "show", id: fileUploaderInstance.id)
    }

    def delete() {
        def fileUploaderInstance = FileUploader.get(params.id)
        if (!fileUploaderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fileUploaderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fileUploader.label', default: 'FileUploader'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    /**
     * Streams blob files
     * @param id
     * @return
     */
    def displayBlob = {
        def uploadedFile = FileUploader.get(Long.parseLong(params?.id))

        //response.contentType = uploadedFile?.masterDataSheet?.mimeType //"image/jpeg"
        response.contentType = "application/vnd.ms-excel"
        response.setHeader("Content-disposition", "attachment; filename=${uploadedFile?.getUploadedFileName()}.xls")
        response.contentLength = uploadedFile?.masterDataSheet?.length
        response.outputStream.write(uploadedFile?.masterDataSheet)
        response.outputStream.flush()
        response.outputStream.close()
    }

    def exportToFlexifin(){
        def fileUploaderInstance = FileUploader.get(params.id)
        print "Inside exportToFlexifin"
        fileUploaderInstance = masterDataImporterService.exportToFlexiFin(fileUploaderInstance)
        if (fileUploaderInstance?.errorList?.size() > 0){

        }else {

           /* fileUploaderInstance.setStatus(MigrationStatus.InFlexiFin)
            fileUploaderInstance.setIsExportedToFlexifin(true)*/
            fileUploaderInstance.save(flush: true)
        }

        redirect(action: "list", params: params)
    }
}

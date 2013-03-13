package com.bayport.domain

import com.bayport.enums.MasterDataSheetType
import com.bayport.enums.MigrationStatus

class FileUploader {

    String uploadedBy
    Date date
    String emailId
    byte[] masterDataSheet
    Integer numberOfRows
    String uploadedFileName
    MasterDataSheetType dataSheetType
    MigrationStatus status
    boolean isExportedToFlexifin

    static hasMany = [errorList:FileUploaderError]

    static constraints = {
        masterDataSheet(nullable: true, maxSize: 1073741824)
        numberOfRows nullable: true
        uploadedFileName nullable: true
        emailId nullable: false
        uploadedBy nullable: false
        status nullable: false
        isExportedToFlexifin nullable: true
    }

}

package com.bayport.service

import com.bayport.constants.AgentXLSConstants
import com.bayport.domain.*
import com.bayport.domain.StagingEmailAddress
import com.bayport.enums.MasterDataSheetType
import com.bayport.enums.MigrationStatus
import org.apache.poi.hssf.usermodel.HSSFDateUtil
import org.apache.poi.ss.usermodel.*
import org.hibernate.Session
import org.hibernate.Transaction
import org.joda.time.DateTime
import org.springframework.web.multipart.commons.CommonsMultipartFile

class XLSImporterService {

    def sessionFactory;

    FileUploader fileUploader = new FileUploader();

    Set<FileUploaderError> errors = null;

    FileUploader uploadXLSSheet(MasterDataSheetType sheetType,CommonsMultipartFile XLSDataFile){
        errors = new HashSet<FileUploaderError>()
        FileInputStream XLSFile = null;
        Sheet XLSSheet = null;
        Boolean isError = false

        try {

            XLSFile = XLSDataFile.getInputStream()
            Workbook workbook = WorkbookFactory.create(XLSFile);
            XLSSheet = workbook.getSheetAt(0);
        }catch (Exception e){

            FileUploaderError error = new FileUploaderError();
            error.errorMessage = e.message;
            errors.add(error);
            isError=true
        }finally {

            if (XLSFile != null){
                XLSFile.close();
            }
        }


        switch (sheetType){

            case MasterDataSheetType.AGENT :
                print "Inside Agent Case"
                print "Sheet Name"+XLSSheet.getSheetName()
                print "Status"+XLSSheet != null && !isError && XLSSheet.getSheetName().equalsIgnoreCase("Agent")
                if (XLSSheet != null && !isError && XLSSheet.getSheetName().equalsIgnoreCase("Agent")){
                    print "Inside If"
                    return uploadAgentSheetData(XLSSheet);
                }else{

                    FileUploaderError error = new FileUploaderError();
                    error.errorMessage = "Uploaded Master Sheet does not match the Agent Sheet Columns,Please upload proper Agent Sheet"
                    errors.add(error);
                    print "Size"+errors.size()
                    fileUploader.setErrorList(errors)
                    return fileUploader;
                }
                break;

            case MasterDataSheetType.USER :
                break;

            case MasterDataSheetType.BANK :
                break;

            case MasterDataSheetType.THIRDPARTY :
                break;

            case MasterDataSheetType.CLIENT :
                break;

            case MasterDataSheetType.OUTLET :
                break;

            case MasterDataSheetType.EMPLOYER :
                break;
        }
    }

    FileUploader uploadAgentSheetData(Sheet agentDataSheet){

        errors = new HashSet<FileUploaderError>()
        List<StagingAgent> agents = new ArrayList<StagingAgent>();
        agents = convertXLSDataToAgentEntities(agentDataSheet);
        print "Errors Size"+errors?.size()
        if (errors?.size() > 0){

            fileUploader.setErrorList(errors)
            return fileUploader;
        }else{
            print "Begin Session"
            Session session = sessionFactory.openSession();
            Transaction transaction = null;
            errors = new HashSet<FileUploaderError>()
            try {
                transaction = session.beginTransaction();
                transaction.begin();
                print "Total Number of Instances"+agents.size()
                for(StagingAgent agentInstance : agents){
                    print "Agent Emails"+agentInstance.getStagingEmailAddresses().size()
                    print "Agent Contact Numbers"+agentInstance.getStagingContactNumbers().size()
                    print "Agent Address"+agentInstance.getStagingAddresses().size()
                    print "Bank Accounts"+agentInstance.getStagingBankAccounts().size()
                    session.save(agentInstance)
                    print "Agent Instance Saved"
                }
                if (errors.size() > 0){

                }else {
                    transaction.commit();
                }
            }catch (Exception e){
                print "Error"+e.printStackTrace()
                print "Error Message"+e.message
                if(transaction != null){
                    transaction.rollback();
                }

                FileUploaderError error = new FileUploaderError()
                error.setErrorMessage(e.getMessage())
                errors.add(error)
            }finally {
                session.close();
            }
        }

        fileUploader.setErrorList(errors)
        return fileUploader;
    }

    List<StagingAgent> convertXLSDataToAgentEntities(Sheet agentDataSheet){
        List<StagingAgent> agents = new ArrayList<StagingAgent>();
        errors = new HashSet<FileUploaderError>()
        Row row = null;
        Cell cell = null;
        try{
            Iterator<Row> rowIterator = agentDataSheet.iterator();
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                if (row.rowNum >= AgentXLSConstants.agentImportStart){
                    StagingAgent agent;
                    Set contactNumbers = new HashSet()
                    Set emails = new HashSet()
                    Set bankAccounts = new HashSet()
                    Set addresses = new HashSet()
                    Iterator iterator = AgentXLSConstants.agentSheet.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry pairs = (Map.Entry)iterator.next();
                        switch (pairs.getKey()){

                            case "agent":
                                agent = new StagingAgent(parseXLSDataToMap(row,pairs.getValue()))
                                break;

                            case "person":
                                StagingPerson person = new StagingPerson(parseXLSDataToMap(row,pairs.getValue()));
                                agent.setStagingPerson(person);
                                break;

                            case "contactNumber1":
                                StagingContactNumber contactNumber1 = new StagingContactNumber(parseXLSDataToMap(row,pairs.getValue()));
                                print "ContactNumber"+contactNumber1.getContactNumber()
                                contactNumber1 = contactNumber1.save(flush: true)
                                contactNumbers.add(contactNumber1);
                                break;

                            case "contactNumber2":
                                StagingContactNumber contactNumber2 = new StagingContactNumber(parseXLSDataToMap(row,pairs.getValue()));
                                print "ContactNumber"+contactNumber2.getContactNumber()
                                contactNumber2 = contactNumber2.save(flush: true)
                                contactNumbers.add(contactNumber2);
                                break;

                            case "emailAddress1":
                                StagingEmailAddress emailAddress1 = new StagingEmailAddress(parseXLSDataToMap(row,pairs.getValue()));
                                print "Email Address"+emailAddress1.getEmailAddress()
                                emailAddress1 = emailAddress1.save(flush: true)
                                emails.add(emailAddress1);
                                break;

                            case "emailAddress2":
                                StagingEmailAddress emailAddress2 = new StagingEmailAddress(parseXLSDataToMap(row,pairs.getValue()));
                                print "Email Address"+emailAddress2.getEmailAddress()
                                emailAddress2 = emailAddress2.save(flush: true)
                                emails.add(emailAddress2);
                                break;

                            case "bankAccount":
                                StagingBankAccount bankAccount = new StagingBankAccount(parseXLSDataToMap(row,pairs.getValue()));
                                print "Acc"+bankAccount.getAccountNumber()
                                if (!bankAccount.validate()){
                                    bankAccount.errors.allErrors.each {
                                        println "Database Errors:"+ it
                                        FileUploaderError error = new FileUploaderError()
                                        error.setErrorMessage(it)
                                        errors.add(error)
                                    }
                                }else{
                                    bankAccount = bankAccount.save(flush: true)
                                    bankAccounts.add(bankAccount);
                                }
                                break;

                            case "address1":
                                StagingAddress address1 = new StagingAddress(parseXLSDataToMap(row,pairs.getValue()));
                                print "Address1"+address1.getAddressLine1()
                                address1 = address1.save(flush: true)
                                addresses.add(address1);
                                break;

                            case "address2":
                                StagingAddress address2 = new StagingAddress(parseXLSDataToMap(row,pairs.getValue()));
                                print "Address1"+address2.getAddressLine1()
                                address2 = address2.save(flush: true)
                                addresses.add(address2);
                                break;
                        }
                    }

                    agent.setStagingContactNumbers(contactNumbers);
                    agent.setStagingEmailAddresses(emails);
                    agent.setStagingBankAccounts(bankAccounts);
                    agent.setStagingAddresses(addresses);
                    agent.setMigrationStatus(MigrationStatus.InStagingArea)
                    agents.add(agent);
                }
            }
        }catch (Exception e){
            print "Error"+e.printStackTrace()
            print "Error Message"+e.message
            FileUploaderError error = new FileUploaderError();
            if (row != null && cell != null){
                error.columnNumber = cell.columnIndex;
                error.rowNumber = row.rowNum;
            }
            error.errorMessage = e.message;
            errors.add(error);

        }
        return agents;
    }

    def parseXLSDataToMap(Row row,Map columnsData){

        Map mapValues = new HashMap()
        Iterator iterator = columnsData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)iterator.next();
            Cell cell = row.getCell(pairs.getKey())
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    mapValues.put(pairs.getValue(),cell.getBooleanCellValue().toString())
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    double doubleValue = cell.getNumericCellValue()
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        java.util.Date date = HSSFDateUtil.getJavaDate(doubleValue);
                        DateTime dateTime = new DateTime(date.getTime())
                        mapValues.put(pairs.getValue(),dateTime)
                    }else {
                        mapValues.put(pairs.getValue(),cell.getNumericCellValue())
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    if (pairs.getValue().toString().contains(".lookUpTypeValue")){
                        String mapKey = pairs.getValue().toString().replaceAll(".lookUpTypeValue","").trim()
                        def lookUpValue = MasterLookUpTypeValue.findByLookUpTypeValue(cell.getStringCellValue())
                         mapValues.put(mapKey,lookUpValue)
                    }else{
                        mapValues.put(pairs.getValue(),cell.getStringCellValue())
                    }
                    break;
                case Cell.CELL_TYPE_BLANK:
                    mapValues.put(pairs.getValue(),"")
                    break;
            }
        }
        return mapValues
    }

    def uploadLookUP(Sheet lookUpSheet){

        Row row;
        Cell cell;
        Iterator<Row> rowIterator = lookUpSheet.iterator();
        while(rowIterator.hasNext()) {
            row = rowIterator.next();
            cell = row.getCell(0)
            String lookUpValue = cell.getStringCellValue()
            MasterLookUpTypeValue lookUpTypeValue = new MasterLookUpTypeValue(lookUpTypeValue: lookUpValue,lookUPType: MasterLookUpType.findByLookUpType("Titulo"))
            lookUpTypeValue.save(flush: true)
        }

    }

}

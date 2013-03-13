package com.bayport.domain

class FileUploaderError {

    static constraints = {
    }

    String errorMessage;
    Integer rowNumber;
    String columnNumber;
    String coloumnValue;
    FileUploader fileUploader;

}

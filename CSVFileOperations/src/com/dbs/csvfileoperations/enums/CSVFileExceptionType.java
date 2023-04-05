package com.dbs.csvfileoperations.enums;

public enum CSVFileExceptionType {

	GENEARL, FILE_NOT_FOUND, FILE_NOT_READ, CSV_TYPE, PATH_ERORR;

	private String errorMessage;

	private CSVFileExceptionType() {
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
	

    
}

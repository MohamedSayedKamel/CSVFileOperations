package com.dbs.csvfileoperations.exception;

import com.dbs.csvfileoperations.enums.CSVFileExceptionType;

public class CSVFileException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CSVFileExceptionType type;
	public CSVFileException (CSVFileExceptionType type,String errorMessage)  
    {  
        // calling the constructor of parent Exception  
        super(errorMessage);  
        this.type=type;
    }
	public CSVFileExceptionType getType() {
		return type;
	} 
	
	

}

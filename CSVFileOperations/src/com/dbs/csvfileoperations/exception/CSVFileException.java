package com.dbs.csvfileoperations.exception;

public class CSVFileException extends Exception {

	private static final long serialVersionUID = 1L;
	public CSVFileException (String errorMessage)  
    {  
        // calling the constructor of parent Exception  
        super(errorMessage);  
    } 
	
	

}

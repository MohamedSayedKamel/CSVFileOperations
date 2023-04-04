package com.dbs.csvfileoperations.enums;

public enum Column {
	ID("id"), NAME("name"), JOB("job"), AGE("age"), CITY("city");
	private String value;
	
	Column(String eValue) {
        this.value = eValue;
    }
 
    public String getValue() {
        return value;
    }
    
}

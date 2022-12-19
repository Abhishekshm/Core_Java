package com.bank.exception;

public class BankNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public BankNotFoundException() {
		super();
		
	}

	public BankNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s having %s = %s is not avialable ! "+"--Please enter correct Bank ID ! ---", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}

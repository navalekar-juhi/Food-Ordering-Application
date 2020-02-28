package com.neu.exception;

public class CustomerException extends Exception{
	public CustomerException(String message)
	{
		super("CustomerException-"+message);
	}
	
	public CustomerException(String message, Throwable cause)
	{
		super("CustomerException-"+message,cause);
	}
}

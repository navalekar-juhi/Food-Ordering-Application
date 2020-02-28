package com.neu.exception;

public class ItemException extends Exception{
	public ItemException(String message)
	{
		super("ItemException-"+message);
	}
	
	public ItemException(String message, Throwable cause)
	{
		super("ItemException-"+message,cause);
	}
}

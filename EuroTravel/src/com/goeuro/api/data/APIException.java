package com.goeuro.api.data;

/**
 * @author sahil.lone
 *
 */
public class APIException extends RuntimeException
{

	/**
	 * ERR_SYSTEM_ERROR
	 */
	public static final String	ERR_SYSTEM_ERROR		= "ERR_SYSTEM_ERROR";
	/**
	 * ERR_OBJECT_NOT_FOUND
	 */
	public static final String	ERR_OBJECT_NOT_FOUND	= "ERR_OBJECT_NOT_FOUND";

	/**
	 * 
	 */
	private static final long	serialVersionUID		= 104832485250061120L;

	private String				errorCode				= null;
	private Object[]			errorParameters			= null;

	/**
	 * 
	 */
	public APIException()
	{
		super();
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public APIException(String message, Throwable thr)
	{
		super(message, thr);
		//updateErrorCodes(throwable);
	}

	/**
	 * @param message
	 */
	public APIException(String message)
	{
		super(message);
	}

	/**
	 * @param throwable
	 */
	public APIException(Throwable throwable)
	{
		this(throwable.getMessage(), throwable);
	}

	private void updateErrorCodes(Throwable throwable)
	{
		if (throwable instanceof APIException)
		{
			APIException tenantException = (APIException) throwable;
			if (tenantException.getErrorCode() != null && this.errorCode == null)
			{
				this.errorCode = tenantException.getErrorCode();
				this.errorParameters = tenantException.getErrorParameters();
			}
		}

	}

	/**
	 * @param errorCode 
	 * @param message 
	 * @param errorParameters
	 */
	public APIException(String errorCode, String message, Object[] errorParameters)
	{
		super(message);
		this.errorCode = errorCode;
		this.errorParameters = errorParameters;
	}

	/**
	 * 
	 * @param errorCode
	 * @param message
	 * @param throwable
	 */
	public APIException(String errorCode, String message, Throwable throwable)
	{
		super(message, throwable);
		this.errorCode = errorCode;

	}

	/**
	 * @param errorCode 
	 * @param message 
	 * @param errorParameters
	 * @param throwable 
	 */
	public APIException(String errorCode, String message, Object[] errorParameters, Throwable throwable)
	{
		super(message, throwable);
		this.errorCode = errorCode;
		this.errorParameters = errorParameters;
	}

	public String getErrorCode()
	{
		return this.errorCode;
	}

	public Object[] getErrorParameters()
	{
		return this.errorParameters;
	}

}

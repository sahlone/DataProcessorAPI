package com.goeuro.api.bo;

import java.util.List;

/**
 * 
 * @author arunava.choudhury
 *
 * @param <T>
 */
public class RestResponse<T>
{
	String			statusCode	= null;
	List<Object>	errorParams	= null;
	T				payLoad		= null;

	public String getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}

	public List<Object> getErrorParams()
	{
		return errorParams;
	}

	public void setErrorParams(List<Object> errorParams)
	{
		this.errorParams = errorParams;
	}

	public T getPayLoad()
	{
		return payLoad;
	}

	public void setPayLoad(T payLoad)
	{
		this.payLoad = payLoad;
	}
}

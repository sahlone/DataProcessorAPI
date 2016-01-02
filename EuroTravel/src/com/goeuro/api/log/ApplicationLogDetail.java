/**
 * 
 */
package com.goeuro.api.log;

import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * @author sahil.lone
 *
 */
public final class ApplicationLogDetail
{

	private String	message				= null;
	private Date	logDate				= null;
	private String	rootCause			= null;
	private String	rootCauseMessage	= null;
	private String	rootCauseStackTrace	= null;
	private String	fullCauseStackTrace	= null;
	private String	errorType			= null;

	/**
	 * @param serviceRequest
	 * @param applicationLogDetail 
	 * @param e 
	 * @return applicationLogDetail
	 */
	public final ApplicationLogDetail prepareLogDetail(ApplicationLogDetail applicationLogDetail, Throwable e)
	{
		applicationLogDetail.setMessage(message);
		applicationLogDetail.setLogDate(new Date());
		applicationLogDetail.setRootCause(ExceptionUtils.getRootCauseMessage(e));
		applicationLogDetail.setRootCauseMessage(ExceptionUtils.getRootCauseMessage(e));
		applicationLogDetail.setRootCauseStackTrace(ExceptionUtils.getRootCauseStackTrace(e)[1]);
		applicationLogDetail.setFullCauseStackTrace(ExceptionUtils.getFullStackTrace(e));
		return applicationLogDetail;
	}

	/**
	 * @param message 
	 * @param applicationLogDetail 
	 * @param e 
	 * @return applicationLogDetail
	 */
	public final ApplicationLogDetail prepareLogDetail(String message, ApplicationLogDetail applicationLogDetail,
			Throwable e)
	{
		applicationLogDetail.setMessage(message);
		applicationLogDetail.setLogDate(new Date());
		applicationLogDetail.setRootCause(ExceptionUtils.getRootCauseMessage(e));
		applicationLogDetail.setRootCauseMessage(ExceptionUtils.getRootCauseMessage(e));
		applicationLogDetail.setRootCauseStackTrace(ExceptionUtils.getRootCauseStackTrace(e)[1]);
		applicationLogDetail.setFullCauseStackTrace(ExceptionUtils.getFullStackTrace(e));
		return applicationLogDetail;
	}

	/**
	 * @return the logDate
	 */
	public Date getLogDate()
	{
		return logDate;
	}

	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Date logDate)
	{
		this.logDate = logDate;
	}

	/**
	 * @return the rootCause
	 */
	public String getRootCause()
	{
		return rootCause;
	}

	/**
	 * @param rootCause the rootCause to set
	 */
	public void setRootCause(String rootCause)
	{
		this.rootCause = rootCause;
	}

	/**
	 * @return the rootCauseMessage
	 */
	public String getRootCauseMessage()
	{
		return rootCauseMessage;
	}

	/**
	 * @param rootCauseMessage the rootCauseMessage to set
	 */
	public void setRootCauseMessage(String rootCauseMessage)
	{
		this.rootCauseMessage = rootCauseMessage;
	}

	/**
	 * @return the rootCauseStackTrace
	 */
	public String getRootCauseStackTrace()
	{
		return rootCauseStackTrace;
	}

	/**
	 * @param rootCauseStackTrace the rootCauseStackTrace to set
	 */
	public void setRootCauseStackTrace(String rootCauseStackTrace)
	{
		this.rootCauseStackTrace = rootCauseStackTrace;
	}

	/**
	 * @return the fullCauseStackTrace
	 */
	public String getFullCauseStackTrace()
	{
		return fullCauseStackTrace;
	}

	/**
	 * @param fullCauseStackTrace the fullCauseStackTrace to set
	 */
	public void setFullCauseStackTrace(String fullCauseStackTrace)
	{
		this.fullCauseStackTrace = fullCauseStackTrace;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType)
	{
		this.errorType = errorType;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType()
	{
		return errorType;
	}

}
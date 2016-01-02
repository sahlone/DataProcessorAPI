/**
 * 
 */
package com.goeuro.api.log;

import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.goeuro.api.data.APIException;

/**
 * @author sahil.lone
 *
 */
public class ApplicationLogger extends Logger
{
	private static String	HARMLESS_ERROR	= "HARMLESS";
	private static String	EXCEPTION_ERROR	= "ERROR";

	protected ApplicationLogger(String name)
	{
		super(name);
	}

	private String getExceptionMessage(String errorType, Object objMessage, Throwable e)
	{
		ApplicationLogDetail applicationLogDetail = new ApplicationLogDetail();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer = stringBuffer.append("----------------" + errorType + "----Debugging Information-----------\n");
		applicationLogDetail.setErrorType(errorType);

		String message = null;
		if (objMessage instanceof String)
		{
			message = objMessage.toString();
		}
		else
		{
			message = "Object Message -> " + objMessage.toString();
		}

		String rootCause = ExceptionUtils.getRootCauseMessage(e);
		//String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
		String fullCauseStackTrace = ExceptionUtils.getFullStackTrace(e);
		if (message != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Message	:").append(message);
			applicationLogDetail.setMessage(message);
		}
		if (rootCause != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Possible Root Cause		:").append(rootCause);
			applicationLogDetail.setRootCause(rootCause);
		}
		if (fullCauseStackTrace != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer
					.append("---------------  COMPLETE STACK TRACE   -------------------------------\n");
			stringBuffer = stringBuffer.append(fullCauseStackTrace);
			stringBuffer = stringBuffer
					.append("---------------  COMPLETE STACK TRACE   -------------------------------");
			applicationLogDetail.setFullCauseStackTrace(fullCauseStackTrace);
		}
		MDC.put("logDetail", applicationLogDetail);
		return stringBuffer.toString();
	}

	private String getExceptionMessage(String errorType, ApplicationLogDetail applicationLogDetail)
	{
		String message = applicationLogDetail.getMessage();
		Date logDate = applicationLogDetail.getLogDate();
		String rootCause = applicationLogDetail.getRootCause();
		String rootCauseMessage = applicationLogDetail.getRootCauseMessage();
		String fullCauseStackTrace = applicationLogDetail.getFullCauseStackTrace();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer = stringBuffer.append("----------------" + errorType + "----Debugging Information-----------\n");

		if (logDate != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Time Stamp(GMT)			:").append(logDate);
		}
		if (rootCauseMessage != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Cause Exception			:").append(rootCauseMessage);
		}
		if (message != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Method Parameters		:").append(message);
		}
		if (rootCause != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer.append("Possible Root Cause		:").append(rootCause);
		}
		if (fullCauseStackTrace != null)
		{
			stringBuffer = stringBuffer.append("\n");
			stringBuffer = stringBuffer
					.append("---------------  COMPLETE STACK TRACE   -------------------------------\n");
			stringBuffer = stringBuffer.append(applicationLogDetail.getFullCauseStackTrace());
			stringBuffer = stringBuffer
					.append("---------------  COMPLETE STACK TRACE   -------------------------------");
		}
		return stringBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Category#error(java.lang.Object, java.lang.Throwable)
	 */
	@Override
	public void error(Object message, Throwable e)
	{
		ApplicationLogDetail applicationLogDetail = (ApplicationLogDetail) MDC.get("logDetail");
		if (applicationLogDetail != null)
		{
			applicationLogDetail.setErrorType(EXCEPTION_ERROR);
			MDC.put("logDetail", applicationLogDetail);
			if (ExceptionUtils.getRootCause(e) instanceof APIException)
			{
				APIException tenantException = (APIException) ExceptionUtils.getRootCause(e);
				if (tenantException.getErrorCode() != null)
				{
					//error(getExceptionMessage(HARMLESS_ERROR, applicationLogDetail));
				}
				else
				{
					error(getExceptionMessage(EXCEPTION_ERROR, applicationLogDetail));
				}
			}

			else
			{
				error(getExceptionMessage(EXCEPTION_ERROR, applicationLogDetail));
			}
		}
		else
		{
			if (ExceptionUtils.getRootCause(e) instanceof APIException)
			{
				APIException apiException = (APIException) ExceptionUtils.getRootCause(e);
				if (apiException.getErrorCode() != null)
				{
					error(getExceptionMessage(HARMLESS_ERROR, message, e));
				}
				else
				{
					error(getExceptionMessage(EXCEPTION_ERROR, message, e));
				}
			}

			else
			{
				error(getExceptionMessage(EXCEPTION_ERROR, message, e));
			}
		}
	}
}

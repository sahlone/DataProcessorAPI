/**
 * 
 */
package com.goeuro.api.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sahil.lone
 *
 */
public enum ResponseStatus
{
	/**
	 * SUCCESS
	 */
	SUCCESS("200", "OK"),
	/**
	 * ACCEPTED
	 */
	ACCEPTED("201", "Accepted"),
	/**
	 * NO_CONTENT
	 */
	NO_CONTENT("204", "NoContent"),
	/**
	 * REQUEST_IN_TRANSITION
	 */
	REQUEST_IN_TRANSITION("280", "Request in Transition"),
	/**
	 * REQUEST_IN_TRANSITION_UNRELIABLE_TRANSPORT
	 */
	REQUEST_IN_TRANSITION_UNRELIABLE_TRANSPORT("281",
			"The request has been forwarded by an intermediate hub using an unreliable transport (such as email)."),
	/**
	 * BAD_REQUEST
	 */
	BAD_REQUEST("400", "Bad Request"),
	/**
	 * UNAUTHORIZED_CREDENTIALS
	 */
	UNAUTHORIZED_CREDENTIALS("401", "Unauthorized Credentials"),
	/**
	 * SERVICE_UNAVAILABLE
	 */
	SERVICE_UNAVAILABLE("503", "Service Unavailable"),

	/**
	 * PAYMENT_REQUIRED
	 */
	PAYMENT_REQUIRED("402", "This Request must include a complete Payment element."),
	/**
	 * FORBIDDEN
	 */
	FORBIDDEN("403", "Insufficient Privileges"),
	/**
	 * PARSING_FAILURE
	 */
	PARSING_FAILURE("406", "Parsing Failure"),
	/**
	 * CONFLICT
	 */
	CONFLICT("409", "Another Request is already in process"),
	/**
	 * PRECONDITION_FAILED
	 */
	PRECONDITION_FAILED("412", "Operation Type is wrong"),
	/**
	 * EXPECTATION_FAILED
	 */
	EXPECTATION_FAILED("417", "Request expectation can not be fulfilled"),
	/**
	 * NOT_IMPLEMENTED
	 */
	NOT_IMPLEMENTED("450", "Server does not handle this type of request"),
	/**
	 * SIGNATURE_REQUIRED
	 */
	SIGNATURE_REQUIRED("475", "Digital Signature not found"),
	/**
	 * SIGNATURE_VERIFICATION_FAILED
	 */
	SIGNATURE_VERIFICATION_FAILED("476", "Unable to validate Digital Signature"),
	/**
	 * SIGNATURE_UNACCEPTABLE
	 */
	SIGNATURE_UNACCEPTABLE("477", "Valid but not acceptable to Reciever"),
	/**
	 * INTERNAL_SERVER_ERROR
	 */
	INTERNAL_SERVER_ERROR("500", "Server unable to process the request"),
	/**
	* UNABLE_TO_REACH_SERVER
	*/
	UNABLE_TO_REACH_SERVER("550", "Unable to reach server"),
	/**
	 * UNABLE_TO_FORWARD_REQUEST
	 */
	UNABLE_TO_FORWARD_REQUEST("551", "Unable to forward Request due to Supplier Misconfiguration"),
	/**
	 * TEMPORARY_SERVER_ERROR
	 */
	TEMPORARY_SERVER_ERROR("560", "Server unavailable or down for maintainence");

	private static Map<String, ResponseStatus>	responseMap	= null;

	private String								statusCode	= null;
	private String								description	= null;
	private String								text		= null;

	private ResponseStatus(String code, String text)
	{
		this.statusCode = code;
		this.text = text;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode()
	{
		return statusCode;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * 
	 * @param code
	 * @return ResponseStatus
	 */
	public static ResponseStatus getCatalogResponseStatus(int code)
	{
		if (responseMap == null)
		{
			responseMap = new HashMap<String, ResponseStatus>();
			for (ResponseStatus responseStatus : ResponseStatus.values())
			{
				responseMap.put(responseStatus.getStatusCode(), responseStatus);
			}
		}
		return responseMap.get(code);
	}
}

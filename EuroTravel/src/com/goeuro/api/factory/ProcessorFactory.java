package com.goeuro.api.factory;

import com.goeuro.api.convertor.JSONProcessor;
import com.goeuro.api.convertor.APIDataProcessor;
import com.goeuro.api.data.APIException;
import com.goeuro.api.data.ProfileType;

public class ProcessorFactory
{

	private static APIDataProcessor<String>	jsonProcessor	= null;

	/**
	 * 
	 * @param profileType
	 * @return Converter
	 * @throws APIException 
	 */
	@SuppressWarnings("rawtypes")
	synchronized public static APIDataProcessor getProcessor(ProfileType profileType) throws APIException
	{
		APIDataProcessor processor = null;
		try
		{

			switch (profileType)
			{
				case JSON:
					processor = getJSONProcessor();
					break;
				default:
					throw new APIException("No Processor found for profile type" + profileType);

			}
		}
		catch (Exception e)
		{
			throw new APIException("No Processor found for profile type" + profileType, e);
		}
		return processor;
	}

	private static APIDataProcessor<String> getJSONProcessor()
	{
		if (jsonProcessor == null)
		{
			jsonProcessor = new JSONProcessor();
		}
		return jsonProcessor;
	}

}

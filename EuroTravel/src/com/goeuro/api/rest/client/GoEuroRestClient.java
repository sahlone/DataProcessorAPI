package com.goeuro.api.rest.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.bo.RestResponse;
import com.goeuro.api.data.ResponseStatus;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GoEuroRestClient
{

	private String					baseUrl		= null;
	private ClientConfig			config		= null;
	private Client					client		= null;
	private WebResource				service		= null;

	private static GoEuroRestClient	restClient	= null;
	private static final String		serverUrl	= "http://api.goeuro.com";
	private static final String		apiPath		= "/api/v2/position/suggest/en/%CITY_NAME%";

	private GoEuroRestClient()
	{
		super();
	}

	private GoEuroRestClient(Properties properties)
	{
		this.baseUrl = properties.getProperty("server-url");
		this.config = new DefaultClientConfig();
		this.client = Client.create(this.config);
		this.service = this.client.resource(this.baseUrl);
	}

	public RestResponse<String> getCityInfo(String city)
	{

		RestResponse<String> result = new RestResponse<String>();
		String path = apiPath.replace("%CITY_NAME%", city);
		try
		{
			String response = (String) this.service.path(path).get(String.class);

			result.setStatusCode(ResponseStatus.SUCCESS.getStatusCode());
			result.setPayLoad(response);
		}

		catch (ClientHandlerException e)
		{
			result.setStatusCode(ResponseStatus.SERVICE_UNAVAILABLE.getStatusCode());
		}
		catch (Exception e)
		{
			result.setStatusCode(ResponseStatus.INTERNAL_SERVER_ERROR.getStatusCode());
			List<Object> errorParams = new ArrayList<Object>();
			errorParams.add(e.getMessage());
			errorParams.add(e);
			result.setErrorParams(errorParams);
		}
		return result;
	}

	public static GoEuroRestClient getClient()
	{
		if (null == restClient)
		{
			synchronized ("Client".intern())
			{
				if (null == restClient)
				{
					Properties properties = new Properties();
					properties.put("server-url", serverUrl);
					restClient = new GoEuroRestClient(properties);
				}
			}
		}
		return restClient;
	}
}

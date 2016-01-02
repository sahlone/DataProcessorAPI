package com.goeuro.api.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.bo.RestResponse;
import com.goeuro.api.convertor.APIDataProcessor;
import com.goeuro.api.data.APIException;
import com.goeuro.api.data.ProfileType;
import com.goeuro.api.data.ResponseStatus;
import com.goeuro.api.factory.ProcessorFactory;
import com.goeuro.api.file.FileWriter;
import com.goeuro.api.file.SeparatedTextFileWriter;
import com.goeuro.api.rest.client.GoEuroRestClient;
import com.goeuro.api.service.CityInfoService;

public class CityInfoServiceImpl implements CityInfoService
{
	private static final String[]	headers	= new String[] { "_id", "name", "latitude", "longitude" };

	@Override
	@SuppressWarnings("unchecked")
	public List<CityInfo> getCityInfo(String cityName) throws APIException
	{
		List<CityInfo> cityInfo = null;
		try
		{
			GoEuroRestClient euroRestClient = GoEuroRestClient.getClient();
			RestResponse<String> restResponse = euroRestClient.getCityInfo(cityName);
			if (restResponse.getStatusCode().equals(ResponseStatus.SUCCESS.getStatusCode()))
			{
				APIDataProcessor<String> apiDataProcessor = ProcessorFactory.getProcessor(ProfileType.JSON);
				cityInfo = apiDataProcessor.convertToObject(restResponse.getPayLoad());
			}
			else
			{
				throw new APIException(APIException.ERR_SYSTEM_ERROR + restResponse.getStatusCode()
						+ restResponse.getPayLoad() + restResponse.getErrorParams().toString());
			}
		}
		catch (Exception e)
		{
			throw new APIException(APIException.ERR_SYSTEM_ERROR, e);
		}
		return cityInfo;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void printCityInfo(String cityName, List<CityInfo> info) throws APIException
	{
		try
		{
			File file = new File("Data");
			if (!file.exists())
			{
				file.mkdir();
			}
		}
		catch (Exception e)
		{
			throw new APIException(
					"Not able to create directory for data storage. Please look into system permissions.", e);
		}
		try (OutputStream outputStream = new FileOutputStream(new File("Data/City_info_" + cityName + ".csv"));
				FileWriter fileWriter = new SeparatedTextFileWriter(outputStream, ',');)
		{

			List<Object[]> data = new ArrayList<Object[]>();
			data.add(headers);
			for (CityInfo cityInfo : info)
			{
				String[] row = new String[] { getStringValue(cityInfo.get_id()), getStringValue(cityInfo.getName()),
						getStringValue(cityInfo.getGeo_position().getLatitude()),
						getStringValue(cityInfo.getGeo_position().getLongitude()) };
				data.add(row);
			}
			fileWriter.writeAll(data);

			fileWriter.close();
		}
		catch (Exception e)
		{
			throw new APIException(e);
		}
	}

	private String getStringValue(Object value) throws APIException
	{
		try
		{
			if (null == value)
			{
				return "-";
			}
			else
			{
				return String.valueOf(value);
			}
		}
		catch (Exception e)
		{
			throw new APIException(APIException.ERR_SYSTEM_ERROR, e);
		}
	}
}

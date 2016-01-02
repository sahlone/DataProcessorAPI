package com.goeuro.api.convertor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.data.APIException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JSONProcessor implements APIDataProcessor<String>
{

	@Override
	public List<CityInfo> convertToObject(String json) throws APIException
	{
		List<CityInfo> cityInfo = null;
		try
		{
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			Type objectType = new TypeToken<ArrayList<CityInfo>>()
			{}.getType();
			cityInfo = gson.fromJson(json, objectType);
		}
		catch (Exception e)
		{
			throw new APIException(APIException.ERR_SYSTEM_ERROR, e);
		}
		return cityInfo;
	}
}

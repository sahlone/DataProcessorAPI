package com.goeuro.api.convertor;

import java.util.List;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.data.APIException;

public interface APIDataProcessor<T>
{
	public List<CityInfo> convertToObject(T value) throws APIException;
}

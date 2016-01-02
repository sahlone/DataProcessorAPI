package com.goeuro.api.service;

import java.util.List;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.data.APIException;

public interface CityInfoService
{

	/**
	 * @param cityName
	 * @return
	 * @throws APIException
	 */
	public List<CityInfo> getCityInfo(String cityName) throws APIException;

	/**
	 * @param cityInfo
	 * @return
	 * @throws APIException
	 */
	public void printCityInfo(String cityName, List<CityInfo> cityInfo) throws APIException;
}

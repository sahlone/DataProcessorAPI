package com.goeuro.api.bo;

import java.io.Serializable;

/**
 * @author sahil.lone
 *
 */
public class CityInfo implements Serializable
{

	private static final String	LOCATION			= "LOCATION";

	private Integer				_id					= -1;
	private String				key					= null;
	private String				name				= null;
	private String				fullName			= null;
	private String				iata_airport_code	= null;

	private String				type				= LOCATION;
	private String				country				= null;
	private Integer				location_id			= null;
	private Boolean				inEurope			= null;
	private String				countryCode			= null;
	private Double				distance			= null;
	private GeoPosition			geo_position		= null;

	public CityInfo()
	{
		super();
	}

	public Integer get_id()
	{
		return _id;
	}

	public void set_id(Integer _id)
	{
		this._id = _id;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getIata_airport_code()
	{
		return iata_airport_code;
	}

	public void setIata_airport_code(String iata_airport_code)
	{
		this.iata_airport_code = iata_airport_code;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Integer getLocation_id()
	{
		return location_id;
	}

	public void setLocation_id(Integer location_id)
	{
		this.location_id = location_id;
	}

	public Boolean getInEurope()
	{
		return inEurope;
	}

	public void setInEurope(Boolean inEurope)
	{
		this.inEurope = inEurope;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	public Double getDistance()
	{
		return distance;
	}

	public void setDistance(Double distance)
	{
		this.distance = distance;
	}

	public GeoPosition getGeo_position()
	{
		return geo_position;
	}

	public void setGeo_position(GeoPosition geo_position)
	{
		this.geo_position = geo_position;
	}

}

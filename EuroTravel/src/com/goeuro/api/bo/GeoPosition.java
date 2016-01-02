package com.goeuro.api.bo;

import java.io.Serializable;

/**
 * @author sahil.lone
 *
 */
public class GeoPosition implements Serializable
{

	private Double	latitude	= null;
	private Double	longitude	= null;

	public GeoPosition(Double latitude, Double longitude)
	{
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

}

package com.goeuro.api.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.goeuro.api.bo.CityInfo;
import com.goeuro.api.log.ApplicationLogger;
import com.goeuro.api.log.ApplicationLoggerFactory;
import com.goeuro.api.service.CityInfoService;
import com.goeuro.api.service.impl.CityInfoServiceImpl;

/**
 * @author sahil.lone
 *
 */
public class GoEuroApplication
{
	private static final Logger	logger	= Logger.getLogger(ApplicationLogger.class.getName(),
												new ApplicationLoggerFactory());

	public static void main(String[] args)
	{
		List<CityInfo> cityInfo = null;
		String cityName = "";
		try
		{
			CityInfoService cityInfoService = new CityInfoServiceImpl();
			System.out.println("CSV Files will be created under 'Data' folder at JVM run path. ");
			if (args.length < 1 || StringUtils.isBlank(cityName))
			{
				System.out.println("Please enter valid city name as argument to program. ");
			}
			else
			{
				cityName = args[0];
				cityInfo = cityInfoService.getCityInfo(cityName);
				cityInfoService.printCityInfo(cityName, cityInfo);
				System.out.println("Sucessfull created CSV file for the city : " + cityName);
			}

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

			main: while (true)
			{
				System.out.println("Enter City name  or press 0 to exit. ");
				cityName = bufferRead.readLine();

				if (StringUtils.isBlank(cityName))
				{
					System.out.println("Please enter valid input");
				}
				else
				{
					switch (cityName)
					{
						case "0":
							break main;
						default:
							cityInfo = cityInfoService.getCityInfo(cityName);
							cityInfoService.printCityInfo(cityName, cityInfo);
							System.out.println("Sucessfull created CSV file for the city : " + cityName);
							break;
					}

				}
			}
		}
		catch (Exception e)
		{
			logger.error("Error while getting Info For city :" + cityName, e);
			MDC.remove("logDetail");
			System.out.println("OOps--------Something went wrong. Please try again.");
		}

	}
}

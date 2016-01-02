/**
 * 
 */
package com.goeuro.api.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * @author sahil.lone
 *
 */
public class ApplicationLoggerFactory implements LoggerFactory
{

	public Logger makeNewLoggerInstance(String name)
	{
		return new ApplicationLogger(name);
	}

}

/**
 * 
 */
package com.goeuro.api.file;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author sahil.lone
 *
 */
public class SeparatedTextFileWriter implements FileWriter
{

	private CSVWriter	csvWriter	= null;

	/**
	 * @param outputStream
	 * @param fieldDelimiter
	 * @throws UnsupportedEncodingException 
	 */
	public SeparatedTextFileWriter(OutputStream outputStream, char fieldDelimiter) throws UnsupportedEncodingException
	{
		csvWriter = new CSVWriter(new OutputStreamWriter(outputStream), fieldDelimiter);
	}

	@Override
	public void close() throws IOException
	{
		if (csvWriter != null)
		{
			csvWriter.flush();
			csvWriter.close();
			csvWriter = null;
		}
	}

	public void writeNext(Object[] rowData) throws IOException
	{
		csvWriter.writeNext((String[]) rowData);
	}

	public void writeAll(List<Object[]> allRowsData)
	{
		List<String[]> stringList = new ArrayList<String[]>();
		for (Object[] obj : allRowsData)
		{
			stringList.add((String[]) obj);
		}
		csvWriter.writeAll(stringList);
	}

}

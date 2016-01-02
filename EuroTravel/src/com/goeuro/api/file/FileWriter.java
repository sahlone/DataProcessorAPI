/**
 * 
 */
package com.goeuro.api.file;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @author sahil.lone
 *
 */
public interface FileWriter extends Closeable
{
	/**
	 * <pre>
	 * Writes the string[] data to the file.  
	 * </pre>
	 * @param rowData 
	 * @throws IOException
	 */
	public void writeNext(Object[] rowData) throws IOException;

	/**
	 * <pre>
	 * Writes all Data to the file. 
	 * </pre>
	 * @param allRowsData
	 * @throws IOException 
	 */
	public void writeAll(List<Object[]> allRowsData) throws IOException;

	/**
	 * <pre>
	 * close the file
	 * </pre>
	 * @throws IOException
	 */
	public void close() throws IOException;
}

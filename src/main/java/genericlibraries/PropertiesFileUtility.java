package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all reusable methods to perform operations on Properties file
 * @author DELL
 *
 */
public class PropertiesFileUtility 
{
	private Properties property;
	/**
	 * This method is used to initialize Properties file
	 * @param path
	 */
	public void propertyFileInitialization(String path) 
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch properties
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}

}

package main.epam.tc.gmail.propertyProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyProvider {
	
	private final static Logger LOG = LogManager.getRootLogger();
	private Properties properties;
	private String filename;

	public PropertyProvider(String filename){
		this.filename = filename;
		properties = setProperties();
	}
	
	public String getProperty(String property) {
		String value = properties.getProperty(property);
		return value;
	}
	
	private Properties setProperties() {
		String path = ".\\src\\resources\\" + filename + ".properties";
		File file = new File(path);
		Properties properties = new Properties();
		if (!file.isDirectory()) {
			try(FileInputStream input = new FileInputStream(file.getAbsolutePath())){
				properties.load(input);
			} 
			catch (IOException e) {
				LOG.error("Problems with loading properties from: " + path);
			}
		}
		return properties;
	}
	
}

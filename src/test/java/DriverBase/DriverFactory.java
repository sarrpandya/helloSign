package DriverBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

	public static String envName = System.getProperty("envName");
	public static String browser = System.getProperty("browser");
	public static String BASE_URI = null;
	public static String value = null;
	public static final Properties configProp = new Properties();

	static {
		if (envName != null) {
			if (envName.equalsIgnoreCase("qa")) {
				Properties prop = new Properties();
				InputStream input = null;
				try {
					input = new FileInputStream(".//env//qa.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					prop.load(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(prop.getProperty("Base_url"));
				value = prop.getProperty("Base_url");
				BASE_URI = value;
			}
		}

	}
}

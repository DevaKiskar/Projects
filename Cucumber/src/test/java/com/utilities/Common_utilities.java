package com.utilities;

import java.io.FileReader;
import java.util.Properties;

import storeconfigvalue.Config_prop_store;

public class Common_utilities {

	public void loadproperties() {
		/*FileReader reader = null;
		try {
			reader = new FileReader("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Config_prop_store.Web_url =properties.getProperty("Web_url");
		Config_prop_store.chrome_browser =properties.getProperty("chrome_browser"); 
		Config_prop_store.user_name =properties.getProperty("user_name");
		Config_prop_store.password =properties.getProperty("password");
		Config_prop_store.google_driver_location =properties.getProperty("google_driver_location");
		Config_prop_store.firefox_driver_location =properties.getProperty("firefox_driver_location");
		Config_prop_store.edge_driver_location =properties.getProperty("edge_driver_location");
	}
}

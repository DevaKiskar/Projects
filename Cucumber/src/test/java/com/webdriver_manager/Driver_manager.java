package com.webdriver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import storeconfigvalue.Config_prop_store;

public class Driver_manager {
public static WebDriver driver=null;

public static void launchbrowser1() {
	try {
		switch (Config_prop_store.chrome_browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",Config_prop_store.google_driver_location);
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Config_prop_store.firefox_driver_location);
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.ie.driver", Config_prop_store.edge_driver_location);
			driver = new EdgeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver",Config_prop_store.google_driver_location);
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			break;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}



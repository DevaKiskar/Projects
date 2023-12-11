package stepdefinition;

import org.openqa.selenium.WebDriver;
import com.utilities.Common_utilities;
import com.webdriver_manager.Driver_manager;

import io.cucumber.java.Before;

public class Common_Step_Definition {

	public static WebDriver driver;

	@Before
	public void beforescenrio() {
		try {
			Common_utilities common_utilities = new Common_utilities();
			common_utilities.loadproperties();
			if (driver == null) {
				Driver_manager.launchbrowser1();
			}
		} catch (Exception r) {
			r.printStackTrace();
		}
	}

	
}

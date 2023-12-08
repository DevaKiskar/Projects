package design_pattern.pagefactory_design_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// Instantiate the chrome driver.
		System.getProperty("C:\\Users\\ADMIN\\Desktop\\AutomationGit\\pagefactory_design_pattern\\src\\test\\EdgeDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage lp = new LoginPage(driver);

		// Maximize the window
		driver.manage().window().maximize();
		
		lp.check_Logo();

		lp.setname("Admin");

		lp.setpassword("admin123");

		lp.click_login_btn();
		
		

		driver.quit();

	}

}

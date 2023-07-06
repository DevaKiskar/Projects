package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sprint1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// WebDriverManager().chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		/*
		 * driver.get("https://www.amazon.com/"); String
		 * Expected_URL=driver.getCurrentUrl(); String
		 * Actual_URL="https://www.amazon.com/";
		 * 
		 * if (("https://www.amazon.com/").equals(Expected_URL)) {
		 * System.out.println("URL Matching"); } else {
		 * System.out.println("Not Matching"); }
		 */
		int bugcount=1;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String file = System.getProperty("user.dir") + "\\Excel_DataSet\\FD_Interest_calc.xlsx";

		int tot_rows = Sprint2.getRow(file, "Sheet1");
		// Read cell data from excel.
		for (int row = 1; row <= tot_rows; row++) {
			String principal = Sprint2.getCellData(file, "Sheet1", row, 0);
			String Rate_Of_Interset = Sprint2.getCellData(file, "Sheet1", row, 1);
			String Period1 = Sprint2.getCellData(file, "Sheet1", row, 2);
			String Period2 = Sprint2.getCellData(file, "Sheet1", row, 3);
			String Frequency = Sprint2.getCellData(file, "Sheet1", row, 4);
			String Expected_Maturity_Value = Sprint2.getCellData(file, "Sheet1", row, 5);

			// pass data to application.
			driver.findElement(By.id("principal")).sendKeys(principal);
			driver.findElement(By.id("interest")).sendKeys(Rate_Of_Interset);
			driver.findElement(By.id("tenure")).sendKeys(Period1);
			driver.findElement(By.id("tenurePeriod")).sendKeys(Period2);
			Select period_dropdown = new Select(driver.findElement(By.id("tenurePeriod")));
			period_dropdown.selectByVisibleText(Period2);
			Select frequency_dropdown = new Select(driver.findElement(By.id("frequency")));
			frequency_dropdown.selectByVisibleText(Frequency);

			//Click on calculate button...
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement cal_btn = driver.findElement(
					By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
			js.executeScript("arguments[0].click();", cal_btn);
			
		//	driver.findElement(By.xpath("//*[@onclick='return getfdMatVal(this);']")).click();
			Thread.sleep(5000);
			
			//Actual_Maturity_Value
			String Actual_Maturity_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			// validate maturity value should be same or not.
			if (Double.parseDouble(Expected_Maturity_Value) == Double.parseDouble(Actual_Maturity_Value)) {
				System.out.println("Test passed");
				Sprint2.setcellvalue(file, "Sheet1", row, 7, "passed");
				Sprint2.setcellvalue(file, "Sheet1", row, 8, "	-");
				
			} else {
				
				System.out.println("Test failed");
				Sprint2.setcellvalue(file, "Sheet1", row, 7, "failed");
				Sprint2.setcellvalue(file, "Sheet1", row, 8, "Bug"+bugcount++);
			} 
			Thread.sleep(5000);

			WebElement clr_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clr_btn);
		}

	}
}

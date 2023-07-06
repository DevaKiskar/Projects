package datadriventest;

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

		public static void main(String[] args) throws IOException, InterruptedException  {
			
			int bugcount=1;
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(
					"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
			driver.manage().window().maximize();
			String file=System.getProperty("C:\\Users\\ADMIN\\eclipse-workspace\\datadriventest\\exceldata\\FD_Interest_calc.xlsx");
			
			int tot_Rows = Sprint2.getRow(file, "Sheet1");
			// Read cell data from excel.
			for (int row = 1; row <= tot_Rows; row++) {
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
				
				//click clear button.
				WebElement clr_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
				js.executeScript("arguments[0].click();", clr_btn);
			}

		}
	}
	




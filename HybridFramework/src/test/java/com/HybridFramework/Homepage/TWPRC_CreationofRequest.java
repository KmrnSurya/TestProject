package com.HybridFramework.Homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HybridFramework.testBase.TestBase;



public class TWPRC_CreationofRequest extends TestBase
{
	
	public static final Logger logger = Logger.getLogger(TWPRC_CreationofRequest.class.getName());
	
	@Test
	public void testlogin() throws IOException, InterruptedException
	{
		loadpropertiesFile();
		getBrowser("Chrome");
		
		logger.info("Launching browser");
		driver.get("http://online-paf-qa.uspgi.com/PAF/Pages/Home.aspx");
		driver.manage().window().maximize();
		
		logger.info("Moving to PAF Requests");
		WebElement web01 = driver.findElement(By.linkText("PAF Requests"));
		WaitForElements(driver, 10000, web01);
		web01.click();
		
		logger.info("Opening the request");
		implicitWait(7000);
		driver.findElement(By.xpath("//*[@id=\'PAFType1_RowSelector0\']")).click();
		
	
		logger.info("Clicking On New Request");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement web05 = driver.findElement(By.xpath("//*[text()='New PAF Request']"));
		web05.click();
					
		logger.info("Selecting Receiving Manager");
		implicitWait(6000);
		driver.findElement(By.xpath("//*[@id='PAFType1_Item4_ShowLookupLink']")).click();
		
		logger.info("Passing Receiving Manager name");
		implicitWait(6000);
		WebElement web03 = driver.findElement(By.xpath("//*[@id='PAFType1_LookupView4_QuickFind']"));
		
		web03.sendKeys("Allen, earline");
		
		web03.sendKeys(Keys.ENTER);
		
		logger.info("Receiving Manager being selected");
		Thread.sleep(4000);
		WebElement web04 = driver.findElement(By.xpath("//*[text()='Earline']"));
		
		Actions builder = new Actions(driver);
		
		Action doubleclick = builder.doubleClick(web04).build();
		doubleclick.perform();
		
		logger.info("Calendar box");
		Thread.sleep(5000);
		WebElement web06 = driver.findElement(By.xpath("//*[@id=\"PAFType1_Item6_Button\"]"));
		web06.click();
		
		implicitWait(10000);
		WebElement web07 = driver.findElement(By.xpath("//*[@id=\'PAFType1_Item6$CalendarBehavior_day_1_1\']"));
		web07.click();
		
		logger.info("Clicking Ok");
		
		implicitWait(10000);
		WebElement web08 = driver.findElement(By.xpath("//button[text()='OK']"));
		web08.click();
		
		logger.info("Clicking Add Employee Details section");
		implicitWait(10000);
		WebElement web09 = driver.findElement(By.xpath("//*[@id=\"PAFType1Details$ActionBar\"]/table/tbody/tr/td[4]/span/a"));
		web09.click();
		
		logger.info("Inserting Employee");
		implicitWait(10000);
		WebElement web10 = driver.findElement(By.xpath("//*[@id=\"PAFType1Details_Item3_ShowLookupLink\"]"));
		web10.click();
		
		
		logger.info("Passing Employee name");
		implicitWait(9000);
		WebElement web11 = driver.findElement(By.xpath("//*[@id=\"PAFType1Details_LookupView3_QuickFind\"]"));
		
		web11.sendKeys("Raymond, Cassandra");
		
		web11.sendKeys(Keys.ENTER);
		
		logger.info("Employee Name being selected");
		Thread.sleep(4000);
		WebElement web12 = driver.findElement(By.xpath("//*[@id=\"PAFType1Details_LookupView3_Row0\"]/td[2]"));
		
		
		Actions builder01 = new Actions(driver);
		Action doubleclick01 = builder01.doubleClick(web12).build();
		doubleclick01.perform();	
		
		
		logger.info("Inserting the Employee");
		implicitWait(10000);
		WebElement web13 = driver.findElement(By.xpath("//button[text()='Insert']"));
		web13.click();
		
		
		logger.info("Submitting the request");
		implicitWait(10000);
		WebElement web14 = driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionBar\"]/table/tbody/tr/td[3]/span/a"));
		web14.click();
		
		logger.info("Closing the request finally");
		Thread.sleep(3000);
		WebElement web15 = driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionButtons$Bottom\"]/button"));
		web15.click();
		
//		driver.findElement(By.xpath("//*[@id=\"HoverMonitor$PAFType1$RowSelector$0$Item$0\"]/span/span/span")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionBar\"]/table/tbody/tr/td[1]")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionBar\"]/table/tbody/tr/td[1]/span/a")).click();
		
			
		//*[@id="PAFType1$ActionBar"]/table/tbody/tr/td[1]/span/a
		
//		WebElement selectdrop = driver.findElement(By.xpath(''//*[@id="PAFType1_RowSelector0']"));
//
//		Actions action = new Actions(driver);
//	
//		action.moveToElement(selectdrop).click();
//		
		
//		driver.findElement(By.xpath("//div[@style='z-index:101003']")).click();
		
//		driver.findElement(By.xpath("//div[@id='PAFType1_RowSelector0']/a[@href='#']")).click();
		
//		public boolean retryingFindClick(WebElement web05)
//		{
//		boolean result = false;
//		int attempts = 0;
//		while(attempts < 2)
//		{
//			try 
//			{
//				web06.click();
//				result = true;
//				break;
//			}catch(StaleElementReferenceException e) 
//				{
//					
//				}
//		attempts++;
//		}
//		return result;
//		}
	
}
}
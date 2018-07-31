package com.HybridFramework.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.HybridFramework.testBase.TestBase;



public class Scenario01 extends TestBase
{
	
	@Test
	public void testlogin()
	{
		getBrowser("Chrome");
		driver.get("http://online-paf-qa.uspgi.com/PAF/Pages/Home.aspx");
		driver.findElement(By.linkText("PAF Requests")).click();
		
		driver.findElement(By.xpath("//*[@id=\"PAFType1_RowSelector0\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"HoverMonitor$PAFType1$RowSelector$0$Item$0\"]/span/span/span")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionBar\"]/table/tbody/tr/td[1]")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"PAFType1$ActionBar\"]/table/tbody/tr/td[1]/span/a")).click();
		
			
		//*[@id="PAFType1$ActionBar"]/table/tbody/tr/td[1]/span/a
		
//		WebElement selectdrop = driver.findElement(By.xpath("//*[@id=\"PAFType1_RowSelector0\"]/a"));
//		
//		Actions action = new Actions(driver);
//	
//		action.moveToElement(selectdrop).click();
//		
		
//		driver.findElement(By.xpath("//div[@style='z-index:101003']")).click();
		
//		driver.findElement(By.xpath("//div[@id='PAFType1_RowSelector0']/a[@href='#']")).click();
		
	
	
}
}
package com.HybridFramework.Homepage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.HybridFramework.testBase.TestBase;

public class ParallelTest extends TestBase
{
	@Test
	public void testlogin()
	{
		driver.get("http://online-paf-qa.uspgi.com/PAF/Pages/Home.aspx");
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("PAF Requests")).click();
		driver.findElement(By.xpath("//*[@id=\"PAFType1_RowSelector0\"]/a")).click();
//		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		
//		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("kmrnsurya");
//		driver.findElement(By.xpath("<input type=\"password\" name=\"password\" size=\"8\" tabindex=\"2\" maxlength=\"8\">")).sendKeys("password");
		
	}	
	
	
}

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
		driver.get("http://thedemosite.co.uk/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("kmrnsurya");
		driver.findElement(By.xpath("<input type=\"password\" name=\"password\" size=\"8\" tabindex=\"2\" maxlength=\"8\">")).sendKeys("password");
		driver.findElement(By.xpath("<input type=\"button\" name=\"FormsButton2\" value=\"Test Login\" onclick=\"validateForm()\" tabindex=\"3\" style=\"font-family: Verdana; font-size: 8pt\">")).click();
	}	
	
	
}

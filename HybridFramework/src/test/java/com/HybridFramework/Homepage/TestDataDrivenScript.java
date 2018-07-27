package com.HybridFramework.Homepage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.HybridFramework.testBase.TestBase;

public class TestDataDrivenScript extends TestBase
{

	@DataProvider(name="testData")
	public Object[][] datasoure()
	{
		logger.info("Retriving Data from Excel_TestNg");
		return getData("TestData.xlsx", "LoginTestData");
	}

	@Test(dataProvider="testData")
	public void testLogin(String username, String password, String runMode)
	{
		logger.info("Reading Data from excel_TestNG");
		System.out.println("userName:-" +username);
		System.out.println("password:-" +password);
		System.out.println("runMode:-" +runMode);
	}

}	
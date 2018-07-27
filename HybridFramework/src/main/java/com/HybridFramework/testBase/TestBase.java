package com.HybridFramework.testBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.HybridFramework.excelReader.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestBase
{
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	
	public ExcelReader excelreader;
	
	static
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\com\\HybridFramework\\Reports\\test"+formater.format(calendar.getTime())+".html",false);
	}
	
	public void getresult(ITestResult result) throws IOException
	{
	if(result.getStatus() == ITestResult.SUCCESS){
		test.log(LogStatus.PASS, result.getName() + "Test is Pass");
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, result.getName() + "The result is Skipped & the reason is:-" + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getName() + "Test is Failed" + result.getThrowable());
			String screen = getScreenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		}
		if(result.getStatus() == ITestResult.STARTED){
			test.log(LogStatus.INFO, result.getName() + "Test is Started");
		}
	}


	public void afterMethod(ITestResult result) throws IOException
	{
		getresult(result);
	}
		
	
	
	public void beforemethod(Method result)
	{	
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "Test Started");
	}
	
//	@AfterClass(alwaysRun = true)
//	public void endTest()
//	{
//		driver.quit();
//		extent.endTest(test);
//		extent.flush();
//	}
	
	@AfterClass
	public void closebrowser()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
	
	@BeforeTest
	@Parameters("browser")
	public void getBrowser(String browser)
	{
		if(System.getProperty("os.name").contains("Windows"))
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			}	
		}
	}
	
	
	public void loadpropertiesFile() throws IOException
	{
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\HybridFramework\\config\\config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		logger.info("Loading config properties");
		
		f1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\HybridFramework\\config\\or.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		logger.info("Loading or properties");
	}
	
	
	public String getScreenshot(String imageName) throws IOException
	{
		if(imageName.equals(""))
		{
			imageName = "blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String imagelocation = System.getProperty("user.dir")+"\\src\\main\\java\\com\\HybridFramework\\screenshot\\";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation + imageName +"_"+ formater.format(calender.getTime()) + ".png";
		File destFile = new File(actualImageName);
		
		FileUtils.copyFile(image, destFile);
		return actualImageName;
	}
	
	public WebElement WaitForElements(WebDriver driver, long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement WaitForElementsWithPollingInterval(WebDriver driver, long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void implicittWait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public String[][] getData(String excelName, String sheetname)
	{
		String excellocation = System.getProperty("user.dir") + "\\src\\main\\java\\com\\HybridFramework\\data\\"+excelName;
		excelreader = new ExcelReader();
		return excelreader.getExcelData(excellocation, sheetname);
	}
		
	public static void main(String[] args) throws IOException
	{
			TestBase test = new TestBase();
			test.loadpropertiesFile();
			System.out.println(test.OR.getProperty("username"));
	}

}


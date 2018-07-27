package Interface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		Set<String> windowsID = driver.getWindowHandles();
		Iterator itr = windowsID.iterator();
		ArrayList<String> ids = new ArrayList<String>();
		
		while(itr.hasNext())
		{
			ids.add(itr.next());
		}
		
		driver.switchTo().window(ids.get(3));
		
		
		
		
	}

}

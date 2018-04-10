package basePageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ZeDeliveryBase 
{


	protected WebDriver driver;
	
	public ZeDeliveryBase(WebDriver driver) {
		this.driver = driver; 
	}
	
	public ZeDeliveryBase() { 
		System.setProperty("webdriver.chrome.driver", "plugins\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		this.driver.manage().deleteAllCookies();
	}
	
	public WebDriver getDriver() { 
		return driver;
	}

	
	public void closeAPP() { 
		getDriver().quit();
	}
	
public static boolean waitForElement(WebDriver _driver,By by, boolean clickableObject) 
{
		
		try {
			WebDriverWait wait = new WebDriverWait(_driver,10);
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		     	
			if (clickableObject){
		        wait.until(ExpectedConditions.elementToBeClickable(by));
		    }
		    return true;
		}
		catch (Exception e) {
		return false;
		}

	}



}

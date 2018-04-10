package basePageObjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage extends ZeDeliveryBase
{
	

	
	public BasePage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	public  BasePage navigateToSite(String url)
	{
		System.out.println("navigating to: " + url);
		driver.get(url);
		return this;
		
	}
	


	public  BasePage clickInTheButton(String button) throws IOException
	{
		System.out.println("clicking in: " + button);
		waitForElement(this.driver,By.id(button) , true);
		driver.findElement(By.id(button)).click();
		takeScreenShot("Clicking");
		return this;
		
	}
	public  void sendSapce() throws AWTException, InterruptedException
	{
		System.out.println("sending space key");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
		
	}
	
	public void sendText(String field, String value) throws IOException
	{
		System.out.println("filling in: " + field + " with the value: " + value);
		waitForElement(this.driver,By.id(field) , true);
		driver.findElement(By.id(field)).sendKeys(value);
		takeScreenShot("Filling text");
		
	}
	public void sendTextByCss(String field, String value) throws IOException
	{

		System.out.println("filling in: " + field + " with the value: " + value);
		waitForElement(this.driver,By.cssSelector(field) , true);
		System.out.println("keys: " + driver.findElements(By.cssSelector(field)).size());
		driver.findElement(By.cssSelector(field)).sendKeys(value);
		takeScreenShot("Filling text");
		
	}
	
	public void sendTextByXpath(String field, String value) throws IOException
	{
		System.out.println("filling in: " + field + " with the value: " + value);
		waitForElement(this.driver,By.xpath(field) , true);
		driver.findElement(By.xpath(field)).sendKeys(value);
		takeScreenShot("Filling text");
		
	}
	public void switchFrame(String frame)
	{
		driver.switchTo().frame(frame);
	}
	
	public  void clickInTheButtonByXpath(String button) 
	{
		System.out.println("clicking in: " + button);
		waitForElement(this.driver,By.xpath(button), true);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		
		for (WebElement w: driver.findElements(By.xpath(button)))
		{ 
			
			if(w.isEnabled())
			{
				try 
				{
					scrollTo(w);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(button)));
					w.findElement(By.xpath(button)).click();
					takeScreenShot("clicking");
					break;
					
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				
			}
			


		}
		
		
		
		
	}
	
	public String getText(String field) throws IOException
	{
		System.out.println("getting text from: " + field);
		if(!driver.findElements(By.xpath(field)).isEmpty())
		{
		takeScreenShot("clicking");
		return driver.findElement(By.xpath(field)).getText();
		
		}
		return "";
		
	}
	

	public void scrollTo (WebElement w) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0])", w.getLocation().y);
		Thread.sleep(1000);
	} 
	
	public  void clickInTheButtonByCss(String button) throws IOException
	{	

		System.out.println("clicking in: " + button);
		waitForElement(this.driver,By.cssSelector(button) , true);
		driver.findElement(By.cssSelector(button)).click();
		takeScreenShot("clicking");
		
		
	}
	
	public void takeScreenShot(String FileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fullPath = System.getProperty("user.dir") +"/Screenshots/" + getDateTime() + FileName + ".png";
		FileUtils.copyFile(src, new File(fullPath));
	}
	
	public String getDateTime()  
	{  
	    DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");  
	   
	    df.setTimeZone(TimeZone.getDefault());
	    return df.format(new Date());  
	}  

	
}

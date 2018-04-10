package pageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basePageObjects.BasePage;

public class HomePage 
{
	private BasePage bp;

	
	public HomePage(WebDriver driver)
	{
		bp = new BasePage(driver);
	}
	public void navigateToHome()
	{
		bp.navigateToSite("http://www.ze.delivery");
		bp.clickInTheButtonByXpath("//*[@id='" + "btn-age-yes" + "']");
	}
	
	public void insertAdress() throws InterruptedException, AWTException, IOException
	{
		
		
			
		bp.clickInTheButton("pacInput");
		bp.sendText("pacInput", "Avenida Paulista");
		bp.clickInTheButton("pacInput");
		bp.sendSapce();
		bp.clickInTheButtonByCss("html > body > div:nth-of-type(5) > div");
		bp.sendText("numberInput", "1000");
		bp.sendTextByXpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]", "apt 1");
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]");
		
	}
	
	
	
}

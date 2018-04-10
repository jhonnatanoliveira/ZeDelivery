package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basePageObjects.BasePage;

public class FinalizePurchase 
{

	private BasePage bp;
	
	public FinalizePurchase(WebDriver driver)
	{
		bp = new BasePage(driver);
		
	}
	
	public void Finalize() throws IOException
	{
		bp.clickInTheButtonByXpath("//*[@id=\"box-payment\"]/div/div/div[1]/div/label/div/div[4]");
		bp.clickInTheButtonByXpath("//*[@id=\"box-payment\"]/div/div/div[2]/div/label/div/div[4]");
		bp.clickInTheButtonByXpath("//*[@id=\"box-payment\"]/div/div/div[3]/div/label/div/div[4]");
		bp.clickInTheButtonByXpath("//*[@id=\"box-delivery\"]/div/div[1]/div[2]/div/label");
		bp.clickInTheButtonByXpath("//*[@id=\"box-delivery\"]/div/div[1]/div[3]/div/label");
		bp.clickInTheButtonByXpath("//*[@id=\"box-delivery\"]/div/div[1]/div[1]/div/label");
		bp.sendText("comment-textarea", "description");
		
		
	}

}

package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basePageObjects.BasePage;

public class LoginPage 
{

	private BasePage bp;
	
	public LoginPage(WebDriver driver)
	{
		bp = new BasePage(driver);
	}
	
	public void login() throws IOException
	{
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div[1]/a/div");
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div/div/div/div[2]/div[1]/div[3]/span");
		bp.sendTextByXpath("//*[@id=\"app\"]/div/div/div/div[2]/form/div[1]/div/div/input", "jhonnatanpatrick@gmail.com");
		bp.sendTextByXpath("//*[@id=\"app\"]/div/div/div/div[2]/form/div[2]/div/div/input", "Teste@123");
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div/div/div/div[2]/form/div[3]/div");
		
	}

}

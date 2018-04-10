package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basePageObjects.BasePage;

public class CatalogPage 
{
private BasePage bp;

	
	public CatalogPage(WebDriver driver)
	{
		bp = new BasePage(driver);
	}
	
	public void selectProducts() throws InterruptedException, IOException 
	{

		
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]");
		//bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[4]/div[4]/div[1]/div[3]/div[3]/div[1]");
		bp.sendTextByCss("div#app > div > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(3) > div > div:nth-of-type(3) > div:nth-of-type(2) > div > input", "9");
		bp.clickInTheButtonByXpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[4]/div[4]/div[1]/div[3]/div[3]/div[1]");
		//bp.clickInTheButtonByCss("div#app > div > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(3) > div > div:nth-of-type(3) > div:nth-of-type(2) > div > input");
		bp.sendTextByCss("div#app > div > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(13) > div > div:nth-of-type(3) > div:nth-of-type(2) > div > input","9");
		Thread.sleep(8000);
		bp.clickInTheButtonByCss("div#app > div > div > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div");
		if(bp.getText("//*[@id=\"app\"]/div/div/div[4]/div/div[2]/p[1]").equalsIgnoreCase("Cara, vi que você colocou cervejas retornáveis no carrinho."))
			{
				System.out.println("entrou no if ");
				bp.clickInTheButtonByCss("div#yes-address");
			}
		
		
	}

}

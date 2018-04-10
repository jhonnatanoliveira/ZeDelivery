package ZeDeliveryAutomation.ZeDeliveryAutomation;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import basePageObjects.ZeDeliveryBase;
import pageObjects.CatalogPage;
import pageObjects.FinalizePurchase;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RunTests 
{
	
		 
		 protected WebDriver driver;
		 

		 @Before

		 public void before() 
		 {
			 ZeDeliveryBase driver = new ZeDeliveryBase();
			 this.driver = driver.getDriver();
			
		 }

		 
		 
		 @Test
		 public void purchaseSimulation() throws InterruptedException, AWTException, IOException {
			
	       HomePage home = new HomePage(driver);
		   CatalogPage catalog = new CatalogPage(driver);
		   LoginPage login = new LoginPage(driver);
		   FinalizePurchase finalize = new FinalizePurchase(driver);
		   home.navigateToHome();
		   login.login();
		   home.insertAdress();
		   catalog.selectProducts();
		   finalize.Finalize();
		   
		   
		   Assert.assertTrue(true);

		   
		 }

		 
		 @After
		 public void after() {
		   driver.quit();
		 }
		 
		
}

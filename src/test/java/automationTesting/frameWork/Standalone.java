package automationTesting.frameWork;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import automationTesting.Base.BaseObject;
//import automationTesting.landingPage.ConformationPage;
//import automationTesting.landingPage.ProductCatalog;
//import automationTesting.landingPage.cartPage;
//import automationTesting.landingPage.checkOutPage;
//import automationTesting.landingPage.landingPage;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Standalone extends BaseObject {
//
//	@Test(dataProvider="getData",groups= {"Purchase"})
//	public void testngmethod() {
//		// TODO Auto-generated method stub
//		String productName = "zara coat 3";
//		
//		String countryName = "india";
//		
//		//LandingPage landingPage = new LandingPage(driver);
//		//startingpoint();
//			
//		landingPage landingPage=startingpoint();
//			ProductCatalog ProductCatalog =landingPage.applicationLogin("anshika@gmail.com", "Iamking@000");
//			
//			//
//			List<WebElement> products = ProductCatalog.getproductsList();
//			ProductCatalog.addproducttocart(input.get("product"));
//			cartPage cartPage = ProductCatalog.gotoCartPage();
//			//
//			
//			
//		//cartPage validation	
//		//cartPage cartPage = new cartPage(driver);
//		Boolean match = cartPage.verifingproductDisplay(productName);
//		 Assert.assertTrue(match);
//		
//	//clickon the check out button
//		 cartPage.gotocheckout();
//	
//	//checkoutpage	 
//		 checkOutPage checkOutPage = new  checkOutPage(driver);
//		 checkOutPage.SelectCountryMeth(countryName);
//		 checkOutPage.SubmitButton();
//
//		 ConformationPage ConformationPage =new ConformationPage(driver);
//	
//		String confirmMessage= ConformationPage.confirmation();
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	
//	
//	}

	


//}







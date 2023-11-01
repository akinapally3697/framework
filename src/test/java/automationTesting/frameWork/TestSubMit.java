package automationTesting.frameWork;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationTesting.Base.BaseObject;
import automationTesting.landingPage.ConformationPage;
import automationTesting.landingPage.OrdersPage;
import automationTesting.landingPage.ProductCatalog;
import automationTesting.landingPage.cartPage;
import automationTesting.landingPage.checkOutPage;
import automationTesting.landingPage.landingPage;

public class TestSubMit extends BaseObject {

	
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
		ProductCatalog ProductCatalog = landingPage.applicationLogin(input.get("email"),
				input.get("password"));

		List<WebElement> products = ProductCatalog.getProductList();
		ProductCatalog.addProductToCart(input.get("product"));
		cartPage cartPage = ProductCatalog.gotoCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		checkOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConformationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	
//	@Test(dependsOnMethods= {"submitOrder"})
//	public void OrderHistoryTest()
//	{
////		//"ZARA COAT 3";
////		ProductCatalog ProductCatalog = landingPage.applicationLogin(input.get("email"),
////				input.get("password"));
////		OrdersPage ordersPage = productCatalogue.gotoordersPage();
////		Assert.assertTrue(ordersPage.VerifyProductDisplay(productName));
////		
//}
	

	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+
				"\\src\\test\\java\\frameWork\\data\\data.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
	//Extent Reports - 
	

//	 @DataProvider
//	  public Object[][] getData()
//	  
//	  {
//		 HashMap<String,String> map = new HashMap<String,String>();
//			map.put("email", "anshika@gmail.com");
//			map.put("password", "Iamking@000");
//			map.put("product", "zara coat 3");
//			
//			HashMap<String,String> map1 = new HashMap<String,String>();
//			map1.put("email", "shetty@gmail.com");
//			map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
//		
//	  
//	    return new Object[][]  {{map}, {map1 } };
//	    
	//  }
}
	

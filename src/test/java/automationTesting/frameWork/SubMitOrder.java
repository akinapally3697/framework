package automationTesting.frameWork;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationTesting.AbstractComponents.AbstractComponents;
import automationTesting.Base.BaseObject;
import automationTesting.landingPage.OrdersPage;
import automationTesting.landingPage.ProductCatalog;
import automationTesting.landingPage.cartPage;



public class SubMitOrder extends BaseObject {

	@Test(groups = {"runfirst"} ,dataProvider="getdata")
	public void loginTest(String email ,String Password ,String ProductName) throws IOException, InterruptedException{
		landingPage.applicationLogin(email,Password);
		//Assert.assertEquals("Incorrect email or password.", landingPage.errorValidationvalue());
}
	@Test
	public void productadding() throws IOException, InterruptedException{
		
	String 	productName="zara coat 3";

	//String productName = "ZARA COAT 3";
	ProductCatalog ProductCatalog = landingPage.applicationLogin("rahulshetty@gmail.com", "Iamking@000");
	List<WebElement> products = ProductCatalog.getProductList();
	ProductCatalog.addProductToCart(productName);
	cartPage cartPage = ProductCatalog.gotoCartPage();
	Boolean match = cartPage.VerifyProductDisplay("zara coat 3");
	Assert.assertFalse(match);
	
	
	}
	
	
@Test(dependsOnMethods= {"productadding"})
public void verifindorderdetails() throws InterruptedException {
	String 	productName="zara coat 3";
	ProductCatalog ProductCatalog = landingPage.applicationLogin("rahulshetty@gmail.com", "Iamking@000");

	OrdersPage OrdersPage=ProductCatalog.gotoordersPage();
	Assert.assertTrue(OrdersPage.VerifyProductDisplay(productName));
	
	
}
	
	

@DataProvider
public  Object[] [] getdata() {
	
	
	return new Object[] [] {{"anshika@gmail.com","Iamking@000","zara coat 3"} ,
	{"anshika@gmail.com","Iamking@000","adidas original"}};
}
} 

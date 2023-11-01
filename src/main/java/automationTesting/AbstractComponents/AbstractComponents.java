package automationTesting.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationTesting.landingPage.OrdersPage;
import automationTesting.landingPage.cartPage;

//ReusableComponent
//it will be the parent class because it is holding all reusable stuff
public class AbstractComponents {

	
	//clicking on cart 
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderButton;
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}

	public void waitforElementToppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	
	public void waitforElementdisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	//clicking on cart 
	public cartPage gotoCartPage() {
		cartButton.click();
		
		cartPage cartPage = new cartPage(driver);
		return cartPage;
	}
		
		public  OrdersPage gotoordersPage() {
			OrderButton.click();
			
			OrdersPage OrdersPage = new OrdersPage(driver);
			return OrdersPage;
		
	}
	
	
}
	
	

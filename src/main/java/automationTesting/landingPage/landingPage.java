package automationTesting.landingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support .FindBy;
import org.openqa.selenium.support.PageFactory;

import automationTesting.AbstractComponents.AbstractComponents;

public class landingPage extends AbstractComponents {


	//pageobjectclass
	
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	
	{
		super(driver);
		
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement Password;

		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;

		
		//actionclass
		public ProductCatalog applicationLogin(String email,String passwordss)
		{
			userEmail.sendKeys(email);
			Password.sendKeys(passwordss);
			submit.click();
			
			ProductCatalog ProductCatalog = new ProductCatalog(driver);
			return ProductCatalog;
			
		}
		
		public String errorValidationvalue() {
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		
		public void gotopage()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}

		public static ProductCatalog loginApplication(String string, String string2) {
			// TODO Auto-generated method stub
			return null;
		}
}



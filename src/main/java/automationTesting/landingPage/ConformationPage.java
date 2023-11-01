package automationTesting.landingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import automationTesting.AbstractComponents.AbstractComponents;

public class ConformationPage extends AbstractComponents{
	
	
	WebDriver driver;
	
	

		public ConformationPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			

		}
		
		@FindBy(css = ".hero-primary")
		WebElement confirmationMessage;
		
		public String getConfirmationMessage()
		{
			checkOutPage cp = new checkOutPage(driver);	
			return confirmationMessage.getText();
		}
}



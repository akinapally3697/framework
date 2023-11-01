package automationTesting.landingPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationTesting.AbstractComponents.AbstractComponents;

public class OrdersPage  extends AbstractComponents {
	
	
	WebDriver driver;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> ordername;

	

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = ordername.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

}

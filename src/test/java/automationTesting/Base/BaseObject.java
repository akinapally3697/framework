package automationTesting.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationTesting.landingPage.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
public class BaseObject {

	public WebDriver driver;
	public landingPage landingPage;

	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		 Properties prop = new Properties();
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				 "\\src\\main\\java\\automationTesting\\GlobalVeriable\\GlobalData.properties"
				);
		prop.load(fis);
		
		
		String browserName = prop.getProperty("browser");
		//prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();//full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/rahulshetty//documents//geckodriver");
			driver = new FirefoxDriver();
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeMethod(alwaysRun=true)
	public landingPage startingpoint() throws IOException {	
	driver = initializeDriver();
		landingPage	= new landingPage(driver);
	landingPage.gotopage();
	
	return landingPage;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filepath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Datbind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
}
	
}	

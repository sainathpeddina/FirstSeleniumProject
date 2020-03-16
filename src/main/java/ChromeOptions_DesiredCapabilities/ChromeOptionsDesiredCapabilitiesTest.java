package ChromeOptions_DesiredCapabilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOptionsDesiredCapabilitiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String proppath = System.getProperty("user.dir");
		System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
		
		//Desiredcapabilities (General ChromeOptions)
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.acceptInsecureCerts(); // to handle ssl certificates
		//or
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//ChromeOptions (Local browser options)
		ChromeOptions options = new ChromeOptions();
		options.merge(dc);
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--disable-notifications");
		
		//Webdriver with ChromeOptions & DesiredCapabilities
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		System.out.println("Before Processing >>>>" + driver.getTitle());
	}

}

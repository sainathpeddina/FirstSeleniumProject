package WaitTypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypesTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String proppath = System.getProperty("user.dir");
		System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Implicit wait
		//30 sec before throwing an exception , if found in 10 sec resume the program
		//Globally declared and applicable to all webdriver methods until wedbdriver killed
		//xxxxx Performance issues are not caught
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
    	System.out.println("Before Entering SigiIn Details >>>>" + driver.getTitle());
    	By dayDropDown = By.xpath("//select[@id='day']");
	
    	//pause the program , doesn't skip if element got , not recommended
		Thread.sleep(2000); 
		
		//WebDriverWait is applied to targeted elements , so no performance issue
		//xxxxxx more code to be used
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dayDropDown));
		
		//Fluent wait is used to find wed element repeatedly at regular intervals of time until timeout
		//or till the object found 
		//messy code
		//Best Ex : your card accepted (3 sec ) , your order will place (7 sec ) , Confirmation page (10 sec )
		
		By error = By.xpath("//select[@id='day']");
		wait.until(ExpectedConditions.presenceOfElementLocated(error));
		String errormsg = driver.findElement(error).getText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", error);

		System.out.println("After Entering SigiIn Details Verify error message >>>> " + errormsg);

		driver.close();
	}

}

package SelectMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectMethods {

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
    	System.out.println("Before Entering SigiIn Details >>>>" + driver.getTitle());
    	Select s = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		//static Dropdown
    	s.selectByValue("11"); //by value
		//s.selectByVisibleText("16"); //by VisibleText
		//s.selectByIndex(17);//by Index
		
    	//dynamic Dropdown
    	//dropdown with index , it can be achieved by parent child relationship xpath
    	
    	
    	//Autosuggested dropdowm 
    	//In online booking sites locations can be achieved by sendKeys(Keys.ENTER)
    	
		Thread.sleep(2000);
		WebElement error = driver.findElement(By.xpath("//select[@id='day']"));
		String errormsg = error.getText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", error);

		System.out.println("After Entering SigiIn Details Verify error message >>>> " + errormsg);

		driver.close();
	}

}

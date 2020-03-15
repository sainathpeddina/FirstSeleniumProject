package Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathTestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String proppath = System.getProperty("user.dir");
		System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();

		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Before Entering SigiIn Details >>>>" + driver.getTitle());
		// tagname[@attribute='value')] -- xpath
		// tagname[attribute='value')] -- cssselector
		// tagname.classname -- cssselector
		// tagname#id -- cssselector

		// ENTER USERNAME IN DIFFERENT TYPES OF XPATH
		// driver.findElement(By.className("input r4 wide mb16 mt8 username"));
		// driver.findElement(By.cssSelector("#username"));
		driver.findElement(By.id("username")).sendKeys("yellow@csk.com");
		// driver.findElement(By.name("username"));
		// driver.findElement(By.xpath("//*[@id='username']"));
		// *[@id='username']/parent::div -- traverse back to parent element from child
		// element , only applicable in xpath not in css selector

		// *[@id='username']/following-sibling::input[1] -- traverse to sibiling element
		// xpath
		// tagname[attribute='value')]tagname:nth-child(3) -- css -- traverse to child
		// element from parent

		// REGULAR EXPRESSION
		// tagname[contains(@attribute,'value')] -- xpath
		// tagname[attribute*='value')] -- cssselector

		driver.findElement(By.id("password")).sendKeys("yellove");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(5000);
		WebElement error = driver.findElement(By.xpath("//div[@id='error']"));
		String errormsg = error.getText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", error);

		System.out.println("After Entering SigiIn Details Verify error message >>>> " + errormsg);

		driver.close();
	}

}

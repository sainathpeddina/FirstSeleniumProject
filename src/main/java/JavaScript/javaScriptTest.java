package JavaScript;

import java.util.concurrent.ExecutionException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;

public class javaScriptTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String proppath = System.getProperty("user.dir");
		System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		System.out.println("Before Processing >>>>" + driver.getTitle());
		WebElement error = driver.findElement(By.xpath("//select[@id='google']"));
		String msg = error.getText();
		//JavaScript can extract idden elements from DOM
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", msg);
	}

}

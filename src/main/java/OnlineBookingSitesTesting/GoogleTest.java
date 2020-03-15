package OnlineBookingSitesTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleTest {

	public static void main(String[] args) throws Exception {
		
		String proppath = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(proppath + "\\globalSettings.properties");
		prop.load(fs);
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.setPageLoadStrategy(PageLoadStrategy.NONE);
			WebDriver driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Before sending values : " + driver.getTitle());
			driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(prop.getProperty("value"));
			Thread.sleep(2000);
			ArrayList<WebElement> el = new ArrayList<WebElement>(
					driver.findElements(By.xpath("//ul[@class='erkvQe']//li")));
			for (int i = 0; i < el.size(); i++) {
				// System.out.println("all listed suggestion values:"+el.get(i).getText());
				String autoSugValue = el.get(i).getText();
				if (autoSugValue.contains("wife")) {
					el.get(i).click();
					System.out.println("After sending values : " + driver.getTitle());
					break;
				}
			}
			Thread.sleep(3000);
			System.out.println("successfully clicked");
			driver.close();
		}

	}
}
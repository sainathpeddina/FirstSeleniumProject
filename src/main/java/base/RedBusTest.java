package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

public class RedBusTest {

	public static void main(String[] args) throws Exception {

		String proppath = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(proppath + "\\globalSettings.properties");
		prop.load(fs);
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.crome.driver", proppath + "\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("BusUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Before sending values : " + driver.getTitle());

			Thread.sleep(5000);
			System.out.println("Entering From Details");
			WebElement src = driver.findElement(By.xpath(("//input[@id='src']")));
			src.clear();
			src.sendKeys(prop.getProperty("from"));
			Thread.sleep(2000);
			src.sendKeys(Keys.ENTER);
			src.clear();

			Thread.sleep(2000);
			System.out.println("Entering To Details");
			WebElement dest = driver.findElement(By.xpath("//input[@id='dest']"));
			dest.clear();
			dest.sendKeys(prop.getProperty("to"));
			Thread.sleep(2000);
			dest.sendKeys(Keys.ENTER);
			dest.click();
			Thread.sleep(2000);

			System.out.println("Selecting Date ");
			driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
			WebElement calendermonth = driver.findElement(By.xpath("(//*[@class='rb-monthHeader'])[2]"));
			String mon = calendermonth.getText();

			while (!(mon.contains(prop.getProperty("month")))) {
				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]"))
						.click();
				WebElement calendermonth1 = driver.findElement(By.xpath("(//*[@class='rb-monthHeader'])[2]"));
				mon = calendermonth1.getText();
			}
			
			Thread.sleep(2000);
			List<WebElement> day = driver.findElements(By.xpath(
					"//div[@id='rb-calendar_onward_cal']//tr//td[contains(@class,'wd day') or contains(@class,'we day')]"));
			for (int i = 0; i < day.size(); i++) {
				String daysInCalendar = day.get(i).getText();
				if (daysInCalendar.contains(prop.getProperty("date"))) {
					day.get(i).click();
					break;
				}
			}
			
			System.out.println("date selected successfully");
			Thread.sleep(3000);
			
			driver.findElement(By.id("search_btn")).click();
			System.out.println("successfully clicked search btton");
			Thread.sleep(10000);
			System.out.println("After Entering Details of passenger : " + driver.getTitle());
			Thread.sleep(3000);
			driver.close();

		}

	}
}
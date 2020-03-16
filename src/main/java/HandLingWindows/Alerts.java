package HandLingWindows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.collect.Iterators;
import com.google.inject.Key;

public class Alerts {

	public static void main(String[] args) throws Exception {
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

		//move to alert
		driver.switchTo().alert();
		//To accept
		driver.switchTo().alert().accept();
		//To decline
		driver.switchTo().alert().dismiss();
		//To get text from alert 
		driver.switchTo().alert().getText();
	}
	}


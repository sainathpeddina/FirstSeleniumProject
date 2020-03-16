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

public class Windows {

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

		List<WebElement> lang = driver.findElements(By.xpath("//div[@id='SIvCob']//a"));
		for (int i = 0; i < lang.size(); i++) {
			lang.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		}
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		//ArrayList<String> strlang = null;
		while (it.hasNext()) {
			//it.next();
			driver.switchTo().window(it.next());
			//strlang.add(driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnI']")).getText());
			//System.out.println(driver.findElement(By.xpath("//div[@class='gb_ce gb_i gb_Bg gb_sg']//div[2]//a[1]")).getText());
			Thread.sleep(2000);
			driver.close();
		}
	}

}

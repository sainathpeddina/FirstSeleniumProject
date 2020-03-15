package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

public class ActionClassTest {

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions a = new Actions(driver);

		///////////////////////////////////////////////////////////

		driver.get("https://www.guru99.com/keyboard-mouse-events-files-webdriver.html");
		System.out.println("Before Clicking selenium >>>>  " + driver.getTitle());
		WebElement testing = driver.findElement(By.xpath(
				"//span[@class='g-separator g-menu-item-content']//span[@class='g-menu-item-title'][contains(text(),'Testing')]"));

		a.moveToElement(testing).build().perform(); // mouse over action
		Thread.sleep(2000);
		WebElement selenium = driver.findElement(By.xpath(
				"//div[contains(@class,'g-block size-34')]//span[@class='g-menu-item-title'][contains(text(),'Selenium')]"));
		selenium.click();
		System.out.println("After clicking selenium  >>>>  " + driver.getTitle());

		///////////////////////////////////////////////////////////

		driver.get("https://www.salesforce.com/search/#sort=relevancy");
		System.out.println("....>>>>  " + driver.getTitle());
		// enters details in CAPITAL LETTERS
		System.out.println("CAPITAL LETTERS");
		WebElement serach = driver.findElement(By.xpath("//div[@class='magic-box-input']//input"));
		a.moveToElement(serach).click().keyDown(Keys.SHIFT).sendKeys("manualtesting").build().perform();
		// double click particular element
		System.out.println("double click");
		a.moveToElement(serach).doubleClick().build().perform();

		// to use multiple keyboard letters at once we use chord
		// serach.sendKeys(Keys.chord(Keys.CONTROL,"a"));

		///////////////////////////////////////////////////////////
		// clicking clickhold & release action
		System.out.println("clickhold action");
		WebElement text1 = driver
				.findElement(By.xpath("//a[contains(text(),'Salesforce Careers - Find Jobs and Apply Today - S')]"));
		a.moveToElement(text1).clickAndHold().build().perform();
		Thread.sleep(2000);
		System.out.println("release action");
		a.moveToElement(text1).release().build().perform();

		// clicking right click menu as same from mouse
		System.out.println("right click");
		WebElement tryforFree = driver.findElement(By.xpath("//span[contains(text(),'Try For Free')]"));
		a.moveToElement(tryforFree).contextClick().build().perform();
	}

}

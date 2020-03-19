package TestNGAnnotationClassTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGBase {
	
	
	//@Test in TestNg always runs according to alphabetical order (method name)
	
	@BeforeClass
	public void baseBeforeClass() {
		System.out.println("I will be executed BeforeClass");
	}

	@AfterClass
	public void baseAfterClass() {
		System.out.println("I will be executed AfterClass");
	}
	@BeforeTest
	public void baseBeforeTest() {
		System.out.println("I will be executed BeforeTest");
	}

	@AfterTest
	public void baseAfterTest() {
		System.out.println("I will be executed AfterTest");
	}
	@BeforeSuite
	public void baseBeforeSuite() {
		System.out.println("I will be executed BeforeSuite");
	}

	@AfterSuite
	public void baseAfterSuite() {
		System.out.println("I will be executed AfterSuite");
	}
	@BeforeMethod
	public void baseBeforeMethod() {
		System.out.println("I will be executed Before every Method");
	}

	@AfterMethod
	public void baseAfterMethod() {
		System.out.println("I will be executed After every Method");
	}
	@Test
	public void baseTest() {
		System.out.println("Base Test" );
	}
	
}

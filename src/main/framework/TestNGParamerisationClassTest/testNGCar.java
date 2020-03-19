package TestNGParamerisationClassTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGCar {

	@Test(groups = {"Tyre"})
	public void carTyre()
	{
		System.out.println("carTyre Method");
	}
	@Parameters({"small"})
	@Test
	public void carEngine(String sam)
	{
		System.out.println("carEngine Method " + sam);
	}
}

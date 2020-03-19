package TestNGAnnotationClassTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGCar {

	@Test(groups = {"Tyre"})
	public void carTyre()
	{
		System.out.println("carTyre Method");
	}
	@Test
	public void carEngine()
	{
		System.out.println("carEngine Method ");
	}
}

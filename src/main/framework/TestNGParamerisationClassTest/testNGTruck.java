package TestNGParamerisationClassTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGTruck {

	@Test(groups = { "Tyre" })
	public void truckTyre() {
		System.out.println("truckTyre Method");
	}

	/*
	 * (timeOut = 4000) The maximum number of milliseconds this test should take. If
	 * it hasn't returned after this time, it will be marked as a FAIL.
	 */
	@Parameters({"large"})
	@Test(timeOut = 4000)
	public void truckEngine() {
		System.out.println("truckEngine Method " );
	}
}

package TestNGAnnotationClassTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGBike {

	/*
	 * // if we want to skip this method for this class , we can write enabled =
	 * false or we can add this as exclude method in testNG.xml for particular class
	 * 
	 * @Test(enabled = false) public void bikeEngine() {
	 * System.out.println("bikeEngine Method"); }
	 */

	/*
	 * @Test(dependsOnMethods = {"bikeTyre"}) , mean bikeEngine method depends on
	 * bikeTyre , so biketyre method should execute first then bikeEngine will
	 * execute
	 */
	@Test(dependsOnMethods = { "bikeTyre" })
	public void bikeEngine() {
		System.out.println("bikeEngine Method");
	}

	@Test(groups = { "Tyre" })
	public void bikeTyre() {
		System.out.println("bikeTyre Method ");
	}

}

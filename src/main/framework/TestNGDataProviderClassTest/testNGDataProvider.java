package TestNGDataProviderClassTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGDataProvider {

	@Test(dataProvider = "getData")
	public void testNGDataProviderTest(String fav, String ind) {
		System.out.println("Favourite Player : " + fav);
		System.out.println("India Player : " + ind);
	}

	@DataProvider
	public Object[][] getData() {
		Object obj[][] = new Object[2][2];
		obj[0][0] = "dhoni";
		obj[0][1] = "raina";
		obj[1][0] = "virat";
		obj[1][1] = "rohit";
		return obj;
	}

}

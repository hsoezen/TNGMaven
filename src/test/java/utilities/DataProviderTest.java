package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	@DataProvider(name = "testDaten")
	public Object[][] getData(){
		
		Object[][] testData = {{1,3,4}, {2,4,6}, {3,1,4}, {2,9,11}};
		return testData;
	}

}

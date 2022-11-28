package RechnerTest;

import java.lang.annotation.Annotation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rechner.TaschenRechner;
import utilities.DataProviderTest;

public class MehrereDatenMitDataProvider {
	TaschenRechner rechner = new TaschenRechner();
	
	@Test(dataProvider = "testDaten", dataProviderClass = DataProviderTest.class)
	public void summeTest(int nummer1, int nummer2, int summeData) {

		int summe = rechner.summe(nummer1, nummer2);
		Assert.assertEquals(summe, summeData);
		
	}
	

}

package RechnerTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import rechner.TaschenRechner;


public class TaschenRechnerTest {
	TaschenRechner rechner = new TaschenRechner();

	@Test(priority = 3)
	public void recnhterSumme() {
		int ergebnis = rechner.summe(3, 5);
		System.out.println(ergebnis);
		
		Assert.assertEquals(ergebnis, 8);

	}
	@Test(priority = 2)
	public void taschenRechnerTrue() {
		Assert.assertTrue(true);
	}
	@Test(priority = 1)
	public void taschenRecnerFalse() {
		Assert.assertFalse(false);
	}

}

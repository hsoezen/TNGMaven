package SeleniumTest;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5Options {
	
	private WebDriver driver;
	private String baseUrl = "https://www.wikipedia.org/";
	
	@BeforeClass
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get(baseUrl);
	}
	
	@Test
	public void options() {
		WebElement sprachenDropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select select = new Select(sprachenDropdown);
		
		List<WebElement> sprachen = select.getOptions();
		
		for (WebElement w : sprachen) {
			System.err.println(w.getText());
		}
	}
	
	@Test
	public void sprachTuerkisch() {
		WebElement sprachenDropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select select = new Select(sprachenDropdown);
		
		List<WebElement> sprachen = select.getOptions();
		
	
		boolean tuerkisch= true;
		for (WebElement w : sprachen) {
			if (w.getText().equals("Türkçe")) {
				w.click();		
				tuerkisch = w.isSelected();
			}
		}
		Assert.assertTrue(tuerkisch);
		
			
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2);
		driver.close();
	}

}

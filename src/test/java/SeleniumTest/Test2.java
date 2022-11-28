package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		baseUrl = "https://courses.letskodeit.com/practice";
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void testRadioButton() {
		WebElement element= driver.findElement(By.xpath("//input[@id='bmwradio']"));
		element.click();
		
		Assert.assertTrue(element.isSelected());
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}

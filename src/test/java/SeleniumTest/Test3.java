package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeText() {
		WebDriverManager.chromedriver().setup();
		baseUrl = "https://courses.letskodeit.com/practice";
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
	}
	@Test
	public void selectTest() {
		WebElement hondeElement = driver.findElement(By.xpath("//option[@value='honda']"));
		hondeElement.click();
		
		Assert.assertTrue(hondeElement.isSelected());
		Assert.assertEquals(hondeElement.getText(), "Honda");
		
	}
	@AfterClass
	public void teaDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}


}

package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test6Navigate {
	
	private String baseUrl = "https://www.wikipedia.de";
	private WebDriver driver;
	
	@BeforeClass
	public void navigateTest() {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get(baseUrl);	
}
	@Test
	public void navigate() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebElement wikiMedia = driver.findElement(By.xpath("//img[@class='wikimedia-logo']"));
		wikiMedia.click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
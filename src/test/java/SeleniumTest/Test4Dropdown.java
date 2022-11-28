package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4Dropdown {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		baseUrl= "https://courses.letskodeit.com/practice";
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
	}
	@Test
	public void dropdown() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='carselect']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Benz");
		
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}

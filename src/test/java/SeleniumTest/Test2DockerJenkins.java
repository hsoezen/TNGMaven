package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Test2DockerJenkins {
	private WebDriver driver;
	private String baseUrl;
	private String HOST_URL="http://localhost:4444";
	
	@BeforeClass
	public void setUp() throws InterruptedException, MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(HOST_URL), options);

		baseUrl = "https://courses.letskodeit.com/practice";
		Thread.sleep(2000);
		driver= new ChromeDriver();
		Thread.sleep(2000);
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
		driver.quit();
	}

}

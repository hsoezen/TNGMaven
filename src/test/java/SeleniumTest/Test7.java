package SeleniumTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test7 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = "https://www.wikipedia.org";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
	}
	@Test
	public void list() {
		List<WebElement> sprachen = driver.findElements(By.xpath("//div[contains(@class,'central-featured-lang lang')]"));
		
		for (WebElement w : sprachen) {
			
			w.getAttribute("div");
			System.out.println(w.getText());
		}
	}
	
	@Test
	public void list2() {
List<WebElement> sprachen = driver.findElements(By.tagName("a"));
		
		for (WebElement w : sprachen) {
			
			w.getAttribute("href");
			System.out.println(w.getAttribute("href"));
		}
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}

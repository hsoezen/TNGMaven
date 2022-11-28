package SeleniumTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class ScrolllenJava{
	WebDriver driver;
	@BeforeClass(groups = "smoke")
	public void setUp() {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hsoezen\\Downloads\\chromedriver_win32letzte\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://www.selenium.dev/");

	}
	
	@Test(groups = "smoke")
	public void scrollTest() throws InterruptedException, IOException {

		WebElement moreNews = driver.findElement(By.linkText("@diegofmolina"));
		Thread.sleep(2000);
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", moreNews);
		Thread.sleep(1000);
		
		
		String name = "ScrollTest";
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String target = "C:\\Users\\hsoezen\\eclipse-workspace\\TNGMaven\\test-output\\ScreenShots" + name + date + ".png";
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		File finalDestination = new File(target);
		
		FileUtils.copyFile(source, finalDestination);
		Thread.sleep(1000);
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}

package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test8 {
	
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseUrl = "https://chercher.tech/practice/practice-pop-ups-selenium-webdriver";
        driver.get(baseUrl);
    
    }
    @Test
    public void test3() throws InterruptedException {
        WebElement confirm = driver.findElement(By.xpath("//input[@name='prompt']"));
        confirm.click();
        Thread.sleep(1000);
        String a = "ddgg";
        driver.switchTo().alert().sendKeys(a);
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}



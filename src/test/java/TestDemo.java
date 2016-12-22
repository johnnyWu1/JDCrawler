import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {  
      private WebDriver driver;  
      private String baseUrl;  
      private StringBuffer verificationErrors = new StringBuffer();  
  
      @Before  
      public void setUp() throws Exception {  
    	  System.setProperty("webdriver.chrome.driver",
  				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
  		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
        driver = new ChromeDriver();  
        baseUrl = "http://www.baidu.com/";  
        System.out.println(driver.manage().timeouts());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
      }     
      @Test  
      public void testAssert() throws Exception{  
          driver.get(baseUrl);  
            for (int second = 0;; second++) {  
                if (second >= 60) fail("timeout");  
                try { if (driver.findElement(By.id("kw")).isDisplayed()) break; } catch (Exception e) {}  
                Thread.sleep(1000);  
            }  
  
            driver.findElement(By.id("kw")).clear();  
            driver.findElement(By.id("kw")).sendKeys("java");  
            
            for (int second = 0;; second++) {  
                if (second >= 60) fail("timeout");  
                try { if (driver.findElement(By.id("su")).isDisplayed()) break; } catch (Exception e) {}  
                Thread.sleep(1000);  
            }  
            driver.findElement(By.id("su")).click();  
            Thread.sleep(1000);  
            
            
            
            
            BaseClass baseclass = new BaseClass(verificationErrors,driver);  
            baseclass.assertEqualsReWrite(true, driver.findElement(By.id("page")).isDisplayed());  
            baseclass.assertEqualsReWrite(11, driver.findElement(By.id("page")).findElements(By.cssSelector("#page>*")).size());  
            baseclass.assertEqualsReWrite(11.2,4.2); 
            
            System.out.println("group 1");  
      }  
  
    @After  
      public void tearDown() throws Exception {  
        driver.quit();  
        String verificationErrorString = verificationErrors.toString();  
        if (!"".equals(verificationErrorString)) {  
          fail(verificationErrorString);  
            
        }  
          
      }  
}  
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class BaseClass{  
private StringBuffer verificationErrors;  
private WebDriver driver;  
    public BaseClass(StringBuffer verificationErrors,WebDriver driver){  
        this.verificationErrors = verificationErrors;  
        this.driver = driver;  
    }  
    public void assertEqualsReWrite(Object a, Object b) {  
          try{  
                assertEquals(a,b);
            }catch (Error e) {  
                AutoScreenShot.ScreenShot(driver, "E:\\selenium\\FILE\\screenshot\\");  
                System.out.println("Expected Result:" + a +" , " + "Actual Result:" + b);  
                verificationErrors.append(e.toString());  
                  
            }  
    }  
}  
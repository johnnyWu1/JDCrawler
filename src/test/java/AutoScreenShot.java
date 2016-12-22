import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoScreenShot {  
      
    public static int t = 1;  
    public static String getDateTime(){  
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");  
        return df.format(new Date());  
    }  
    public static void ScreenShot(WebDriver dr, String dir){  
        File screenShot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);  
        try {  
            FileUtils.copyFile(screenShot, new File(dir+getDateTime()+"_"+t+".jpg"));  
            ++t;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
      
}  
}  
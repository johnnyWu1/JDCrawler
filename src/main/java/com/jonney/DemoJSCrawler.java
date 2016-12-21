package com.jonney;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jonney.util.PageUtils;

import cn.edu.hfut.dmic.webcollector.example.DemoDepthCrawler;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class DemoJSCrawler extends DemoDepthCrawler {  
	  
    public DemoJSCrawler(String crawlPath) {  
        super(crawlPath, true);  
    }  
  
    
    
    
    @Override
	public void visit(Page page, CrawlDatums next) {
        //HtmlUnitDriver  
//      handleByHtmlUnitDriver(page);  
        //PhantomJsDriver  
//    	handleByFirefoxDriver(page);  
    	handleByPhantomJsDriver(page);
//    	handleByChromeDriver(page);
    	
    	
	}





      





	private void handleByChromeDriver(Page page) {
		WebDriver driver=PageUtils.getChromeWebDriver(page);  
        print(driver);  
        driver.quit();  
	}




	/** 
     * webcollector�Դ���ȡhtml driver���� 
     * 
     * @param page 
     */  
//    protected void handleByHtmlUnitDriver(Page page){  
//         /*HtmlUnitDriver���Գ�ȡJS���ɵ�����*/  
//      HtmlUnitDriver driver=PageUtils.getDriver(page,BrowserVersion.CHROME);  
//      /*HtmlUnitDriverҲ������Jsoupһ����CSS SELECTOR��ȡ���� 
//        ����HtmlUnitDriver���ĵ������selenium����ĵ�*/  
//      print(driver);  
//    }  
//      
    /** 
     * phantomjs driver���� 
     * 
     * @param page 
     */  
    protected void handleByPhantomJsDriver(Page page){  
         WebDriver driver=PageUtils.getPhantomJWebDriver(page);  
         print(driver);  
         driver.quit();  
    } 
    
    //getFireFoxWebDriver
      
    protected void handleByFirefoxDriver(Page page){  
        WebDriver driver=PageUtils.getFirefoxWebDriver(page);
        print(driver);  
        driver.quit();  
   } 
    
    protected void print(WebDriver driver){  
    	
        List<WebElement> divInfos = driver.findElements(By.cssSelector("li.gl-item"));  
        for(WebElement divInfo:divInfos){  
          WebElement price=divInfo.findElement(By.className("J_price"));  
            System.out.println(divInfo.findElement(By.cssSelector("a>em")).getText()+":"+price.getText());  
        }  
    }  
    public static void main(String[] args) throws Exception{  
        DemoJSCrawler crawler=new DemoJSCrawler("D:/test/crawler/jd/");  
        
        crawler.addSeed("http://list.jd.com/list.html?cat=1319,1523,7052&page=1&go=0&trans=1&JL=4_1_0#J_main");  
        crawler.start(3);  
    }  
  
}  
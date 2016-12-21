package com.jonney;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jonney.util.PageUtils;

import cn.edu.hfut.dmic.webcollector.model.Page;

public class JDGoodsList extends GoodsList {  
	  
    /** 
     *  
     */  
    private static final long serialVersionUID = -7487110223660262262L;  
  
    @Override  
    public void addGoods(Page page) {  
        WebDriver driver = null;  
        try {  
            driver = PageUtils.getPhantomJWebDriver(page);  
            List<WebElement> eles = driver.findElements(By.cssSelector("li.gl-item"));  
            if (!eles.isEmpty()) {  
                for (WebElement ele : eles) {  
                    Goods g = new Goods();  
                    g.setPlatform(Platform.JD);// 电商平台  
                    // 价格  
                    String priceStr = ele.findElement(By.className("p-price"))  
                            .findElement(By.className("J_price"))  
                            .findElement(By.tagName("i"))  
                            .getText();  
                    if (Tools.notEmpty(priceStr)) {  
                        g.setPrice(Float.parseFloat(priceStr));  
                    } else {  
                        g.setPrice(-1f);  
                    }  
                    // 商品名  
                    g.setName(ele.findElement(By.className("p-name"))  
                            .findElement(By.tagName("em")).getText());  
                    // 商品链接  
                    g.setUrl(ele.findElement(By.className("p-name"))  
                            .findElement(By.tagName("a"))  
                            .getAttribute("href"));  
                    // 评价  
                    String commitStr = ele  
                            .findElement(By.className("p-commit"))  
                            .findElement(By.tagName("a"))  
                            .getText();  
                    if (Tools.notEmpty(commitStr)) {  
                        g.setCommit(3);  
                    } else {  
                        g.setCommit(-1);  
                    }  
  
                    add(g);  
                }  
            } else {  
                System.out.println("else is empty");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (driver != null) {  
                driver.quit();  
            }  
        }  
    }  
}  


package com.jonney.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import cn.edu.hfut.dmic.webcollector.model.Page;

/**
 * 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</>
 * @date 2015-10-22
 */
public class PageUtils {

	/**
	 * ��ȡPhantomJsDriver(������ȡjs��̬���ɵ�html)
	 * 
	 * @param page
	 * @return
	 */
	public static WebDriver getPhantomJWebDriver(Page page) {
		// WebDriver driver = new HtmlUnitDriver(true);

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Installs\\Develop\\crawling\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		System.setProperty("phantomjs.binary.path", "D:/Programs/phantomjs-2.1.1-windows/bin/phantomjs.exe");

		WebDriver driver = new PhantomJSDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get(page.getUrl());

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("function(){}");
		return driver;
	}

	public static WebDriver getFirefoxWebDriver(Page page) {

		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		Navigation navigation = driver.navigate();
		navigation.to(page.getUrl());

		// driver.get(page.getUrl());

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("function(){}");
		return driver;
	}

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
//		System.setProperty("phantomjs.binary.path", "D:/Programs/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//		WebDriver driver = new PhantomJSDriver();
		
		System.out.println(driver);
	}

	/**
	 * ֱ�ӵ���ԭ��phantomJS(����ͨ��selenium)
	 * 
	 * @param page
	 * @return
	 */
	public static String getPhantomJSDriver(Page page) {

		if (true) {
			throw new RuntimeException("No Parser.js");
		}

		Runtime rt = Runtime.getRuntime();
		Process process = null;
		try {

			process = rt.exec("D:/Program Files/phantomjs-2.0.0-windows/bin/phantomjs.exe"
					+ "D:/MyEclipseWorkSpace/WebCollectorDemo/src/main/resources/parser.js " + page.getUrl().trim());
			InputStream in = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sbf = new StringBuffer();
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				sbf.append(tmp);
			}
			return sbf.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static WebDriver getChromeWebDriver(Page page) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get(page.getUrl());

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("function(){}");
		return driver;
	}
}

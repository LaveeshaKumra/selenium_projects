package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestingBrowsers {
	

	public static void main(String[] args) {
		
		String browser="firefox";
		String keyword="trending news";
		WebDriver driver=null;
		
		if(browser=="chrome") {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		
		  driver.get("https://www.google.com/");
	      WebElement element = driver.findElement(By.name("q"));
	      element.sendKeys(keyword);
	      element.sendKeys(Keys.RETURN);
	      //implicit wait to load page
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      WebElement link = driver.findElement(By.className("yuRUbf"));
	      WebElement link_element=link.findElement(By.tagName("a"));
	      String href_element=link_element.getAttribute("href");
	      System.out.println("Name of Link# " + href_element);
	      //open first link
	      driver.get(href_element);
		  //firefox_driver.quit();

		
	}

}

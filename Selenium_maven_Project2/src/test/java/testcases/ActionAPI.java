package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAPI {

	public static void main(String[] args) {

		String browser="firefox";
		WebDriver driver=null;
		String keyword="way2automation";
		if(browser=="chrome") {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
		driver.get("https://www.google.com/");
		 WebElement element = driver.findElement(By.name("q"));
	      element.sendKeys(keyword);
	      element.sendKeys(Keys.RETURN);
	      //implicit wait to load page
	      WebElement link = driver.findElement(By.className("yuRUbf"));
	      WebElement link_element=link.findElement(By.tagName("a"));
	      String href_element=link_element.getAttribute("href");
	      System.out.println("Name of Link# " + href_element);
	      //open first link
	      driver.get(href_element);
	      WebElement menu=driver.findElement(By.xpath("//*[@id=\"menu-item-27617\"]/a"));
	      Actions action=new Actions(driver);
	      action.moveToElement(menu).perform();
	      
	      driver.findElement(By.xpath("//*[@id=\"menu-item-27618\"]/a")).click();
	      
	}

}

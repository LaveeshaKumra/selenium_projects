package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser="chrome";
		String keyword="mumbai";
		WebDriver driver=null;
		String Search="";
		
		if(browser=="chrome") {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize() ;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://in.bookmyshow.com/");

		
		WebElement search_location= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input")));
		search_location.sendKeys(keyword);
		new Actions(driver).moveToElement(search_location).perform();
		WebElement location=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div[2]/div/ul/li[1]")));
		location.click();
		
		WebElement movies=driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]"));
		movies.click();
	}

}

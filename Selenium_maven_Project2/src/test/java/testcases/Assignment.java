package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws IOException {
		String browser="chrome";
		WebDriver driver=null;
		
		if(browser=="chrome") {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
//		File ScreenshotofFullPage= ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(ScreenshotofFullPage, new File("./screenshots/fullpage_ss.jpg"));
		
		File ScreenshotofPage= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenshotofPage, new File("./screenshots/page_ss.jpg"));
		
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"pollform\"]/table/tbody/tr[2]/td/input[2]"));
		element.click();
		WebElement equation = driver.findElement(By.id("mathq2"));
		String txt= equation.getText();
		File Screenshotofelement= equation.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshotofelement, new File("./screenshots/equation_ss.jpg"));
		String arr[]=txt.split("\\s+");
		int num=0;
		if(arr[1].equals("+")) {
			 num=Integer.parseInt(arr[0])+Integer.parseInt(arr[2]);
		}
		else if(arr[1].equals("-"))  {
			 num=Integer.parseInt(arr[0])-Integer.parseInt(arr[2]);
		}
		else if(arr[1].equals("*"))  {
			 num=Integer.parseInt(arr[0])*Integer.parseInt(arr[2]);
		}
		
	    WebElement ans = driver.findElement(By.id("mathuserans2"));
	    ans.sendKeys(Integer.toString(num));
	    
	    

		
	}

	}



package testcases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args)  {
		String browser="firefox";
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
		
		System.out.println(driver.manage().window().getSize());
	      //Create object of Dimensions class
		int w=50,h=50;
		for(int i=0;i<800;i+=50) {
			Dimension dm = new Dimension(w+i,h+i);
			driver.manage().window().setSize(dm);
		}
	      
	      //Setting the current window to that dimension
	      

		
	}

	}



package day8_Select_Alert_Popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandlingDemo {

	public static void main(String[] args) throws InterruptedException {
		alertDemo();
		
	}
	public static void alertAfter5Seconds() {
		
	
	}	
public static void alertDemo() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	

		//Test case 1
		//go to https://demoqa.com/alerts
		driver.get("https://demoqa.com/alerts");
		
		//Click on the first 'Click me'  button and Accept the alert.
		driver.findElement(By.id("alertButton")).click();
		
		// let's wait the alert to be present first, then interact with it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// now it's time to handle the alert
		
		Alert handle = driver.switchTo().alert();
		// accept is for anything confirmative like: Yes, Okay, Confirm, Accept etc....
		handle.accept();
	}
	

public static void alertAfter5Seconds1() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Test case 2 
	//go to https://demoqa.com/alerts
	driver.get("https://demoqa.com/alerts");
	//Click on the second 'Click me' button and get the text of it. 
	driver.findElement(By.id("timerAlertButton")).click();
	
	// we wait for the alert to be present before we interact with it
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert handle = driver.switchTo().alert();
	String alertText = handle.getText();
	
	//Then verify if the text equals to "This alert appeared after 5 seconds" 

	if (alertText.equals("This alert appeared after 5 seconds")) {
		System.out.println("Pass");
	}else {
		System.out.println("Fail");
	}
	
	// then Accept the alert.
	handle.accept();
	
}
}
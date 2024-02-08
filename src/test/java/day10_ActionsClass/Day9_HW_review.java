package day10_ActionsClass;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day9_HW_review {

	public static void main(String[] args) {
		guru_windowHandle();	
	}

	public static void guru_windowHandle() {
		//Test Case1
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		
		/////
		
		//go to http://demo.guru99.com/popup.php
				driver.get("http://demo.guru99.com/popup.php");
			     //Get title and store it in a variable.
				String title = driver.getTitle();
				
				//Click on Click Here button and switch over to next window, provide an email click Submit. 
				driver.findElement(By.linkText("Click Here")).click();
				
				    // in order to switch to, we need the window ids so that we can make a switch to the right window
				Set<String> windowIds = driver.getWindowHandles();
				
			//	Iterator<String> iterate = windowIds.iterator();
				
			//	String firstWindowID = iterate.next();  // next() return the next item in the set above. 
				
			//	String secondWindowID = iterate.next();  // next() return the next item in the set above. 
				
			//	driver.switchTo().window(secondWindowID);
				
				  // wait for the email field to be visible 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailid")));
				
				driver.findElement(By.name("emailid")).sendKeys("jon.dow@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Access details to demo site.']")));
				
			     //Get text of the user ID and password and store them in variables, print them out. 
				String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
				String password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
				
				System.out.println("User id: " + userID);
				System.out.println("Password : " + password);
				
			     //Then verify the text “This access is valid only for 20 days.”
				if (driver.findElement(By.xpath("//h3[text()='This access is valid only for 20 days.']")).isDisplayed()) {
					System.out.println("Test Pass");
				}else {
					System.out.println("Something is not right.");
				}
			     //Close the window.
				driver.close();
			     //Go back to main window, and get title then verify it equals to your stored title.
	//			driver.switchTo().window(firstWindowID);
				
				String title2 = driver.getTitle();
				if (title2.equals(title)) {
					System.out.println("Test pass again");
				}else {
					System.out.println("switch back has a problem");
				}
			     //Quit driver. 
				driver.quit();

	
		

		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}

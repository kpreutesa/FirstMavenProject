package day9_windowHandles;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowhandlesDemo {
	
	//readibility - manageble 
	//reusability
	//scability
	
	
	public static void main(String[] args) {
		//demoQAWindowHandlesDemo();
		windowHandlesDemoWithIterator();
	
	}
			
	//		For loop version of window switch:
				public static void demoQAWindowHandlesDemo() {
						
						WebDriver driver = new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
						
						// go to https://demoqa.com/browser-windows
						driver.get("https://demoqa.com/browser-windows");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
						
						// get the current window id and print it out
						String mainWindowID = driver.getWindowHandle();
						System.out.println("Main window ID is: " + mainWindowID);
						
						// click on New Tab button
						driver.findElement(By.id("tabButton")).click();  
						
						// Switch to the second window 
						   // in order to switch to new window, we have to know the id of the new window
						   // by using getWindowHandles, driver gets all the available window ids in the current browser instance
						
						Set<String> windowIDs = driver.getWindowHandles();
						
						// loop over and switch to the window id that doesn't match with the mainWidnowID
						for (String windowIdSingle : windowIDs) {
							System.out.println(windowIdSingle);
							if (!windowIdSingle.equals(mainWindowID)) {
								driver.switchTo().window(windowIdSingle);
							}
						}
						
						// and verify there is a text as "This is a sample page"
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
						if (driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")) {
							System.out.println("Second window text matches. Pass");
						}else {
							System.out.println("Second window text DOES NOT  match. Fail");
						}
						
						// close the second window
						driver.close();
						
						
						// at this point, where is the driver focus? 
						// at this point,  driver focus is on the second window
						// we have to swicth back if we wanna to interact with the other window items.
						
						//driver.switchTo().window(mainWindowID);
						
						System.out.println(driver.findElement(By.id("tabButton")).getText());
						
						driver.quit();
					}

			
		//		Iterator version of window switch:
				public static void windowHandlesDemoWithIterator() {
						
						WebDriver driver = new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
						
						// go to https://demoqa.com/browser-windows
						driver.get("https://demoqa.com/browser-windows");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
						
						// get the current window id and print it out
						String mainWindowID = driver.getWindowHandle();
						System.out.println("Main window ID is: " + mainWindowID);
						
						// click on New Tab button
						driver.findElement(By.id("tabButton")).click();  
						
						// Switch to the second window 
						   // in order to switch to new window, we have to know the id of the new window
						   // by using getWindowHandles, driver gets all the available window ids in the current browser instance
						
						Set<String> windowIDs = driver.getWindowHandles();
						
						// Iterate over the set and switch to second window
						
						Iterator<String> iterate = windowIDs.iterator();
						// at this stage, Iterator has the items inside the set object. 
						// but it's in front of the items.
						String firstWindowId = iterate.next();  // iterator goes to the first item in the iteration
						// after this, at this stage, iterator is at the first item.
						
						String secondWindowId = iterate.next(); // at this stage, iterator is at the second item.
						
						System.out.println("Is there a next item? " + iterate.hasNext());
						
						
						driver.switchTo().window(secondWindowId);
						
						// and verify there is a text as "This is a sample page"
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
						if (driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")) {
							System.out.println("Second window text matches. Pass");
						}else {
							System.out.println("Second window text DOES NOT  match. Fail");
						}
						
						// close the second window
						driver.close();
						
						
						// at this point, where is the driver focus? 
						// at this point,  driver focus is on the second window
						// we have to swicth back if we wanna to interact with the other window items.
						
						driver.switchTo().window(mainWindowID);
						
						System.out.println(driver.findElement(By.id("tabButton")).getText());
						
						driver.quit();
					
	}

}

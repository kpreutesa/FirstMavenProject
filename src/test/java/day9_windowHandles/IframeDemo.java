package day9_windowHandles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeDemo {
	


	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		// go to https://demoqa.com/frames
		driver.get("https://demoqa.com/frames");
		//get the default content text and print it out
		String mainframeText=
				driver.findElement(By.xpath("//*[contains(text(),'Sample Iframe page')]")).getText();
		System.out.println(mainframeText);
		//switch to the first frame and get the text to verify it's " This is a sample page"
		driver.switchTo().frame("frame");
		String frameText = driver.findElement(By.id("sampleHeading")).getText();
		if(frameText.equals("This is a sample page")) {
			System.out.println("We are in the frame");
		}else {
			System.out.println("We are NOT in the frame");
		}
		//switch back to parent frame and get the text to print out
		driver.switchTo().defaultContent();
		String mainframeText2 =
		driver.findElement(By.xpath("//*[contains(text)], 'Sample Iframe page')]")).getText();
		System.out.println(mainframeText2);
		
		

	}

}

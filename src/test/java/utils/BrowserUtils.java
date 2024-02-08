package utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
    Alert alert;
	WebDriverWait wait;
	Actions act;
	Select select; //exercise(1)
	JavascriptExecutor FINISH /WATCH RECORDINGS
	
//exercise(1)	//create a method which accepts a webElement, which selects by visible text
	public void selectWithVisibleText(WebElement dropdown, String option) {
		select = new Select(dropdown);
		select.selectByVisibleText(option);
		
	}
	
	
	public void waitUntilElementVisibleWithLocator(By locator) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeInputed(WebElement element, String text) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitForAllElementsToBeVisible(List<WebElement> element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	//This method tells the driver to wait until an element is clickable
		public void waitUntilElementClickable(WebElement element) {
			wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitUntilElementClickableWithLocator(By locator) {
			wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
	
	public void sendkeysWithActionsClass(WebElement element, String input) {
		act = new Actions(Driver.getDriver());
		act.sendKeys(element, input).build().perform();
	}
	
	public void moveToWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.moveToElement(element).build().perform();
	}
	
	public void clickWithActionsClass(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.click(element).build().perform();
	}
	
	
	// this method generate 3 digit random number
		public int randomNumber() {
			Random rand = new Random();
			int randomNum = rand.nextInt((999 - 100) + 1) + 100;
			return randomNum;
		}

	
		// JS executor highlight element
		public void highlightElement(WebElement element) throws InterruptedException {
			js = (JavascriptExecutor) Driver.getDriver();
			for (int i = 0; i < 3; i++) {
				js.executeScript("arguments[0].style.border='3px solid red'", element);
				Thread.sleep(300);
		
			} 
			
		}
		// JS executor scroll to view
		public void scrollToView(WebElement element) {
			js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
	
	////////////////////////////////////////////////
	public static void main(String[] args) {
	}
	//create a utility method that accepts Alert
//hint: create a method that has a WebDriver as a parameter and does the alert accept
	
	public  void alert_accept(WebDriver driver) {
		alert= driver.switchTo().alert();
		alert.accept();
	}
	
	//create a utility method that cancels the Alert
	public void alert_cancel(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}	
	//create a utility method that sendKeys to the Alert
	public void alert_sendKeys(WebDriver driver,String input) {
		alert = driver.switchTo().alert();
		alert.sendKeys(input);
	}	
	//create a utility method that gets the text of the Alert and returns it
	public String alert_getText(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	
	
	
	
	
	
	}

	public static String getProperty(String string) {
		return null;
	}

}



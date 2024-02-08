package jan24_lab_session;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeworkReview {

	public static void main(String[] args) {
		amazonSignHw();

	}
public static void amazonSignHw() {
	
//	Test case2 / home work
	 
 //   go to amazon.com    click on signin 
 //    verify that you are on sign in page (either by sign-in text or email field).
//     navigate back, and navigate forward
//     verify that you are on sign in page (either by sign-in text or email field).
 //    click on create new account, verify you are on new account create page.
 //    navigate back, verify you are on the sign-in page.
//     navigate forward, verify you are on the create account page.
 //    click on the Continue button without filling the form
 //    verify error messages displayed and get text to verify:
 //     Enter your name
//       Enter your email or mobile phone number
//      Minimum 6 characters required
	
	
	 
			//Test case / home work
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
		    //go to amazon.com    click on signin 
			driver.get("https://amazon.com");
			driver.findElement(By.linkText("Sign in securely")).click();
			  // wait for the continue button/ or email box
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
			
		    //verify that you are on sign in page (either by sign-in text or email field).
			WebElement signInText = driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]"));
			
			if (signInText.isDisplayed()) {
				System.out.println("Yes, sign in text is displayed.");
			}else {
				System.out.println("Yes, sign in text is not displayed.");
			}
			
			
		    //navigate back, and navigate forward
			driver.navigate().back();
			driver.navigate().forward();
		    //verify that you are on sign in page (either by sign-in text or email field).
			if (driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
				System.out.println("Yes, sign in text is displayed in the second time.");
			}else {
				System.out.println("Yes, sign in text is not displayed in the second time.");
			}
			
		    //click on create new account, verify you are on new account create page.
			driver.findElement(By.id("createAccountSubmit")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name")));
			if (driver.findElement(By.id("ap_customer_name")).isDisplayed()) {
				System.out.println("You are on account create page.");
			}else {
				System.out.println("You are NOT on account create page.");
			}
			
		    //navigate back, verify you are on the sign-in page.
			driver.navigate().back();
			if (driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
				System.out.println("Yes, sign in text is displayed in the third time.");
			}else {
				System.out.println("Yes, sign in text is not displayed in the third time.");
			}
			
		    //navigate forward, verify you are on the create account page.
			driver.navigate().forward();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name")));
			if (driver.findElement(By.id("ap_customer_name")).isDisplayed()) {
				System.out.println("You are on account create page, second time.");
			}else {
				System.out.println("You are NOT on account create page, second time.");
			}
		    //click on the Continue button without filling the form
			driver.findElement(By.id("continue")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Enter your name')]")));
			
		    //verify error messages displayed and get text to verify:
			
		    //Enter your name
		    //Enter your email or mobile phone number
		    //Minimum 6 characters required
			
			WebElement nameErrorElement = 
					driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
			WebElement emailErrorMessage = 
					driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
			WebElement passwordErrorMessage = 
					driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']/div/div"));
			
			if (nameErrorElement.isDisplayed() && nameErrorElement.getText().equals("Enter your name")) {
				System.out.println("Enter your name error message displayed and correct.");
			}else {
				System.out.println("Enter your name error message NOT displayed or correct.");
			}
			
			if (emailErrorMessage.isDisplayed() && emailErrorMessage.getText().equals("Enter your email or mobile phone number")) {
				System.out.println("Email error message displayed and correct");
			}else {
				System.out.println("Email error message NOT displayed and correct");
			}
			
			if (passwordErrorMessage.isDisplayed() && passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
				System.out.println("Password error message displayed and correct");
			}else {
				System.out.println("Password error message NOT displayed and correct");
			}
			
		}
	
	
}
	
	
	
	
	
	
	


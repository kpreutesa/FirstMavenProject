package day7_select_alert_popups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAlertPopups {

	public static void main(String[] args) throws InterruptedException {
	selectDemo();

	}
	
	public static void chooseOptionFromNonSelectDropDown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	//go to https://semantic-ui.com/modules/dropdown.html
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		//chose Algeria from the country list
		
		driver.findElement(By.xpath("//div[@class='ui fluid search selection dropdown'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Algeria'])[1]")).click();
		
		
		
	}
	

	
    public static void selectDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// go to demoqa.com
		driver.get("https://demoqa.com/select-menu");
		
		//select Black from the old style dropdown
		WebElement colors =driver.findElement(By.id("oldSelectMenu"));
		
		Select letsSelect = new Select(colors);
		Thread.sleep(500);
		
		//what is the default selected item?
		String firstSelectedColor = letsSelect.getFirstSelectedOption().getText();
		
		System.out.println("Default selected color is: "+ firstSelectedColor);
		
		
		// get all the selected options
		List<WebElement> allColors =letsSelect.getOptions();
		System.out.println("Number of available colors is: "+ allColors.size());
		
		for (WebElement color:allColors) {
			System.out.println("Color is: " +color.getText());
			
		}
		//get all selected options
		List<WebElement> allSelectedOptions = letsSelect.getAllSelectedOptions();
		System.out.println("All selected option size is:"+ allSelectedOptions.size());
		
		//select by visible text
		letsSelect.selectByVisibleText("Black");
		
		Thread.sleep(2000);
		//select  by index
		letsSelect.selectByIndex(4);
		
		Thread.sleep(2000);
		//select by value
		letsSelect.selectByValue("10");
		
		
		
	}
	
	
	
	
}

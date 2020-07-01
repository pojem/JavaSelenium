import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class suggestiveDropDownTraining {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); // url
		driver.findElement(By.id("autocomplete")).sendKeys("be");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String script ="return document.getElementById('autocomplete').value";
		String text = (String) js.executeScript(script);
		
		while(!text.equalsIgnoreCase("Benin")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			script ="return document.getElementById('autocomplete').value";
			text = (String) js.executeScript(script);
			System.out.println(text);

	
		}

		
	}

}

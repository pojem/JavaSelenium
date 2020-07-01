import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExecutor {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://www.ryanair.com/gb/en"); // url
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
		String script ="return document.getElementById('input-button__departure').value";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		driver.get("https://www.goopti.com/en/"); // url
		
		driver.findElement(By.id("departure")).sendKeys("veni");
		driver.findElement(By.xpath("//li[contains(text(),'Venice Marco Polo Airport (VCE), Venice, Italy')]")).click();
		
		driver.get("https://ksrtc.in/oprs-web/guest/home.do"); // url
		driver.findElement(By.id("fromPlaceName")).sendKeys("BEN");
		String script2 ="return document.getElementById('fromPlaceName').value";
		String text2 = (String) js.executeScript(script2);
		int i = 0;
		while(!text2.equalsIgnoreCase("RANEBENNUR")) {
			i++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
			text2 = (String) js.executeScript(script2);
			System.out.println(text2);
			
		}
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);




	}

}

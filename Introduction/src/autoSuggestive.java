import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://www.goopti.com/en/"); // url
		driver.findElement(By.id("departure")).sendKeys("veni");
		Thread.sleep(3000);
		System.out.println(driver.findElements(By.id("departure")).size());



		
	}

}

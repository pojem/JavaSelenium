import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class maximizeAndCookies {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies(); //delete all cookies

		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); // url
		Thread.sleep(10000);
		driver.navigate().refresh(); //refresh site

	}

}

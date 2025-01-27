import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //url
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		Thread.sleep(2000); 
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.cssSelector("input#confirmbtn")).click();
		driver.switchTo().alert().dismiss();

	}

}

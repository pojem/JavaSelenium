import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Training1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // url
		driver.findElement(By.id("checkBoxOption2")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]")).getText());
		String text = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]")).getText();
		
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String alert = driver.switchTo().alert().getText();
		
		System.out.println(alert);
		driver.switchTo().alert().accept();
		if(alert.contains(text)) {
			System.out.println("dela OK");

			
		}
		
		Assert.assertTrue(alert.contains(text));

	}

}

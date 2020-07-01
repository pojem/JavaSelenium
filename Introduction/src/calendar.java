import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html"); // url
		driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).click();
		List<WebElement> dates = driver.findElements(By.className("day"));
		
		for (int i = 0; i <dates.size(); i++) {
			
			String text = dates.get(i).getText();
			System.out.println(text);
			
			if (text.equalsIgnoreCase("24")) {
				
				dates.get(i).click();
				break;
			}
			
		}
	}

}

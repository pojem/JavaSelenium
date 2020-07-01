import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
        driver.get("http://demo.guru99.com/test/drag_drop.html");					
		Actions action = new Actions(driver);
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
    	WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
		action.dragAndDrop(From, To).build().perform();
		driver.switchTo().defaultContent();

	}

}

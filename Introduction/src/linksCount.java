import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linksCount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // url
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG")); /// limiting webdriver scope
		
		System.out.println(footer.findElements(By.tagName("a")).size());

		WebElement footer1 = driver.findElement(By.xpath("//td[1]//ul[1]")); /// limiting webdriver scope
		
		
		System.out.println(footer1.findElements(By.tagName("a")).size());
		
		for (int i = 1; i < footer1.findElements(By.tagName("a")).size();i++) {
			
			String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footer1.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);

		}
			
			
			Set<String> links = driver.getWindowHandles();
			Iterator<String> it = links.iterator();
			
			
			while(it.hasNext()){
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());

			
		}
		
		
	}

}
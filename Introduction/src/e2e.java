import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // url
		
		String[] itemsNeeded = {"Tomato","Brinjal","Pumpkin","Cauliflower"}; // this is array  # use length() method

		
		
		// now convert array in array list
		
		List al = Arrays.asList(itemsNeeded); // ARRAY LIST use .size() method
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j = 0;
		
		System.out.println(products.size());
		
		for(int i=0;i<products.size();i++) {
			
			String[] item = products.get(i).getText().split("-");
			String formatedItem = item[0].trim();
			System.out.println(formatedItem);
			
			
			
			
			if (al.contains(formatedItem)) {
				j++;
				System.out.println("sem not");
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
					
				}
				
				
			}
			
			
			
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();


	}

}

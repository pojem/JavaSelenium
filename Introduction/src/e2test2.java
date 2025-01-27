import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class e2test2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver,5);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// maximize window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // url
		String[] itemsNeeded = {"Capsicum","Pumpkin","Beans"};

		
		
		e2test2 b = new e2test2();
		b.addItems(driver, itemsNeeded); //object of class
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// explicit wait
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

	}
	
	public void addItems(WebDriver driver,String[] itemsNeeded)
	
	{
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		System.out.println(products.size());
		
		List al = Arrays.asList(itemsNeeded); 
		int j = 0;
		
		
		for (int i = 0; i <products.size();i++) {
			
			String[] item = products.get(i).getText().split("-");
			
			String formatedItem = item[0].trim();
			
			System.out.println(formatedItem);
			
			if(al.contains(formatedItem)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if (j == itemsNeeded.length) {
					break;
				}
			}
		
		}
		

	}

}

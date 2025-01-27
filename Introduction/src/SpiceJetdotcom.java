import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.*;
import java.util.concurrent.TimeUnit;

//testNG is on of the testing framework

public class SpiceJetdotcom {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://www.spicejet.com/");
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))); //important SELECT CLASS!!!
		System.out.println(driver.findElements(By.id("ctl00_mainContent_DropDownListCurrency")).size());
		String aaa = driver.findElement(By.xpath("//span[contains(text(),'Flights')]")).getText();
		System.out.println(aaa);
		
		Assert.assertEquals(aaa, "Flights");
		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isDisplayed());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isDisplayed());
		
		boolean isJavaFun = true;
		boolean isFishTasty = true;


		Assert.assertEquals(isJavaFun, isFishTasty);
		Assert.assertEquals("rrr", "rrr");

		s.selectByIndex(2);
        Thread.sleep(2000); //sleep in JAVA
		s.selectByValue("USD");
		
		int i=1;
		
		while(i<5) {
			System.out.println(i);
			i++;	
		}
		
		for(int j = 1; j<5; j++) {
			System.out.println(j);
			System.out.println(driver.findElement(By.xpath("//label[@class='select-label'][contains(text(),'One Way')]")).getText());
		}
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@text='Leh (IXL)']")).click();
		//driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click(); 
		//this up is parent child xpath
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		String xxx = driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(xxx);
		
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("is enabled");
			Assert.assertTrue(true);
			
		}
		else {
			System.out.println("is disabled");
			Assert.assertTrue(false);

			
		}
		 
	}

}

package webdriver;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css {
	WebDriver driver;
	
   @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();

  }
   
   @Test
   public void TC_01_CheckNavigatePage() {
	   driver.get("http://live.demoguru99.com/");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   String homePageTitle = driver.getTitle();
	   Assert.assertEquals(homePageTitle, "Home page");
	   
	   driver.findElement(By.xpath("//div[@class ='footer' ]//a[text()='My Account']")).click();
	   driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	 
	   driver.navigate().back();
	   // Về lại page log in thành công
	   Assert.assertTrue(driver.findElement(By.xpath("//form[@id='login-form']")).isDisplayed());
	   
	   String logUrl = driver.getCurrentUrl();
	   Assert.assertEquals(logUrl, "http://live.demoguru99.com/index.php/customer/account/login/");
	   
	   // Về lại page register thành công
	   driver.navigate().forward();
	   Assert.assertTrue(driver.findElement(By.xpath("//form[@id='form-validate']")).isDisplayed());
	   
	   String registerUrl = driver.getCurrentUrl();
	   Assert.assertEquals(registerUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
   }

   
   @Test (enabled = false)
   public void TC_02_LoginWithUserPassEmpty() {
	   driver .get("http://live.demoguru99.com/index.php");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	   driver.findElement(By.id("send2")).click();
	   
	  String usernameEmptyMessage = driver.findElement(By.id("advice-required-entry-email")).getText();
	  Assert.assertEquals(usernameEmptyMessage, "This is a required field.");
	   
	  
	  String passwordEmptyMessage = driver.findElement(By.id("advice-required-entry-pass")).getText();
	  Assert.assertEquals(passwordEmptyMessage, "This is a required field.");
 	  
	 
 
   }
   @Test (enabled = false)
   public void TC_03_LoginWithEmailInvalid() {
	   driver .get("http://live.demoguru99.com/index.php");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	   driver.findElement(By.cssSelector("#email")).sendKeys("132132@13131.13131");
	   driver.findElement(By.id("send2")).click();
	   String usernameInvalidMessage = driver.findElement(By.id("advice-validate-email-email")).getText();
	   Assert.assertEquals(usernameInvalidMessage,"Please enter a valid email address. For example johndoe@domain.com.");
 	  
	   
	  
   }
   
   @Test (enabled = false)
   public void TC_04_LoginWithPassworkLessthan6Characters() {
	   driver .get("http://live.demoguru99.com/index.php");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	   driver.findElement(By.cssSelector("#pass")).sendKeys("13132");
	   driver.findElement(By.id("send2")).click();
	   String passwordIncorrectMessage = driver.findElement(By.id("advice-validate-password-pass")).getText();
	   Assert.assertEquals(passwordIncorrectMessage, "Please enter 6 or more characters without leading or trailing spaces.");
	   
   }

   
   @Test (enabled = false)
   public void TC_05_CreatAnAccount() {
	   driver .get("http://live.demoguru99.com/index.php");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	   

	   driver.findElement(By.cssSelector("#email")).sendKeys("automation"+ randomEmail() + "@gmail.com");
	   // automation1243@gmail.com
	 
 	  
 	  
   }


   
  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }
public int randomEmail() {
	Random random = new Random();
	int number = random.nextInt(999999);
	 return number;
	
}
}

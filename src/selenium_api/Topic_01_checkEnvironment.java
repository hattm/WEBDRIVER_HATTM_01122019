package selenium_api;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_01_checkEnvironment {
	WebDriver driver;
	
  @Test
  public void TC_01_CheckUrlAndTitile() {
	  
	  String homeTitle = driver.getTitle();
	  Assert.assertEquals(homeTitle, "Guru99 Bank Home Page");
	  
	  String homePageTitle = driver.getCurrentUrl();
	  Assert.assertEquals(homePageTitle, "http://demo.guru99.com/v4/");
	  
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver .get("http://demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  
	 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}

package webdriver;

import static org.testng.Assert.assertTrue;

import java.awt.Point;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;




public class Topic_03_WebElement_Browser  {
	WebDriver driver;
	
  
  @Test
  public void TC_01() {
	  // WEB BROWSER(refresh/navigate/maximize/back/forward/...)
	  // Mở 1 page url lên
	  
	  driver.get("http://");
	  
	  // Trả về url của page hiện tại 
	  String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, "http://");
	  
	  
	  // Trả về source code của page hiện tại
	 String source_Page = driver.getPageSource();
	 Assert.assertTrue(source_Page.contains("Insurance Project"));
	 
	 // Trả về title của page hiện tại
	String title =  driver.getTitle();
	  Assert.assertEquals(title, "Guru99 Bank Home Page");
	  
	  // Trả về page id(GUID) page hiện tại -> Windows
	 String parent_UI =  driver.getWindowHandle();
	 
	 // Trả về page id của tất cả các page-> Windows
	 driver.getWindowHandles();
	 
	 // Đóng browser - nhiều tab = đóng browser
	 driver.quit();

	 // Đóng brower - chỉ đóng cái tab hiện tại(1tab = đóng browser)
	 driver.close();
	  
	 // Tương tác vs duy nhất 1 element
	 // Nếu không tìm thấy element-> Ném ra ngoại lại No Such elemenet
	WebElement emailTextbox = driver.findElement(By.id("email"));
	emailTextbox.click();
	 
	// Tương tác vs 1 list element
	 // Nếu không tìm thấy element-> trả về 1 list element empty
	List<WebElement> elements=  driver.findElements(By.id("email"));
	elements.get(0).click();
	
	// Wait cho page hiện tại được render thành công (DOM: html/css/iquery/ ajax/...)
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	//Auto GUI(Graphic User Interface) -> Check Responsive
	
	// F11: Fullscreen browser
	driver.manage().window().fullscreen();
	
	
	// 0-0: Điểm trên cùng bên trái
	// 1920 * 1080 -> 1K
	// Mobile:  iPhone/Android
	
	// Check vị trí của browser nằm trong độ phân giản của OS là bao nhiêu
	// 400 * 500
	driver.manage().window().getPosition();
	
	// Chiều rộng vs chiều cao của browser là bao nhiêu
	driver.manage().window().getSize();
	
	// Open browser -> Full browser lên( kg phải full creeen)
	driver.manage().window().maximize();
	
	// Back -> Tới page cũ
	driver.navigate().forward();
	
	// F5 lại page/ reload page
	driver.navigate().refresh();
	
	// Luôn chờ page render/load thành công trong khoảng timeout của selenium
	driver.get("http://");
	
	// Không chờ load thành công trong khoảng timeout của selenium
	driver.navigate().to("http://");
	
	Alert  alert = driver.switchTo().alert();
	alert.accept();
	alert.dismiss();
	alert.sendKeys("");
	String abc = alert.getText();
	
	// Frame/ iframe
	driver.switchTo().frame("");
	driver.switchTo().defaultContent();

	 // WEB ELEMENT (textbox/text area/ dropdown/...)
	  //01: Mỗi lần find element thì chỉ tưởng tác/ action được 1 lần
	driver.findElement(By.xpath("")).click();
	driver.findElement(By.xpath("")).sendKeys("");
	
	// 02:Khai báo 1 biến của element-> có thể action nhiều lần
	WebElement email_Textbox = driver.findElement(By.xpath(""));
	
	// Trả về empty data cho các element (textbox/ text area/dropdown)
	email_Textbox.clear();
	
	// Nhập text/value vào các element(textbox/ text area/dropdown)
	email_Textbox.sendKeys("");
	
	WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='password']"));
	String passwrodPlaceholder = passwordTextbox.getAttribute("placeholder");
	Assert.assertEquals(passwrodPlaceholder, "Text is disable");
	
	
	// Auto GUI
	String backgroudColor = email_Textbox.getCssValue("backgroud-color");
	String color = email_Textbox.getCssValue("color");
	  
	
	// Trả về vị trí của element trong màn  hình
	  email_Textbox.getLocation();
	
	// Trả về kích thước của element (rộng+cao)
	Dimension size =  email_Textbox.getSize();
	 
	
	// Trả về text của element đó
	String textElemenet = email_Textbox.getText();
	
	// Kiểm tra xem 1 element có hiển thị không -> all elemenets
	Assert.assertTrue(email_Textbox.isDisplayed());
	
	// Kiểm tra xem 1 element có hiển thị không-> element có khả năng enable/disable(textbox/text area/dropdown/radio/checkbox)
		Assert.assertTrue(!email_Textbox.isEnabled());
		Assert.assertFalse(email_Textbox.isEnabled());
	  
		// Kiểm tra xem 1 element đã được chọn hay không-> radio/checkbox(Dropdown có riêng 1 API)
		Assert.assertTrue(email_Textbox.isSelected());
		
		// Click vào element(button/radio/checkbox/link/dropdown/image..)
		email_Textbox.click();
		
		// Gửi sự kiện ENTER cho element mà nó thao tác
		// Form: Login/Register/ Search
		email_Textbox.submit();
  }
}

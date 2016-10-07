import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class CloudAlbumDownload {
	WebDriver driver;
	private static void switchWindow(WebDriver driver){
		        //切换浏览器窗口到新开的云相册详情页窗口
				for(String winHandle:driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
	}
	@Test
	public static void albumdownload(){
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://photo.163.com");
		
		WebElement learnMoreLinkElement=driver.findElement(By.partialLinkText("了解更多"));
		learnMoreLinkElement.click();
		
		switchWindow(driver);
		WebElement iphoneDownloadlinkElement=driver.findElement(By.id("J-iphone"));
		iphoneDownloadlinkElement.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	}
			@AfterClass (alwaysRun= true)
			public void afterClass(){
				driver.quit();	
}
}
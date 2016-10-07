import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DeleteAlbum {
	public static void main(String[] args){
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://photo.163.com");
		// 切换到登录有关操作所在的子页面
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='http://blog.163.com/newpage/ursweb/tmpl2/loginurs.html']")));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		
		driver.findElement(By.name("email")).sendKeys("314922902@qq.com");
		driver.findElement(By.name("password")).sendKeys("wsk6821051");
		driver.findElement(By.id("dologin")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
		WebElement albumElement = driver.findElement(By.xpath("//span[text()='进入我的相册']"));
		albumElement.click();
		
		WebElement albumTest =driver.findElement(By.xpath("//img[@title='我的相册0828']"));
	
		new Actions(driver).moveToElement(albumTest).build().perform();
		
		
		driver.findElement(By.xpath("//img[@title='我的相册0828']/../../..//a[@title='删除']")).click();
		driver.findElement(By.xpath("//button[text()='确 定']")).click();
		
		driver.quit();
		
	}
}	
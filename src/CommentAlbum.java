

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommentAlbum  {
	
	private static void submitcomment(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://photo.163.com");
		// �л�����¼�йز������ڵ���ҳ��
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='http://blog.163.com/newpage/ursweb/tmpl2/loginurs.html']")));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		
//		driver.findElement(By.name("email")).sendKeys("314922902@qq.com");
		driver.findElement(By.name("email")).sendKeys("18767191571@163.com");
		driver.findElement(By.name("password")).sendKeys("wsk6821051");
		driver.findElement(By.id("dologin")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
		WebElement albumElement = driver.findElement(By.xpath("//span[text()='�����ҵ����']"));
		albumElement.click();		
		driver.findElement(By.xpath("//img[@title='��������������']")).click();
		
		//�������
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='j-main']//iframe")));
		driver.findElement(By.xpath("//body")).sendKeys("�������");
		driver.switchTo().defaultContent();
		WebElement submitCommentButtonElement=driver.findElement(By.xpath("//input[@value='����']"));
		submitCommentButtonElement.click();
		
		
		driver.quit();
		
	}
	public static void main(String[] args){
		submitcomment();
	}
}

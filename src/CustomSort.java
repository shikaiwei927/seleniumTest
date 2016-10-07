import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class CustomSort {
	public static void main(String[] args){
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://photo.163.com");
		// �л�����¼�йز������ڵ���ҳ��
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='http://blog.163.com/newpage/ursweb/tmpl2/loginurs.html']")));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		
		driver.findElement(By.name("email")).sendKeys("314922902@qq.com");
		driver.findElement(By.name("password")).sendKeys("wsk6821051");
		driver.findElement(By.id("dologin")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
		WebElement albumElement = driver.findElement(By.xpath("//span[text()='�����ҵ����']"));
		albumElement.click();	
		
		WebElement sortElement = driver.findElement(By.xpath("//span[text()='����']"));
		sortElement.click();
		
		WebElement customsortElement = driver.findElement(By.xpath("//a[text()='�Զ�������']"));
		customsortElement.click();
		WebElement element =driver.findElement(By.xpath("//div[@title='A']"));
		WebElement target=driver.findElement(By.xpath("//div[@title='C']"));
		Actions act=new Actions(driver);
		act.dragAndDrop(element, target).perform();
		driver.findElement(By.partialLinkText("����")).click();
		
		driver.quit();
				
		
		
		
		
	
				
	}
}

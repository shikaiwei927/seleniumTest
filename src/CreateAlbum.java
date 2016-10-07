import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.thoughtworks.selenium.webdriven.commands.Click;


@Test
public class CreateAlbum {
	WebDriver driver;
	String albumName;
	@BeforeClass
	public void beforeClass() {
		//�������
		driver=new FirefoxDriver();
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
				System.out.println(albumElement.getText());
				albumElement.click();	
				//���Ԫ���İ�
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
//				Assert.assertEquals(albumElement.getText(), "�����ҵ����","��¼��,δ��ʾ�����ҵ����");
//				albumElement.click();
//				//�õ���ǰҳ���ַ
//				Assert.assertEquals(driver.getCurrentUrl(), "http://photo.163.com/314922902@qq.com/#m=0&p=1","��¼��,�����ҵ�������Ӵ���");
//				//�õ���ǰҳ�����
//				Assert.assertEquals(driver.getTitle(), "314922902@qq.com���������_314922902@qq.com���������Ƭ�洢_�������","��¼��,�����ҵ�������");
				
	}
	@Test(dataProvider="data")
	public  void createAlbumTest(String name){
				WebElement createAlbumButtonElement=driver.findElement(By.xpath("//a[text()='�������']"));
				createAlbumButtonElement.click();
				albumName=String.valueOf(System.currentTimeMillis())+name;
				driver.findElement(By.name("fm-0")).sendKeys(albumName);
				driver.findElement(By.name("fm-a")).click();
				
//				WebElement confirmButtonElement=driver.findElement(By.name("fm-a"));
//				confirmButtonElement.click();
				//��֤��ǰ���������´��������
				String albumRealName=driver.findElement(By.className("extra-menu")).findElement(By.tagName("span")).getText();
				Assert.assertEquals(albumName,albumRealName);
	}
				
				@DataProvider
				public Object[][] data() {
					return new Object[][]
							{ {"��"},
							{"En"}
							};
				}
				/*
				@AfterMethod
				public void afterMethod(){
					driver.get("http://photo.163.com/autotest1");
					//���ɾ��
					Actions actions =new Actions(driver);
//					actions.moveToElement(driver,FindElement(By.xpath("//div[@class='item']/div[@class='ln ln0']/span[start-with(text(),\""+ albumName.substring(0.9)+"\")]")))
//					.click(driver.findElement((By.className("t-a")))
//							.perform();
					//���ȷ��
					driver.findElement(By.className("ui-btn-sub0")).click();
				
				
//				Alert alert=driver.switchTo().alert();
//				alert.accept();
				

		
	}
	*/
	@AfterClass(alwaysRun=true)
	public void afterClass(){
	driver.quit();
	}		
		
	}






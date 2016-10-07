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
		//打开浏览器
		driver=new FirefoxDriver();
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
				System.out.println(albumElement.getText());
				albumElement.click();	
				//输出元素文案
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
//				Assert.assertEquals(albumElement.getText(), "进入我的相册","登录后,未显示进入我的相册");
//				albumElement.click();
//				//得到当前页面地址
//				Assert.assertEquals(driver.getCurrentUrl(), "http://photo.163.com/314922902@qq.com/#m=0&p=1","登录后,进入我的相册链接错误");
//				//得到当前页面标题
//				Assert.assertEquals(driver.getTitle(), "314922902@qq.com的网易相册_314922902@qq.com个人相册相片存储_网易相册","登录后,进入我的相册错误");
				
	}
	@Test(dataProvider="data")
	public  void createAlbumTest(String name){
				WebElement createAlbumButtonElement=driver.findElement(By.xpath("//a[text()='创建相册']"));
				createAlbumButtonElement.click();
				albumName=String.valueOf(System.currentTimeMillis())+name;
				driver.findElement(By.name("fm-0")).sendKeys(albumName);
				driver.findElement(By.name("fm-a")).click();
				
//				WebElement confirmButtonElement=driver.findElement(By.name("fm-a"));
//				confirmButtonElement.click();
				//验证当前的相册就是新创建的相册
				String albumRealName=driver.findElement(By.className("extra-menu")).findElement(By.tagName("span")).getText();
				Assert.assertEquals(albumName,albumRealName);
	}
				
				@DataProvider
				public Object[][] data() {
					return new Object[][]
							{ {"中"},
							{"En"}
							};
				}
				/*
				@AfterMethod
				public void afterMethod(){
					driver.get("http://photo.163.com/autotest1");
					//点击删除
					Actions actions =new Actions(driver);
//					actions.moveToElement(driver,FindElement(By.xpath("//div[@class='item']/div[@class='ln ln0']/span[start-with(text(),\""+ albumName.substring(0.9)+"\")]")))
//					.click(driver.findElement((By.className("t-a")))
//							.perform();
					//点击确认
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






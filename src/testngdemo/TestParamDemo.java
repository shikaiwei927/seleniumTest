package testngdemo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParamDemo {
	@Test(groups={"smoketest"},dependsOnMethods={"testMethodB"})
	public void testMethodA(){
		System.out.println("testMethodA执行!");
		int i1=1;
		int i2=2;
		int i3=i1+i2;
		Assert.assertEquals(i3, 2);
	}
	@Test(groups={"smoketest","regressiontest"})
	public void testMethodB() {
		System.out.println("testMethodB执行!");
		String helloString="Hello TestNG!";
		Assert.assertEquals(helloString.length(),14 );
	}
	@BeforeClass
	public void doBeforeClass() {
		System.out.println("BeforeClass标记的方法执行!");
	}
	@AfterClass
	public void doAfterClass() {
	System.out.println("AfterClass标记的方法执行!");
	}
}

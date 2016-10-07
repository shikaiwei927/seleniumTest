package testngdemo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParamDemo {
	@Test(groups={"smoketest"},dependsOnMethods={"testMethodB"})
	public void testMethodA(){
		System.out.println("testMethodAִ��!");
		int i1=1;
		int i2=2;
		int i3=i1+i2;
		Assert.assertEquals(i3, 2);
	}
	@Test(groups={"smoketest","regressiontest"})
	public void testMethodB() {
		System.out.println("testMethodBִ��!");
		String helloString="Hello TestNG!";
		Assert.assertEquals(helloString.length(),14 );
	}
	@BeforeClass
	public void doBeforeClass() {
		System.out.println("BeforeClass��ǵķ���ִ��!");
	}
	@AfterClass
	public void doAfterClass() {
	System.out.println("AfterClass��ǵķ���ִ��!");
	}
}

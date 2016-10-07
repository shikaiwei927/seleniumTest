package testngdemo;

import org.testng.annotations.Test;



public class HelloTestNG {
	@Test
	public void testMethodA(){
		System.out.println("testMethodA成功执行!");
	}
	
	@Test
	public void testMethodB(){
		System.out.println("testMethodB成功执行!");
}
}

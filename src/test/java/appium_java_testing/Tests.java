package appium_java_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class Tests {
	
	//AndroidDriver driver;
	AppiumDriver driver;
	
	@BeforeTest
	public void setup() {
		
		
		final String url = "http://127.0.0.1:4723/wd/hub";

		URL Url = new URL (url);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
//		capabilities.setCapability(MobileCapabilityType.APP, "com.example.new_sample");
//		capabilities.setCapability("appActivity", "com.example.new_sample.MainActivity");
		driver = new AppiumDriver(Url, capabilities);
		
	}
	
	@Test
	public void test() {
		System.out.println("Application started ...");
		driver.findElement(By.id("button2")).click();
		driver.findElement(By.id("button_multi")).click();
		driver.findElement(By.id("button2")).click();
		Assert.assertEquals("4", driver.findElement(By.id("output")).getText());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

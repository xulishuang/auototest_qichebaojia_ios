package script;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class AppTestSuite {

	@SuppressWarnings("rawtypes")
	protected static IOSDriver driver;
	@SuppressWarnings("rawtypes")
	public static IOSDriver getDriver(){
		return driver;
	}
	
	@SuppressWarnings("rawtypes")
	@BeforeSuite
 	public void beforeSuite() throws Exception {
		// set up appium
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "t.ipa");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.1.2");
//		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("device", "iPhone 6 Plus");
		capabilities.setCapability("deviceName", "iPhone 6 Plus");
		capabilities.setCapability("udid","279e59757a20062b7fb2f82586ca7ed5426352c4");
		capabilities.setCapability("bundleId", "com.bitauto.carquote");
		capabilities.setCapability("noSign", true);// 禁止重签名
//		capabilities.setCapability("autoAcceptAlerts", true);// 自动接受提示信息
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		if(Common.checkTextExist(driver, "nav right close")){
			Common.touchText(driver, "nav right close");
			if(Common.checkTextExist(driver, "不保存")){
				Common.touchText(driver, "不保存");
			}
		}
		
		if(Common.checkTextExist(driver, "取消")){
			Common.touchText(driver, "取消");
			if(Common.checkTextExist(driver, "不保存")){
				Common.touchText(driver, "不保存");
			}
		}
		  
		while(Common.checkTextExist(driver, "navBackButton nor")||Common.checkTextExist(driver,"old navBackButton nor")){
			  Common.back(driver);
			  Thread.sleep(500);
		  }
		  
		  if(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]")&&Common.checkTextExist(driver, "品牌介绍")){
			 Common.swipeToRight(driver, 500, 1);
		  }
	  }
	
	
}

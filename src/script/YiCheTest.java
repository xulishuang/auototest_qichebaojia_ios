package script;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class YiCheTest {
	@SuppressWarnings("rawtypes")
	protected static IOSDriver driver;
	@SuppressWarnings("rawtypes")
	@BeforeSuite
 	public void beforeSuite() throws Exception {
		// set up appium
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "t.ipa");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3.5");
//		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("device", "iPhone 6");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("udid","da948fb4cfa15a6d726cfa90017987ce1c481ecf");
		capabilities.setCapability("bundleId", "bitauto.application");
		capabilities.setCapability("noSign", true);// 禁止重签名
//		capabilities.setCapability("autoAcceptAlerts", true);// 自动接受提示信息
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void loading_testcase() throws InterruptedException{
		
//		Common.screenShotToimage(driver);
//		Thread.sleep(5000);
        
		int success_times=0;
		int fail_times=0;
		for(int i=0;i<100;i++){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
			if(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAStaticText[1]")){
				success_times=success_times+1;
			}else{
				Thread.sleep(3000);
				if(Common.checkTextExist(driver, "点击重新加载")){
					success_times=success_times+1;
				}else{
					Common.screenShotToimage(driver);
					fail_times=fail_times+1;
					System.out.println("第"+fail_times+"次测试失败");
				}
			}
			//返回，关闭新闻页面
			Common.touchText(driver,"ic arrow nor");
		}
		
		System.out.println("success times: "+success_times);
		System.out.println("fail times: "+fail_times);
	
	}
	
	@AfterSuite
	public void afterSuite()
	{
		driver.quit();
	}
}

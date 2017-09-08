package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class Common {
//	@SuppressWarnings("rawtypes")
//	public IOSDriver driver;

//	@SuppressWarnings("rawtypes")
//	public Common(IOSDriver driver){
//		this.driver=driver;
//	}
	
	/** 
	 * 上滑
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	@SuppressWarnings("rawtypes")
	public static void swipeToUp(IOSDriver driver,int during, int num) {  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
	    }  
	} 
	
	/** 
	 * 下滑
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	@SuppressWarnings("rawtypes")
	public static void swipeToDown(IOSDriver driver,int during, int num) {  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
//	    System.out.println(width);  
//	    System.out.println(height);  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during); 
	    }  
	} 
	/** 
	 * 左滑
	 *   
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	@SuppressWarnings("rawtypes")
	public static void swipeToLeft(IOSDriver driver,int during, int num) {  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
	          
	    }  
	}  
	  
	/** 
	 * 右滑
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	@SuppressWarnings("rawtypes")
	public static void swipeToRight(IOSDriver driver,int during, int num) {  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 4, height / 2, width * 9/10, height / 2, during);  
	    }  
	}
	
	/** 
	 * 点击text
	 * 
	 * @param driver 
	 * @param text 
	 */
	@SuppressWarnings("rawtypes")
	public static void touchText(IOSDriver driver, String text){
		Common.waitForVisible(driver, By.name(text), 20);
		WebElement el = driver.findElement(By.name(text));
		driver.tap(1, el, 10);
	}
	
	/** 
	 *滑动点击text 
	 *
	 * @param driver 
	 * @param text 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void touchSlideText(IOSDriver driver, String text, int times){
		for (int i=0;i<times;i++){
			if (Common.checkTextNotExist(driver, text)){
				Common.swipeToUp(driver, 1000, 1);
			}else{
				break;
			}
		}
//		WebElement el = driver.findElement(By.name(text));
//        el.click(); 
		Common.touchText(driver,text);
	}
	
	/** 
	 * @function 点击Xpath
	 *
	 * @param driver 
	 * @param xpath 
	 */
	@SuppressWarnings("rawtypes")
	public static void touchXpath(IOSDriver driver, String xpath){
		Common.waitForVisible(driver, By.xpath(xpath), 20);
		WebElement el = driver.findElement(By.xpath(xpath));
		driver.tap(1, el, 10);
	}	
	
	/** 
	 * @function 滑动点击 Xpath
	 *
	 * @param driver 
	 * @param xpath 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void touchSlideXpath(IOSDriver driver, String xpath, int times){
		for (int i=0;i<times;i++){
			if (Common.checkXpathNotExist(driver, xpath)){
				Common.swipeToUp(driver, 1000, 1);
			}else{
				break;
			}
		}
//		WebElement el = driver.findElement(By.name(text));
//        el.click(); 
		Common.touchXpath(driver,xpath);
	}
	
	/** 
	 * 检查文本存在
	 *  
	 * @param driver 
	 * @param text 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkTextExist(IOSDriver driver, String text){
	
		List list=driver.findElements(By.name(text));
		
		if (list.size()==0)
			return false;
		else
			return true;
	}
	
	/** 
	 * 检查文本不存在
	 *  
	 * @param driver 
	 * @param text 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkTextNotExist(IOSDriver driver, String text){
		
		List list=driver.findElements(By.name(text));
		
		if (list.size()==0)
			return true;
		else
			return false;
	}
	
	/** 
	 * 检查id存在
	 *  
	 * @param driver 
	 * @param xpath
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkXpathExist(IOSDriver driver, String xpath){
		
		List list=driver.findElements(By.xpath(xpath));
		
		if (list.size()==0)
			return false;
		else
			return true;
	}
	
	/** 
	 * 检查id不存在
	 *  
	 * @param driver 
	 * @param xpath
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkXpathNotExist(IOSDriver driver, String xpath){
		
		List list=driver.findElements(By.xpath(xpath));
		
		if (list.size()==0)
			return true;
		else
			return false;
	}
	
	/** 
	 * 检查控件被选中
	 *  
	 * @param driver 
	 * @param xpath
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkIsSelected(IOSDriver driver, String xpath){
		String text=Common.getAttribute(driver, By.xpath(xpath), "value");
		if(text.equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	/** 
	 * 检查控件被选中
	 *  
	 * @param driver 
	 * @param xpath
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkIsSelected(IOSDriver driver, By by){
		String text=Common.getAttribute(driver, by, "value");
		if(text.equals("1")){
			return true;
		}else{
			return false;
		}
	}

	/**
     * 返回
     * 
     * @param driver
     * 
     */
	@SuppressWarnings("rawtypes")
	public static void back (IOSDriver driver){
		if(Common.checkTextExist(driver, "navBackButton nor")){
			Common.touchText(driver, "navBackButton nor");
		}else if(Common.checkTextExist(driver,"old navBackButton nor")){
			Common.touchText(driver, "old navBackButton nor");
		}
	}
	
	/**
     * @function 多次返回
     * @param driver
	 * @throws InterruptedException 
     * @author xulishuang
     * @time 2017-5-31
     */
	@SuppressWarnings("rawtypes")
	public static void multiBack (IOSDriver driver, int num){
		for (int i=0;i<num;i++){
			Common.back(driver);
			Common.sleep(driver,1);
		}
	}
	
	/**
     * @function 关闭页面
     * @param driver
     * @author xulishuang
     * @time 2017-5-31
     */
	@SuppressWarnings("rawtypes")
	public static void close (IOSDriver driver){
		Common.touchText(driver, "nav right close");
	}
	
	/**
     * 截屏
     * 
     * @param driver
     * @param filename
     */
    public static void snapshot(TakesScreenshot driver, String filename) {
        String currentPath = System.getProperty("user.dir");
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("Saved snapshot's path is:" + currentPath + "/"
                    + filename);
            FileUtils.copyFile(scrFile, new File(currentPath + "/image/" + filename));
        } catch (IOException e) {
            System.out.println("Can't save screenshot!");
            e.printStackTrace();
        } 
    }
    
    @SuppressWarnings("rawtypes")
    public static String getAttribute(IOSDriver driver, By by, String attribute){
    	Common.waitForVisible(driver, by, 15);
    	WebElement el=driver.findElement(by);
    	return el.getAttribute(attribute);
    }

    @SuppressWarnings("rawtypes")
    public static String getText(IOSDriver driver, By by){
    	Common.waitForVisible(driver, by, 15);
    	WebElement el=driver.findElement(by);
    	return el.getAttribute("name");
    }
    
    @SuppressWarnings("rawtypes")
	public static void sendText(IOSDriver driver, By by,String text){
    	WebElement el=driver.findElement(by);
    	el.clear();
    	el.sendKeys(text);
    }
    
    /**
     * UIAPicker控件设值
     */
    @SuppressWarnings("rawtypes")
	public static void selectValue(IOSDriver driver, String text){
    	WebElement el=driver.findElement(By.className("UIAPickerWheel"));
    	el.sendKeys(text);	
    }
    
//    /**
//     * UIAPicker控件设值
//     */
//    @SuppressWarnings("rawtypes")
//	public static void selectValue(IOSDriver driver, String text, int index){
//    	List list=driver.findElements(By.className("UIAPickerWheel"));
//    	WebElement el=(WebElement) list.get(1);
//    	el.sendKeys(text);	
//    }
    
    /**
     * 显示等待
     * 
     * @param driver
     * @param by
     * @param waitTime 单位为秒
     */
    @SuppressWarnings("rawtypes")
	public static void waitForVisible(IOSDriver driver, final By by, int waitTime) {  
        WebDriverWait wait = new WebDriverWait(driver, waitTime);  
        for (int attempt = 0; attempt < waitTime; attempt++) {  
            try {  
                driver.findElement(by);  
                break;  
            } catch (Exception e) {  
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);  
            }  
        }  
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));  
    }
    
    @SuppressWarnings("rawtypes")
	public static void longPress(IOSDriver driver, By by){
    	WebElement el=driver.findElement(by);
       driver.tap(1, el, 3000);
    	
    }
    
    @SuppressWarnings("rawtypes")
	public static void screenShot(IOSDriver driver, String screenShotName){
    	//截图......................................................
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String now = sdf.format(date);
//
//        String screenShotName = System.getProperty("user.dir")+"\\image"+File.separator+now+"_"+tr.getMethod().getMethodName()+".png";
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(screenShotName));    
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("rawtypes")
	public static void screenShotToimage(IOSDriver driver){
    	//截图......................................................
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = sdf.format(date);

//        String screenShotName = System.getProperty("user.dir")+"\\image"+File.separator+now+".png";
        String screenShotName = System.getProperty("user.dir")+"/image"+File.separator+now+".png";
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(screenShotName));    
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("rawtypes")
	public static int getScreenWidth(IOSDriver driver){
    	int width=driver.manage().window().getSize().width;
    	return width;
    }
    
    @SuppressWarnings("rawtypes")
	public static int getScreenHeight(IOSDriver driver){
    	int height=driver.manage().window().getSize().height;
    	return height;
    }
    
    @SuppressWarnings("rawtypes")
	public static void touchLocation(IOSDriver driver, int x, int y){
    	driver.tap(1, x, y, 100);
    }
    
    @SuppressWarnings("rawtypes")
	public static void touchTopRight(IOSDriver driver){
    	Common.touchLocation(driver,410,40); //iphone 6 plus
    }
    
    public static String getRandomString(int length){ //length表示生成字符串的长度
		String base="abcdefghigklmnopqrstuvwxyz0123456789";
    	Random random=new Random();
    	StringBuffer sb=new StringBuffer();
    	for(int i=0;i<length;i++){
    		int number=random.nextInt(base.length());
    		sb.append(base.charAt(number));
    	}
    	return sb.toString();
    }
    
    @SuppressWarnings("rawtypes")
	public static void sleep(IOSDriver driver, int seconds){
    	try{
    		Thread.sleep(seconds*1000);
    	}catch(InterruptedException e){
    		//TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }

}

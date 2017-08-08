package models;

import org.openqa.selenium.By;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class BangMaiChe {
	@SuppressWarnings("rawtypes")
	public IOSDriver driver;

	@SuppressWarnings("rawtypes")
	public BangMaiChe(IOSDriver driver){
		this.driver=driver;
	}
	
	/** 
	 * @function “帮买车—投票-车款投票”中添加两种车款
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-31
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void addCars(IOSDriver driver) throws InterruptedException{
		//添加两种车款
	    Common.touchText(driver, "添加车款");
	    Common.touchText(driver, "奥迪");
	    Common.touchText(driver, "奥迪A4L");
	    Common.touchText(driver, "40 TFSI 进取型 Plus");
        
	    Common.touchText(driver, "添加车款");// xpath://UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]
	    Common.touchText(driver, "奥迪");
	    Common.touchText(driver, "奥迪A6L");
	    Common.touchText(driver, "TFSI 技术型");
	}
	
	/** 
	 * @function “帮买车—投票-车型投票”中添加两种车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-31
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void addModels(IOSDriver driver) throws InterruptedException{
		//添加两种车型
		Common.touchText(driver,"添加车型");
		Common.touchText(driver,"奥迪");
		Common.touchText(driver,"奥迪A4L");
		  
		Common.touchText(driver,"添加车型");
		Common.touchText(driver,"奥迪");
		Common.touchText(driver,"奥迪A6L");
	}
	
	/** 
	 * @function “帮买车—发帖”发布普通话题
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-25
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void releaseGeneralTopic(IOSDriver driver) throws InterruptedException{
		//点击进入帮买车
		Common.touchText(driver,"帮买车");
		//点击最新
		Common.touchText(driver,"最新");
		//点击发帖
		Common.touchText(driver,"发帖");
		//点击话题icon
		Common.touchText(driver, "话题");
		//输入内容
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "签到啦啦啦啦");
		//点击提交
//		Common.touchText(driver, "发布");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	}
	
	/** 
	 * @function “帮买车—发帖”发布投票话题
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-25
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void releaseVoteTopic(IOSDriver driver) throws InterruptedException{
		//点击进入帮买车
		Common.touchText(driver,"帮买车");
		//点击最新
		Common.touchText(driver,"最新");
		//点击发帖
		Common.touchText(driver,"发帖");
		//点击投票icon
		Common.touchText(driver, "投票");
		//添加两种车型
		BangMaiChe.addModels(driver);
	    //选择在意方面：
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]");
		//点击发布
//		Common.touchText(driver,"发布");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	}
	
	/** 
	 * @function 帮买车-添加用户关注
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-25
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void addUserFollow(IOSDriver driver) throws InterruptedException{
		Common.touchText(driver, "帮买车");
		Common.touchText(driver, "最新");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		Common.touchText(driver, "btn guanzhu nor");
		Common.back(driver);
	}
	
	/** 
	 * @function 帮买车-添加话题收藏
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-25
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void addTopicCollection(IOSDriver driver) throws InterruptedException{
		Common.touchText(driver, "帮买车");
		Common.touchText(driver, "最新");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "unfav nor");
		Common.back(driver);
	}
	
	/** 
	 * @function 帮买车-添加话题草稿
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-25
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void addTopicDraft(IOSDriver driver) throws InterruptedException{
		//点击最新
		Common.touchText(driver,"最新");
		//点击发帖
		Common.touchText(driver,"发帖");
		//点击话题icon
		Common.touchText(driver, "话题");
		//输入内容
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "签到啦啦啦啦");
		//点击取消
		Common.touchText(driver, "取消");
		//点击保存草稿
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"); 
	}

}

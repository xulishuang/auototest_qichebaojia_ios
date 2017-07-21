package models;

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

}

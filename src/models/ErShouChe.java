package models;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class ErShouChe {
	
	@SuppressWarnings("rawtypes")
	public IOSDriver driver;

	@SuppressWarnings("rawtypes")
	public ErShouChe(IOSDriver driver){
		this.driver=driver;
	}
	
	/**
	 * @function 进入二手车车源详情页面
	 * @param driver
	 * @author xulishuang
	 * @throws InterruptedException 
	 * @time 2017-6-7
	 */
	@SuppressWarnings("rawtypes")
	public static void enterUsedCarDetailPage(IOSDriver driver) {
		//进入二手车车源详情页面
 		Common.touchText(driver,"二手车");
 		Common.touchXpath(driver," //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	}
	
	/**
	 * @function 进行二手车收藏
	 * @param driver
	 * @author xulishuang
	 * @throws InterruptedException 
	 * @time 2017-6-7
	 */
	@SuppressWarnings("rawtypes")
	public static void collectUsedCar(IOSDriver driver) {
		//收藏二手车
 		Common.touchText(driver,"二手车");
 		Common.touchXpath(driver," //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
 		Common.touchText(driver,"unfav nor");
 		Common.multiBack(driver,2);
	}

}

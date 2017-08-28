package models;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class XinChe {
	
	@SuppressWarnings("rawtypes")
	public IOSDriver driver;

	@SuppressWarnings("rawtypes")
	public XinChe(IOSDriver driver){
		this.driver=driver;
	}
	
	/** 
	 * @function 进入子品牌综述页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterZongShuPage(IOSDriver driver){
		Common.touchText(driver, "新车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	}
	
	/** 
	 * @function 进入子品牌经销商页面
	 * @precondition 新车首页
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-14
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterZiPinPaiJingXiaoShangPage(IOSDriver driver){
		XinChe.enterZongShuPage(driver);
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]");
	}
	
	/** 
	 * @function 进入车型收藏页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-6
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterCheXingShouCangPage(IOSDriver driver){
		Common.touchText(driver, "新车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
	}
	
	/** 
	 * @function 进入条件选车页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterTiaoJianXuanChePage(IOSDriver driver){
		Common.touchText(driver, "新车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
	}
	
	/**
	 * @function 进行车型收藏
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-6
	 */
	@SuppressWarnings("rawtypes")
	public static void collectModels(IOSDriver driver){
		//收藏车型
 		Common.touchText(driver,"新车");
 		Common.touchText(driver,"奥迪");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");//点击奥迪Q5
 		Common.touchText(driver,"unfav nor");
 		Common.back(driver);
 		Common.swipeToRight(driver, 500, 1);
	}
	
	/**
	 * @function 进行经销商收藏
	 * @param driver
	 * @author xulishuang
	 * @ 
	 * @time 2017-6-7
	 */
	@SuppressWarnings("rawtypes")
	public static void collectDealers(IOSDriver driver) {
		//收藏经销商
 		Common.touchText(driver,"新车");
 		Common.touchText(driver,"奥迪");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");//点击奥迪Q5
 		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
 		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
 		Common.touchText(driver,"unfav nor");
 		Common.multiBack(driver,3);
 		Common.swipeToRight(driver, 500, 1);
	}
	
	/**
	 * @function 进行车款收藏
	 * @param driver
	 * @author xulishuang
	 * @ 
	 * @time 2017-6-7
	 */
	@SuppressWarnings("rawtypes")
	public static void collectCars(IOSDriver driver) {
		//收藏车款
 		Common.touchText(driver,"新车");
 		Common.touchText(driver,"奥迪");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");//点击奥迪Q5
 		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
 		Common.touchText(driver,"unfav nor");
 		Common.multiBack(driver,2);
 		Common.swipeToRight(driver, 500, 1);
	}
	
	
}

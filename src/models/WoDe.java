package models;

import common.Common;
import io.appium.java_client.ios.IOSDriver;

public class WoDe {
	@SuppressWarnings("rawtypes")
	public IOSDriver driver;

	@SuppressWarnings("rawtypes")
	public WoDe(IOSDriver driver){
		this.driver=driver;
	}
	
	/** 
	 * @function 进入“我的社区-话题”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterTopicPage(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	}
	
	/** 
	 * @function 清空“我的社区-话题”中所有话题
	 * @initial 话题页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setTopicEmpty(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		//清空已发话题
		while (Common.checkTextNotExist(driver,"您还没有发表过话题")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			Common.touchText(driver, "topic btn action 4 nor");
			Common.touchText(driver,"确定");
		}
		//返回首页
		Common.back(driver);
		Common.touchText(driver, "old navBackButton nor");
	}
	
	/** 
	 * @function 清空“车型收藏-车型”中已收藏车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setModelsCollectionEmpty(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		//清空车型收藏
		while (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
			Common.touchText(driver, "fav nor");
			Common.back(driver);
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“浏览记录-车型”中已浏览车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setModelsBrowseEmpty(IOSDriver driver) throws InterruptedException{
		//进入浏览记录
		Common.touchText(driver,"我的");
		Common.touchText(driver, "浏览记录");
		//清空浏览记录
		if (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver);
			Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“车型收藏-车款”中已收藏车款
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setCarCollectionEmpty(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"车款");
		//清空已发话题
		while (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
			Common.touchText(driver, "fav nor");
			Common.back(driver);
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“车型收藏-二手车”中已收藏车款
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setUsedCarCollectionEmpty(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"二手车");
		//清空已发话题
		while (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
			Common.touchText(driver, "fav nor");
			Common.back(driver);
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“车型收藏-经销商”中已收藏经销商
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setDealersCollectionEmpty(IOSDriver driver) throws InterruptedException{
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"经销商");
		//清空已发话题
		while (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver); //点击编辑
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
			Common.touchTopRight(driver); //点击完成
		}
		//返回首页
		Common.back(driver);
	}

}

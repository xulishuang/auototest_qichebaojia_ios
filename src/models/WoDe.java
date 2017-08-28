package models;

import org.openqa.selenium.By;

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
	public static void enterTopicPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	}
	
	/** 
	 * @function 进入“我的社区-评论”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterCommentPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
	}
	
	/** 
	 * @function 进入“我的社区-关注”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterFollowPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[3]");
	}
	
	/** 
	 * @function 进入“我的社区-关注”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterFansPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[4]");
	}
	
	/** 
	 * @function 进入“我的社区-收藏夹”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterTopicCollectionPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	}
	
	/** 
	 * @function 进入“我的社区-草稿箱”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterDraftsPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
	}
	
	/** 
	 * @function 进入“我的社区-收到的赞”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterReceivedPraisePage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
	}
	
	/** 
	 * @function 进入“我的社区-收到的评论”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterReceivedCommentPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
	}
	
	/** 
	 * @function 进入“我的社区-提到我的”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterMentionedMePage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]");
	}
	
	/** 
	 * @function 进入“我的社区-社区通知”页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterCommunityNotificationPage(IOSDriver driver) {
		//进入我的社区-话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]");
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
	public static void setTopicEmpty(IOSDriver driver) {
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
	 * @function 清空 我的社区-评论 已发评论
	 * @param driver
	 * @
	 * @author xulishuang
	 * @date 2017-7-26
	 */
	@SuppressWarnings("rawtypes")
	public static void setCommentsEmpty(IOSDriver driver) {
		//清空评论
		Common.touchText(driver, "我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");//点击评论
		while(Common.checkTextExist(driver, "删除")){
			Common.touchText(driver, "删除");
			Common.touchText(driver, "确定");
			}
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 清空 我的社区-关注 已关注列表
	 * @param driver
	 * @
	 * @author xulishuang
	 * @date 2017-7-26
	 */
	@SuppressWarnings("rawtypes")
	public static void setFollowsEmpty(IOSDriver driver) {
		//清空评论
		WoDe.enterFollowPage(driver);//点击评论
		while(Common.checkTextExist(driver, "myAttention xhgz nor")){
			Common.touchText(driver, "myAttention xhgz nor");//若有相互关注，点击取消关注
		}
		while(Common.checkTextExist(driver, "myAttention ygz nor")){
			Common.touchText(driver, "myAttention ygz nor");//若有已关注，点击取消关注
		}
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 清空 我的社区-收藏夹 已收藏话题
	 * @param driver
	 * @
	 * @author xulishuang
	 * @date 2017-7-26
	 */
	@SuppressWarnings("rawtypes")
	public static void setTopicCollectionEmpty(IOSDriver driver) {
		//清空评论
		WoDe.enterTopicCollectionPage(driver);//进入收藏夹
		while(Common.checkTextExist(driver, "topic btn action 6 nor")){
			Common.touchText(driver, "topic btn action 6 nor");
			}
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 清空 我的社区-草稿箱 所有草稿
	 * @param driver
	 * @
	 * @author xulishuang
	 * @date 2017-7-26
	 */
	@SuppressWarnings("rawtypes")
	public static void setDraftsEmpty(IOSDriver driver) {
		//清空评论
		WoDe.enterDraftsPage(driver);//进入草稿箱
		while(Common.checkTextExist(driver, "删除")){
			Common.touchText(driver, "删除");
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
			}
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * @function 清空“车型收藏-车型”中已收藏车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setModelsCollectionEmpty(IOSDriver driver) {
		//进入我的-车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		//清空车型收藏
		if (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
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
	public static void setCarCollectionEmpty(IOSDriver driver) {
		//进入我的-车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"车款");
		//清空已收藏车款
		if (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
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
	public static void setUsedCarCollectionEmpty(IOSDriver driver) {
		//进入我的-车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"二手车");
		//清空已收藏车款
		if (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
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
	public static void setDealersCollectionEmpty(IOSDriver driver) {
		//进入我的-车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver,"经销商");
		//清空已收藏经销商
		if (Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
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
	public static void setModelsBrowseEmpty(IOSDriver driver) {
		//进入浏览记录
		Common.touchText(driver,"我的");
		Common.touchText(driver, "浏览记录");
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		//清空浏览记录
		if (!text.equals("您现在还没有浏览任何车型,")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“浏览记录-经销商”中已浏览经销商
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setDealersBrowseEmpty(IOSDriver driver) {
		//进入浏览记录
		Common.touchText(driver,"我的");
		Common.touchText(driver, "浏览记录");
		Common.touchText(driver, "经销商");
		//清空浏览记录
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		if (!text.equals("您现在还没有浏览任何经销商,")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
	  }
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 清空“浏览记录-降价”中已降价车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setCutsBrowseEmpty(IOSDriver driver) {
		//进入浏览记录
		Common.touchText(driver,"我的");
		Common.touchText(driver, "浏览记录");
		Common.touchText(driver, "降价");
		//清空浏览记录
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		if (!text.equals("您现在还没有浏览任何降价,")){
			Common.touchTopRight(driver);//点击编辑
			Common.touchText(driver, "清空");//点击清空
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");//确定清空
		}
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * @function 检查进入他人主页页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-8-9
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkIsOtherHomepage(IOSDriver driver){
		if(Common.checkTextExist(driver, "btn guanzhu nor")||Common.checkTextExist(driver, "btn yiguanzhu")||Common.checkTextExist(driver, "btn xhgz")){
			return true;
		}else{
			return false;
		}	
	}

}

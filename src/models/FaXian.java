package models;

import common.Common;
import constant.Text;
import io.appium.java_client.ios.IOSDriver;

public class FaXian {
	
	@SuppressWarnings("rawtypes")
	public IOSDriver driver;

	@SuppressWarnings("rawtypes")
	public FaXian(IOSDriver driver){
		this.driver=driver;
	}
	
	/** 
	 * @function 清空“发现-车型对比”中已添加的所有车型
	 * @param driver
	 * @author xulishuang
	 * @time 2017-5-27
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setContrastCarsEmpty(IOSDriver driver) throws InterruptedException{
		//进入发现-车型对比
		Common.touchText(driver,"发现");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//清空已添加车款
	    if (Common.checkTextExist(driver,"编辑")){
	    	Common.touchText(driver, "编辑");
	    	Common.touchText(driver, "清空");
	    	Common.touchText(driver,"确认");
	      }
	    //返回首页
	    Common.back(driver);
	}
	
	/** 
	 * @function “发现-车型对比”中添加两种车款
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
        
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	    Common.touchText(driver, "奥迪");
	    Common.touchText(driver, "奥迪A6L");
	    Common.touchText(driver, "TFSI 技术型");
	}
	
	
	/** 
	 * @function “发现-车型对比”中添加两种车型
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
	 * @function 进入“发现-购车计算器”中贷款页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void enterLoanPage(IOSDriver driver) throws InterruptedException{
		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		//点击贷款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASegmentedControl[1]");
	}
	
	/** 
	 * @function “发现-购车计算器”计算页面选择车款
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-1
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void chooseCar(IOSDriver driver) throws InterruptedException{
		//选择车款
 		Common.touchText(driver,"选择车款");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
	}
	
	/** 
	 * @function 进入降价排行页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-13
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterJiangJiaPaiHangPage(IOSDriver driver){
		Common.touchText(driver, "新车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[7]");
	}
	
	/** 
	 * @function 进入智能选车页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-19
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterZhiNengXuanChePage(IOSDriver driver){
		//点击发现
		Common.touchText(driver, "发现");
		//点击智能选车
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[8]");
	}
	
	/** 
	 * @function 进入摇号查询页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-7-19
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterYaoHaoChaXunPage(IOSDriver driver){
		//点击发现
		Common.touchText(driver, "发现");
		//点击智能选车
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[4]");
	}
	
	/** 
	 * @function 进入朋友帮选车页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void enterPengYouBangXuanChePage(IOSDriver driver){
		Common.touchText(driver, "发现");
	  //屏幕中部左滑
	  int width = driver.manage().window().getSize().width;  
	  int height = driver.manage().window().getSize().height;
	  driver.swipe(width * 9/10, height/2, width/10, height/2, 500);
	  //点击朋友帮选车
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[10]");
	}
	
	/** 
	 * @function 清空朋友帮选车首页已创建的帮选车
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void setBangXuanCheEmpty(IOSDriver driver){
		while(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")){
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  if(Common.checkTextExist(driver,"关闭投票")){
			  Common.touchText(driver,"关闭投票");
			  Common.touchText(driver, "确定");
		  }
		  Common.touchText(driver,"删除投票");
		  Common.touchText(driver, "确定");
	  }
	}
	
	/** 
	 * @function 朋友帮选车-进行车型投票
	 * @initial 朋友帮选车首页
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void voteModels(IOSDriver driver){
		Common.touchText(driver, "发起投票");
		Common.touchText(driver, "车型投票");
		//选择两款车型
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		Common.touchText(driver, "奥迪");
		Common.touchText(driver, "奥迪A4L");
		
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
		Common.touchText(driver, "奥迪");
		Common.touchText(driver, "奥迪A6L");
		//选择两个在意方面
		Common.touchText(driver,Text.ITEM1);
		Common.touchText(driver,Text.ITEM2);
	}
	
	/** 
	 * @function 朋友帮选车-进行车款投票
	 * @initial 朋友帮选车首页
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void voteCars(IOSDriver driver){
		Common.touchText(driver, "发起投票");
		Common.touchText(driver, "车款投票");
		//选择两款车型
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		Common.touchText(driver, "奥迪");
		Common.touchText(driver, "奥迪A4L");
		Common.touchText(driver, "40 TFSI 进取型 Plus");
		
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
		Common.touchText(driver, "奥迪");
		Common.touchText(driver, "奥迪A6L");
		Common.touchText(driver, "TFSI 技术型");
		//选择两个在意方面
		Common.touchText(driver,Text.ITEM1);
		Common.touchText(driver,Text.ITEM2);
	}
	
	/** 
	 * @function 朋友帮选车-发送投票到帮买车社区（未提交）
	 * @initial 投票编辑页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void sendVoteToBangMaiChe(IOSDriver driver){
		Common.touchText(driver, "发给朋友帮我选车");
		Common.touchText(driver, "分享到帮买车社区");
//		Common.touchText(driver, "提交");
	}
	
	/** 
	 * @function 朋友帮选车-发送投票到朋友圈
	 * @initial 投票编辑页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void sendVoteToFriendCircle(IOSDriver driver){
		Common.touchText(driver, "发给朋友帮我选车");
		Common.touchText(driver, "发到朋友圈");
	}
	
	/** 
	 * @function 朋友帮选车-发送投票给微信好友
	 * @initial 投票编辑页面
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void sendVoteToWeChat(IOSDriver driver){
		Common.touchText(driver, "发给朋友帮我选车");
		Common.touchText(driver, "发给微信好友");
	}
	
	/** 
	 * @function 朋友帮选车-右滑显示车型对比
	 * @initial 朋友帮选车入口
	 * @param driver
	 * @author xulishuang
	 * @time 2017-6-7
	 * 
	 */ 
	@SuppressWarnings("rawtypes")
	public static void swipeToRight(IOSDriver driver){
		//屏幕中部右滑
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;
		driver.swipe(width/10, height/2, width * 9/10, height/2, 500);
	}

}

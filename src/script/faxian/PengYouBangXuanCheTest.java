package script.faxian;

import org.testng.Assert;
import org.testng.annotations.*;

import common.Common;
import models.FaXian;
import models.WoDe;
import script.AppTestSuite;

public class PengYouBangXuanCheTest extends AppTestSuite {
	
	/** 
	 * 车型投票-分享到帮买车社区-未提交
	 *  
	 */
	@Test(priority = 1)
	public void faxian_pengyoubangxuanche_testcase1() throws Exception {
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
	 	//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车型投票到帮车社区（未提交）
		FaXian.voteModels(driver);
		FaXian.sendVoteToBangMaiChe(driver);
		//检查进入发布投票界面
		Assert.assertTrue(Common.checkTextExist(driver,"发布投票"), "检查进入发布投票界面");
		//点击返回
		Common.close(driver);
		//检查返回朋友帮选车页面，生成投票
		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"), "检查生成投票");
		Assert.assertTrue(Common.checkTextExist(driver,"发起投票"), "检查返回朋友帮选车页面");
		//点击返回发现首页
		Common.back(driver);
		FaXian.swipeToLeft(driver);
	}
	
	/** 
	 * 车型投票-分享到帮买车社区-投票重新提交
	 * 继承testcase1 
	 */
	@Test(priority = 2)
	public void faxian_pengyoubangxuanche_testcase2() throws Exception {
		//清空话题
		WoDe.setTopicEmpty(driver);
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
		//点击testcase1生成的投票
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击分享到社区
		Common.touchText(driver,"分享到社区");
		//点击提交
		Common.touchText(driver,"提交");
		//检查提交成功，可以在话题中查看
		Common.multiBack(driver,2);
		WoDe.enterTopicPage(driver);
		Assert.assertTrue(Common.checkTextNotExist(driver,"您还没有发表过话题"), "检查话题提交成功");
		//收尾：删除话题，返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "topic btn action 4 nor");
		Common.touchText(driver,"确定");
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * 车型投票-分享到帮买车社区-提交
	 *  
	 */
	@Test(priority = 3)
	public void faxian_pengyoubangxuanche_testcase3() throws Exception{
		//清空话题
		WoDe.setTopicEmpty(driver);
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
		//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车型投票到帮车社区（未提交）
		FaXian.voteModels(driver);
	    FaXian.sendVoteToBangMaiChe(driver);
	    //点击提交
	    Common.touchText(driver,"提交");	
	    //检查提交成功，可以在话题中查看
	    Common.back(driver);
	    WoDe.enterTopicPage(driver);
	    Assert.assertTrue(Common.checkTextNotExist(driver,"您还没有发表过话题"), "检查话题提交成功");
		//收尾：删除话题，返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "topic btn action 4 nor");
		Common.touchText(driver,"确定");
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * 车型投票-分享到微信-未提交
	 *  
	 */
	@Test(priority = 4)
	public void faxian_pengyoubangxuanche_testcase4() throws Exception {
		//进入朋友帮选车
		FaXian.enterPengYouBangXuanChePage(driver);
		//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车型投票到微信（未提交）
		FaXian.voteModels(driver);
		FaXian.sendVoteToFriendCircle(driver);
		//检查进入微信登录界面
		Assert.assertTrue(Common.checkTextExist(driver,"登录遇到问题?"), "检查进入微信登录界面");
		//点击返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[3]/UIAStatusBar[1]/UIAButton[1]");
		//检查返回朋友帮选车页面，生成投票
		Thread.sleep(2000);
		Assert.assertTrue(Common.checkXpathExist(driver," //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"), "检查生成投票");
		Assert.assertTrue(Common.checkTextExist(driver,"发起投票"), "检查返回朋友帮选车页面");
		//点击返回发现首页
		Common.back(driver);
		FaXian.swipeToLeft(driver);
	}
	
	/** 
	 * 车款投票-分享到帮买车社区-未提交
	 *  
	 */
	@Test(priority = 5)
	public void faxian_pengyoubangxuanche_testcase5() throws Exception {
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
	 	//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车款投票到帮车社区（未提交）
		FaXian.voteCars(driver);
		FaXian.sendVoteToBangMaiChe(driver);
		//检查进入发布投票界面
		Assert.assertTrue(Common.checkTextExist(driver,"发布投票"), "检查进入发布投票界面");
		//点击返回
		Common.close(driver);
		//检查返回朋友帮选车页面，生成投票
		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"), "检查生成投票");
		Assert.assertTrue(Common.checkTextExist(driver,"发起投票"), "检查返回朋友帮选车页面");
		//点击返回发现首页
		Common.back(driver);
		FaXian.swipeToLeft(driver);
	}
		
	/** 
	 * 车款投票-分享到帮买车社区-投票重新提交
	 * 继承testcase5
	 */
	@Test(priority = 6)
	public void faxian_pengyoubangxuanche_testcase6() throws Exception{
		//清空话题
		WoDe.setTopicEmpty(driver);
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
		//点击testcase1生成的投票
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击分享到社区
		Common.touchText(driver,"分享到社区");
		//点击提交
		Common.touchText(driver,"提交");
		//检查提交成功，可以在话题中查看
		Common.multiBack(driver,2);
		WoDe.enterTopicPage(driver);
		Assert.assertTrue(Common.checkTextNotExist(driver,"您还没有发表过话题"), "检查话题提交成功");
		//收尾：删除话题，返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "topic btn action 4 nor");
		Common.touchText(driver,"确定");
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * 车款投票-分享到帮买车社区-提交
	 *  
	 */
	@Test(priority = 7)
	public void faxian_pengyoubangxuanche_testcase7() throws Exception {
		//清空话题
		WoDe.setTopicEmpty(driver);
		//进入朋友帮选车页面
		FaXian.enterPengYouBangXuanChePage(driver);
		//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车款投票到帮车社区（未提交）
		FaXian.voteCars(driver);
	    FaXian.sendVoteToBangMaiChe(driver);
	    //点击提交
	    Common.touchText(driver,"提交");	
	    //检查提交成功，可以在话题中查看
	    Common.back(driver);
	    WoDe.enterTopicPage(driver);
	    Assert.assertTrue(Common.checkTextNotExist(driver,"您还没有发表过话题"), "检查话题提交成功");
		//收尾：删除话题，返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "topic btn action 4 nor");
		Common.touchText(driver,"确定");
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * 车款投票-分享到微信-未提交
	 *  
	 */
	@Test(priority = 8)
	public void faxian_pengyoubangxuanche_testcase8() throws Exception {
		//进入朋友帮选车
		FaXian.enterPengYouBangXuanChePage(driver);
		//清空朋友帮选车首页已创建的帮选车
		FaXian.setBangXuanCheEmpty(driver);
		//发布车款投票到微信（未提交）
		FaXian.voteCars(driver);
		FaXian.sendVoteToFriendCircle(driver);
		//检查进入微信登录界面
		Assert.assertTrue(Common.checkTextExist(driver,"登录遇到问题?"), "检查进入微信登录界面");
		//点击返回
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[3]/UIAStatusBar[1]/UIAButton[1]");
		//检查返回朋友帮选车页面，生成投票
		Thread.sleep(2000);
		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"), "检查生成投票");
		Assert.assertTrue(Common.checkTextExist(driver,"发起投票"), "检查返回朋友帮选车页面");
		//点击返回发现首页
		Common.back(driver);
		FaXian.swipeToLeft(driver);
	}
	
	/** 
	 * 关闭-删除投票
	 * 继承testcase8
	 *  
	 */
	@Test(priority = 9)
	public void faxian_pengyoubangxuanche_testcase9() throws Exception{
		//进入朋友帮选车
		FaXian.enterPengYouBangXuanChePage(driver);
		//删除testcase8生成的投票
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  if(Common.checkTextExist(driver,"关闭投票")){
			  Common.touchText(driver,"关闭投票");
			  Common.touchText(driver, "确定");
		  }
		  Common.touchText(driver,"删除投票");
		  Common.touchText(driver, "确定");
		  //检查删除投票成功
		  Assert.assertTrue(Common.checkXpathNotExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"),"检查删除投票成功");
		  //返回首页
		  Common.back(driver);
		  FaXian.swipeToLeft(driver);
  }
	

}

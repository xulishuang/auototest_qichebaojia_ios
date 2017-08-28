package script.bangmaiche;

import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;

public class HomePageTest extends AppTestSuite{
	
	  /** 
		 * 标签-标签页切换
		 * 预设：无订阅内容
		 */	
	
	  @Test(priority = 1)
	  public void bangmaiche_homepage_testcase1()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击推荐
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //检查进入推荐页面
		  Assert.assertTrue(Common.checkIsSelected(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"), "检查进入推荐页面");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //检查进入最新页面
		  Assert.assertTrue(Common.checkIsSelected(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]"), "检查进入最新页面");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //检查进入订阅页面
		  Assert.assertTrue(Common.checkIsSelected(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]"), "检查进入订阅页面");
	  }
	  
	  /** 
		 * 页面显示-无订阅
		 * @precondition 运行前手工清除已订阅内容
		 * 
		 */	
	  @Test(priority = 2)
	  public void bangmaiche_homepage_testcase2()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //清空已订阅内容
		  	//无法区别订阅与已订阅按钮，故自动化无法实现清空操作
		  //检查订阅内容为空
		  Assert.assertTrue(Common.checkTextExist(driver,"开始订阅"), "检查订阅内容为空");
		  //点击开始订阅
		  Common.touchText(driver, "开始订阅");
		  //检查进入订阅专题界面
		  Assert.assertTrue(Common.checkTextExist(driver,"订阅专题"),"检查进入订阅专题界面");
		  //返回到帮买车界面
		  Common.back(driver);
	  }
	    
	  /** 
		 * 页面显示-有订阅
		 * 
		 */	
	  @Test(priority = 3)
	  public void bangmaiche_homepage_testcase3()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //点击订阅icon进入订阅专题进行订阅
		  Common.touchText(driver, "subscribeBtnNor");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		  //返回
		  Common.touchText(driver,"nav right close");
		  //检查显示订阅内容
		  Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]"), "检查显示订阅内容");
		  //点击话题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页
		  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"),"检查进入话题详情页");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 订阅专题-取消订阅
		 * Precondition 接续testcase3
		 * 
		 */	
	  @Test(priority = 4)
	  public void bangmaiche_homepage_testcase4()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //点击订阅icon进入订阅专题进行订阅
		  Common.touchText(driver, "subscribeBtnNor");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		  //确认取消
		  Common.touchText(driver, "取消订阅");
		  //返回
		  Common.touchText(driver,"nav right close");
		  //检查取消订阅成功
		  Assert.assertFalse(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]"), "检查显示订阅内容");
	  }
	  
	  /** 
		 * 订阅专题-订阅
		 * 
		 */	
	  @Test(priority = 5)
	  public void bangmaiche_homepage_testcase5()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //点击订阅icon进入订阅专题进行订阅
		  Common.touchText(driver, "subscribeBtnNor");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		  //返回
		  Common.touchText(driver,"nav right close");
		  //检查显示订阅内容
		  Assert.assertFalse(Common.checkTextExist(driver, "开始订阅"), "检查显示订阅内容");
		  //恢复环境，取消订阅
		  Common.touchText(driver, "subscribeBtnNor");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		  Common.touchText(driver, "取消订阅");
		  Common.touchText(driver,"nav right close");
	  }
	  
	  /** 
		 * 订阅专题详情页-页面显示
		 * 
		 */	
	  @Test(priority = 6)
	  public void bangmaiche_homepage_testcase6()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击订阅
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]");
		  //点击订阅icon进入订阅专题进行订阅
		  Common.touchText(driver, "subscribeBtnNor");
		  //检查进入订阅专题页面
		  Assert.assertTrue(Common.checkTextExist(driver, "订阅专题"),"检查进入订阅专题页面");
		  //点击第一条专题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  //检查进入专题详情页面
		  Assert.assertTrue(Common.checkTextExist(driver,"专题详情"),"检查进入专题详情页面");
		  //点击分享icon
		  Common.touchText(driver,"icon fenxiang nor");
		  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
		  Assert.assertTrue(Common.checkTextExist(driver, "微信好友"), "检查显示有微信好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "朋友圈"), "检查显示有朋友圈");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ空间"), "检查显示有QQ空间");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ好友"), "检查显示有QQ好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "新浪微博"), "检查显示有新浪微博");
		  Assert.assertTrue(Common.checkTextExist(driver, "浏览器"), "检查显示有浏览器");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //点击发帖
		  Common.touchText(driver, "发帖");
		  //检查显示显示话题、投票、关闭icon
		  Assert.assertTrue(Common.checkTextExist(driver, "话题"), "检查显示话题icon");
		  Assert.assertTrue(Common.checkTextExist(driver,"投票"), "检查显示投票icon");
		  Assert.assertTrue(Common.checkTextExist(driver, "community sendtopic close"), "检查显示关闭icon");
		  //收起发帖icon
		  Common.touchText(driver, "community sendtopic close");
		  //返回首页
		  Common.back(driver);
		  Common.touchText(driver, "nav right close");
	  }

}

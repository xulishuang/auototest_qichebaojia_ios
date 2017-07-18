package script.xinche;

import org.openqa.selenium.By; 
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;
import models.XinChe;

public class ZiPinPaiJingXiaoShangTest extends AppTestSuite{
	  
	  /** 
		 *页面功能-拨打电话
		 *  
		 */	
	  @Test(priority = 1)
	  public void xinche_zipinpaijingxiaoshang_testcase1() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //检查进入子品牌经销商页面
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]")), "检查进入子品牌经销商页面");
		  //点击400电话
		  Common.touchText(driver,"400电话");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //返回首页
		  Common.back(driver);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 页面功能-贷款
		 * 
		 */	
	  @Test(priority = 2)
	  public void xinche_zipinpaijingxiaoshang_testcase2() throws Exception { 
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //点击贷款
		  Common.touchText(driver,"贷款");
		  //检查进入贷款页面
		  Assert.assertTrue(Common.checkTextExist(driver, "贷款")&&Common.checkTextExist(driver,"提交"),"检查进入贷款页面");
		  //输入姓名+手机号
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"), "小红");
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]"), "13666666666");
		  //返回首页
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		  Common.back(driver);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  
	  /** 
		 * 页面功能-询底价
		 * 
		 */	
	  @Test(priority = 3)
	  public void xinche_zipinpaijingxiaoshang_testcase3() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //点击询底价
		  Common.touchText(driver,"询底价");
		  //检查进入询底价页
		  Assert.assertTrue(Common.checkTextExist(driver, "询底价")&&Common.checkTextExist(driver,"提交"),"检查进入询底价页面");
		  //输入姓名+手机号
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"), "小红");
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]"), "13666666666");
		  
		  //返回首页
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		  Common.back(driver);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 *页面功能-排序
		 *  
		 */	
	  @Test(priority = 4)
	  public void xinche_zipinpaijingxiaoshang_testcase4() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //点击排序
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //选择默认排序
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  //点击排序
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //选择价格最低
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
		  
		  //点击排序
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //选择询价最多
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
		  //点击排序
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //选择距离最近
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
		  //点击排序
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //选择关闭
		  Common.touchText(driver, "取消");
		  //检查返回子品牌经商商页面
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]")), "检查返回子品牌经销商页面");
		  //返回首页
		  Common.back(driver);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 经销商详情页-拨打400电话
		 * 
		 */	
	  @Test(priority = 5)
	  public void xinche_zipinpaijingxiaoshang_testcase5() throws Exception { 
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  String text1=Common.getText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"));
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //检查进入经销商详情页面
		  String text2=Common.getText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]"));
		  Assert.assertTrue(text1.contains(text2),"检查进入经销商详情页面");
		  //点击400电话
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //返回首页
		  Common.multiBack(driver,2);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 经销商详情页-经销商官网
		 * 
		 */	
	  @Test(priority = 6)
	  public void xinche_zipinpaijingxiaoshang_testcase6() throws Exception { 
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击经销商官网
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[3]");
		  //检查进入经销商会员页（H5页）
		  Common.waitForVisible(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]"), 15);
		  Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]"),"检查进入经销商会员页（H5页）");
		  //返回首页
		  Common.multiBack(driver, 3);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  
	  /** 
		 * 经销商详情页-地址
		 * 
		 */	
	  @Test(priority = 7)
	  public void xinche_zipinpaijingxiaoshang_testcase7() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击地址
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[4]");
		  //点击免费咨询
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableCell[1]/UIAButton[1]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchText(driver, "取消");
		  //检查“去这里”按钮可点击：避免操作
//		  String text=Common.getAttribute(driver, By.name("去这里"), "type");
//		  Assert.assertEquals(text, "UIAButton","检查去这里按钮可点击：避免操作");
		  Assert.assertTrue(Common.checkTextExist(driver,"去这里"),"检查有去这里按钮");
		  //返回首页
		  Common.multiBack(driver, 3);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 *经销商详情页-地图
		 *  
		 */	
	  @Test(priority = 8)
	  public void xinche_zipinpaijingxiaoshang_testcase8() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击地图(位于页面中部)
		  Common.pressLocation(driver, Common.getScreenWidth(driver)/2, Common.getScreenHeight(driver)/2);
		  //点击免费咨询
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableCell[1]/UIAButton[1]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchText(driver, "取消");
		  //检查“去这里”按钮可点击：避免操作
//		  String text=Common.getAttribute(driver, By.name("去这里"), "type");
//		  Assert.assertEquals(text, "UIAButton","检查去这里按钮可点击：避免操作");
		  Assert.assertTrue(Common.checkTextExist(driver,"去这里"),"检查有去这里按钮");
		  //返回首页
		  Common.multiBack(driver, 3);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 经销商详情页-促销信息
		 * 
		 */	
	  @Test(priority = 9)
	  public void xinche_zipinpaijingxiaoshang_testcase9() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击促销信息
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
		  //检查进入促销信息详情页面
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]"));
		  Assert.assertEquals(text, "促销信息","检查进入促销信息详情页面");
		  //点击分享icon
		  Common.touchText(driver, "icon fenxiang nor");
		  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
		  Assert.assertTrue(Common.checkTextExist(driver, "朋友圈"), "检查可分享到朋友圈");
		  Assert.assertTrue(Common.checkTextExist(driver, "微信好友"), "检查可分享到微信好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ空间"), "检查可分享到QQ空间");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ好友"), "检查可分享到QQ好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "新浪微博"), "检查可分享到新浪微博");
		  Assert.assertTrue(Common.checkTextExist(driver, "浏览器"), "检查可分享到浏览器");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //点击询价
		  Common.touchText(driver, "xunjia nor"); 
		  //检查进入询底价页面
		  Assert.assertTrue(Common.checkTextExist(driver, "询底价")&&Common.checkTextExist(driver,"提交"),"检查进入询底价页面");
		  //返回首页
		  Common.touchText(driver, "nav right close");
		  Common.multiBack(driver, 3);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 *经销商详情页-购车咨询400电话
		 *  
		 */	
	  @Test(priority = 10)
	  public void xinche_zipinpaijingxiaoshang_testcase10() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击购车咨询400电话
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //返回首页
		  Common.multiBack(driver, 2);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 经销商详情页-销售顾问
		 * 
		 */	
	  @Test(priority = 11)
	  public void xinche_zipinpaijingxiaoshang_testcase11() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击微聊icon
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
		  //检查进入微聊页面
		  Assert.assertTrue(Common.checkTextExist(driver,"chat_input_textView"), "检查进入微聊页面");
		  //点击返回箭头
		  Common.back(driver);
		  //点击电话icon
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //点击销售顾问头像
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  //点击微聊icon
		  Common.touchText(driver, "btn wl nor");
		  //检查进入微聊页面
		  Assert.assertTrue(Common.checkTextExist(driver,"chat_input_textView"), "检查进入微聊页面");
		  //点击返回箭头
		  Common.back(driver);
		  //点击销售顾问头像
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  //点击电话icon
		  Common.touchText(driver, "btn dh nor");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //返回首页
		  Common.multiBack(driver, 2);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
	  /** 
		 * 经销商详情页-IM页
		 * 
		 */	
	  @Test(priority = 12)
	  public void xinche_zipinpaijingxiaoshang_testcase12() throws Exception {
		  //进入子品牌经销商页面
		  XinChe.enterZiPinPaiJingXiaoShangPage(driver);
		  //进入子品牌经销商详情页面
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //进入经销商详情页，点击微聊icon
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
		  //点击页底输入框,输入内容与表情
//		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATextView[1]");
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"),"hello");		  
		  //点击页底+号
		  Common.touchText(driver,"chat setmode add btn normal");
		  //点击照片
		  Common.touchText(driver, "actionbar picture icon");
		  //点击取消
		  Common.touchText(driver, "取消");
		  //返回首页
		  Common.multiBack(driver, 3);
		  Common.swipeToRight(driver, 500, 1);
	  }
	  
}

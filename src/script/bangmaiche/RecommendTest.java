package script.bangmaiche;

import org.openqa.selenium.By; 
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;

public class RecommendTest extends AppTestSuite {
	
	  /** 
		 * 热门榜-24小时热帖榜
		 * 
		 */	
	  @Test(priority = 1)
	  public void bangmaiche_recommend_testcase1() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击热门榜
		  Common.touchText(driver,"热门榜");
		  //检查默认进入24小时热帖榜
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("24小时热帖榜")), "检查默认进入24小时热帖榜");
//		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")), "检查默认进入24小时热帖榜");
		  //点击某一条数据
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.multiBack(driver, 2);
	  }
	  
	  /** 
		 * 热门榜-大神榜
		 * 
		 */	
	  @Test(priority = 2)
	  public void bangmaiche_recommend_testcase2() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击热门榜
		  Common.touchText(driver,"热门榜");
		  //点击大神榜
		  Common.touchText(driver,"大神榜");
		  //检查进入大神榜
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("大神榜")), "检查进入大神榜");
//		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]")), "检查进入大神榜");
		  //点击某一条数据
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //检查进入用户账户页面
		  Assert.assertTrue(Common.checkTextExist(driver,"btn guanzhu nor")||Common.checkTextExist(driver, "btn yiguanzhu"), "检查进入用户账户页面");
		  //点击返回
		  Common.back(driver);
		  //点击关注
		  String text=Common.getText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]"));
		  if(text.equals("myAttention guanzhu nor")){
			  //点击关注
			  Common.touchText(driver, "myAttention guanzhu nor");
			  //取消关注
			  Common.touchText(driver, "myAttention ygz nor");
		  }else{
			  //取消关注
			  Common.touchText(driver, "myAttention ygz nor");
			  //点击关注
			  Common.touchText(driver, "myAttention guanzhu nor");
			  //取消关注
			  Common.touchText(driver, "myAttention ygz nor");
		  }
		  //返回首页
		  Common.back(driver);
	  }
	    
	  /** 
		 * 今日话题-操作
		 * 
		 */	
	  @Test(priority = 3)
	  public void bangmaiche_recommend_testcase3() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击今日话题
		  Common.touchText(driver,"今日话题");
		  //检查进入今日话题界面
		  Assert.assertTrue(Common.checkTextExist(driver,"今日话题")&&Common.checkTextExist(driver, "specialTopicSubscribe"),"检查进入今日话题界面");
		  //点击某一条话题
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情界面
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //点击返回
		  Common.back(driver);
		  //点击订阅
		  Common.touchText(driver, "specialTopicSubscribe");
		  //取消订阅
		  Common.touchText(driver, "specialTopicSubscribed");
		  //检查弹出取消订阅提示
		  Assert.assertTrue(Common.checkTextExist(driver, "是否取消对该专题的订阅"), "检查弹出取消订阅提示");
		  //点击取消订阅
		  Common.touchText(driver,"取消订阅");
		  //点击转发
		  Common.touchText(driver,"icon fenxiang nor");
		  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
		  Assert.assertTrue(Common.checkTextExist(driver, "朋友圈"), "朋友圈");
		  Assert.assertTrue(Common.checkTextExist(driver, "微信好友"), "微信好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ空间"), "QQ空间");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ好友"), "QQ好友");
		  Assert.assertTrue(Common.checkTextExist(driver, "新浪微博"), "新浪微博");
		  Assert.assertTrue(Common.checkTextExist(driver, "浏览器"), "浏览器");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 视频直播-操作
		 * 
		 */	
	  @Test(priority = 4)
	  public void bangmaiche_recommend_testcase4() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //进入视频直播
		  if(Common.checkTextExist(driver, "视频直播")){
			  //点击视频直播
			  Common.touchText(driver,"视频直播");
			  //检查进入直播界面
			  Assert.assertTrue(Common.checkTextExist(driver,"直播"),"检查进入视频直播界面");
//			  //进入直播详情页面
//			  if(Common.checkTextExist(driver, "重播")){
//				  Common.touchText(driver, "重播");
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Common.touchText(driver,"重播");
//			  }
			  //检查进入视频播放页面，状态为播放
			  
			  //点击转发
			  
			  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
			  
			  //点击取消
			  
			  //返回
			  
		  }
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 视频直播-评论
		 * 
		 */	
	  @Test(priority = 5)
	  public void bangmaiche_recommend_testcase5() throws Exception {
		  
	  }
	  
	  /** 
		 * 帮买车大神征集令-页面显示
		 * 
		 */	
	  @Test(priority = 6)
	  public void bangmaiche_recommend_testcase6() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击帮买车大神征集令
		  Common.touchLocation(driver, Common.getScreenWidth(driver)*3/4, Common.getScreenHeight(driver)/4);
		  //检查进入话题详情页面或广告页面（H5页面）
//		  Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]"),"检查进入话题详情页面或广告页面(H5页面)");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 热门推荐-数据显示
		 * 
		 */	
	  @Test(priority = 7)
	  public void bangmaiche_recommend_testcase7() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击某一条数据
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIATableView[1]/UIATableCell[1]");
		  //检查进入话题详情页面
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.back(driver);  
	  }
	  
	  /** 
		 * 热门推荐-查看全部
		 * 
		 */	
	  @Test(priority = 8)
	  public void bangmaiche_recommend_testcase8() throws Exception {
		  //进入推荐页面
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"推荐");
		  //点击查看全部
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[2]");
		  //检查进入精彩推荐界面
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]"));
		  Assert.assertEquals(text, "热门推荐", "检查进入精彩推荐界面");
		  //点击某一条数据
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页面
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.multiBack(driver,2);   
	  }

}

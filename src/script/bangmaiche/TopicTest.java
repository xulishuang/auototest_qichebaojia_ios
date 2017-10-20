package script.bangmaiche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import script.AppTestSuite;
import common.*;
import constant.Text;
import models.BangMaiChe;
import models.WoDe;

public class TopicTest extends AppTestSuite {
	
  /** 
	 * 普通话题-发表评论
	 * 
	 */	
  @Test(priority = 1)
  public void bangmaiche_topic_testcase1()  {
	  //清空我的社区-话题
	  WoDe.setTopicEmpty(driver);
	  //进入最新页面
	  Common.touchText(driver, "帮买车");
	  Common.touchText(driver,"最新");
	  //发布一条普通话题并点击进入
	  BangMaiChe.releaseGeneralTopic(driver);
	  Common.touchText(driver, Text.ACCOUNT);
	  //点击底部文字输入框
	  Common.touchText(driver,"  说点什么吧....");
	  //输入文字
	  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "看一看");
	  //点击关联车型
	  Common.touchText(driver,"+车型");
	  //选择车型
	  Common.touchText(driver,"奥迪");
	  Common.touchText(driver, "奥迪A3");
	  //检查选择车型成功
	  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3"),"检查选择车型成功");
	  //选择引用话题
	  Common.touchText(driver,"+话题");
	  //关闭引用话题页面
	  Common.touchText(driver,"nav right close");
	  //点击发布
	  Common.touchText(driver, "发布");
	  //下滑刷新数据
	  Common.swipeToDown(driver, 500, 1);
	  //检查发布成功
	  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3")&&Common.checkTextExist(driver,"话题详情"),"检查发布成功");
	  //返回首页
	  Common.back(driver);
  }
  
  /** 
	 * 普通话题-删除评论
	 * @precondition 接续testcase1
	 */	
  @Test(priority = 2)
  public void bangmaiche_topic_testcase2(){
	  //进入帮买车-最新
	  Common.touchText(driver, "帮买车");
	  Common.touchText(driver, "最新");
	  //进入testcase1中已发的普通话题
	  Common.touchSlideText(driver, Text.ACCOUNT, 5);
	  //删除testcase1中已发布的评论
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[3]");
	  Common.touchText(driver,"确定");
	  //检查删除成功
	  
	  //返回首页
	  Common.back(driver);
  }
    
  /** 
	 * 普通话题-话题点赞
	 * @precondition 接续testcase2
	 * 
	 */	
  @Test(priority = 3)
  public void bangmaiche_topic_testcase3()  {
	  //进入testcase1中已发的普通话题
	  Common.touchSlideText(driver, Text.ACCOUNT, 5);
	  //点赞
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAButton[3]");
	  //进入点赞用户列表，检查点赞成功
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[2]");
	  Assert.assertTrue(Common.checkTextExist(driver, Text.ACCOUNT), "检查点赞成功");
	  Common.back(driver);
	  //再次点赞
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAButton[3]");
	  //检查取消点赞
	  if(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[2]")){
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[2]");
		  Assert.assertFalse(Common.checkTextExist(driver, Text.ACCOUNT), "检查点赞成功");
		  Common.back(driver);
	  }
	  //返回首页
	  Common.back(driver);
  }
  
  /** 
	 * 普通评论-给评论回复
	 * @precondition 接续testcase3
	 */	
  @Test(priority = 4)
  public void bangmaiche_topic_testcase4()  {
	  //进入testcase1中已发的普通话题
	  Common.touchSlideText(driver, Text.ACCOUNT, 5);
	  //点击底部文字输入框
	  Common.touchText(driver,"  说点什么吧....");
	  //输入文字
	  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "点赞");
	  //点击关联车型
	  Common.touchText(driver,"+车型");
	  //选择车型
	  Common.touchText(driver,"奥迪");
	  Common.touchText(driver, "奥迪Q5");
	  //点击发布
	  Common.touchText(driver, "发布");
	  //点击评论回复
	  Common.touchText(driver,"topic btn comment nor");
	  //输入文字
	  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "嘿嘿");
	  //点击关联车型
	  Common.touchText(driver,"+车型");
	  //选择车型
	  Common.touchText(driver,"奥迪");
	  Common.touchText(driver, "奥迪A3");
	  //检查选择车型成功
	  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3"),"检查选择车型成功");
	  //选择引用话题
	  Common.touchText(driver,"+话题");
	  //关闭引用话题页面
	  Common.touchText(driver,"nav right close");
	  //点击发布
	  Common.touchText(driver, "发布");
	  //检查发布成功
	  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3")&&Common.checkTextExist(driver,"话题详情"),"检查发布成功");
	  
	  //返回首页
	  Common.back(driver);
  }
  
  /** 
	 * 普通话题-给评论点赞
	 * @precondition 接续testcase4
	 */	
  @Test(priority = 5)
  public void bangmaiche_topic_testcase5()  {
	  //进入testcase1中已发的普通话题
	  Common.touchSlideText(driver, Text.ACCOUNT, 5);
	  //给评论点赞
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[4]");
	  //检查点赞数增1
	    //无法检查
	  //再次点赞
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[4]");
	  //检查取消点赞，点赞数减1
	    //无法检查
	  
	  //恢复环境，删除普通话题
	  WoDe.setTopicEmpty(driver);
  }
  
  /** 
	 * 话题详情页-收藏
	 * 
	 */	
  @Test(priority = 12)
  public void bangmaiche_topic_testcase12()  {
	  //进入我的社区-收藏夹，清空所有收藏
	  WoDe.setTopicCollectionEmpty(driver);
	  //进入最新页面
	  Common.touchText(driver, "帮买车");
	  Common.touchText(driver,"最新");
	  //点击进入话题详情页
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查进入话题详情页面");
	  //点击收藏
	  Common.touchText(driver,"unfav nor");
	  //检查收藏成功
	  Common.back(driver);
	  Common.touchText(driver,"我的");
	  Common.touchText(driver, "我的社区");
	  Common.touchText(driver,"收藏夹");
	  Assert.assertTrue(Common.checkTextExist(driver,"topic btn action 6 nor"),"检查收藏成功");
	  //返回首页
	  Common.multiBack(driver, 2);
  }
	  
	  /** 
		 * 话题详情页-分享
		 * 
		 */	
	  @Test(priority = 13)
	  public void bangmaiche_topic_testcase13()  {
		  //进入最新页面
		  Common.touchText(driver, "帮买车");
		  Common.touchText(driver,"最新");
		  //点击进入话题详情页
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查进入话题详情页面");
		  //点击右上角button
		  Common.touchText(driver, "ic gengduo nor");
		  //点击分享
		  Common.touchText(driver,"分享");
		  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
		  Assert.assertTrue(Common.checkTextExist(driver, "朋友圈"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  Assert.assertTrue(Common.checkTextExist(driver, "微信好友"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  Assert.assertTrue(Common.checkTextExist(driver, "新浪微博"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ空间"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  Assert.assertTrue(Common.checkTextExist(driver, "QQ好友"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  Assert.assertTrue(Common.checkTextExist(driver, "浏览器"), "检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //检查返回话题详情页面
		  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查返回话题详情页面");
		  //返回首页
		  Common.back(driver);
	  }
	    
	  /** 
		 * 话题详情页-取消
		 * 
		 */	
	  @Test(priority = 15)
	  public void bangmaiche_topic_testcase15()  {
		//进入最新页面
		  Common.touchText(driver, "帮买车");
		  Common.touchText(driver,"最新");
		  //点击进入话题详情页
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查进入话题详情页面");
		  //点击右上角button
		  Common.touchText(driver, "ic gengduo nor");
		  //点击取消
		  Common.touchText(driver, "取消");
		  //检查返回话题详情页面
		  Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查回到话题详情页面");
		  //返回首页
		  Common.back(driver);
	  }

}

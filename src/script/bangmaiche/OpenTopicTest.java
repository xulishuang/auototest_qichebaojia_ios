package script.bangmaiche;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;
import models.BangMaiChe;
import models.WoDe;

public class OpenTopicTest extends AppTestSuite{
	  /** 
		 * 操作-点击
		 * 
		 */	
	  @Test(priority = 1)
	  public void bangmaiche_opentopic_testcase1()  {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchText(driver, "最新");
		  //点击发帖
		  Common.touchText(driver, "发帖");
		  //检查显示显示话题、投票、删除icon
		  Assert.assertTrue(Common.checkTextExist(driver, "话题"), "检查显示话题icon");
		  Assert.assertTrue(Common.checkTextExist(driver,"投票"), "检查显示投票icon");
		  Assert.assertTrue(Common.checkTextExist(driver,"文章"), "检查显示文章icon");
		  Assert.assertTrue(Common.checkTextExist(driver, "community sendtopic close"), "检查显示删除icon");
		  //点击话题icon
		  Common.touchText(driver,"话题");
		  //检查进入发表话题页面
		  Assert.assertTrue(Common.checkTextExist(driver, "发表话题"),"检查进入发表话题页面");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //点击投票icon
		  Common.touchText(driver, "发帖");
		  Common.touchText(driver, "投票");
		  //检查进入发布投票页面
		  Assert.assertTrue(Common.checkTextExist(driver, "发布投票"),"检查进入发布投票页面");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //点击文章icon
		  Common.touchText(driver, "发帖");
		  Common.touchText(driver, "文章");
		  //检查进入发布文章页面
		  Assert.assertTrue(Common.checkTextExist(driver, "发布文章"),"检查进入发布文章页面");
		  //点击取消
		  Common.touchText(driver,"取消");
		  //点击关闭icon
		  Common.touchText(driver, "发帖");
		  Common.touchText(driver, "community sendtopic close");
		  //检查收起三个icon，只显示发帖icon
		  Assert.assertTrue(Common.checkTextExist(driver, "发帖"),"检查发帖收起");
	  }
	  
	  /** 
		 * 话题-发表话题
		 * 
		 */	
	  @Test(priority = 2)
	  public void bangmaiche_opentopic_testcase2()  {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车-普通话题发帖页面
		  BangMaiChe.enterGeneralTopicPage(driver);
		  //输入内容
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "新的一天签到啦");
		  //点击通过拍照添加图片
		  Common.touchText(driver, "ic add nor");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");//点击左上角第一个拍照按钮
		  Common.touchText(driver,"FrontBackFacingCameraChooser");//点击前置摄像头
		  Common.touchText(driver,"PhotoCapture");//点击拍照
		  Common.touchText(driver,"使用照片");//点击使用照片
		  //点击提醒谁看@
		  Common.touchText(driver, "ic fb ht nor");
		  //检查进入我的关注页面
		  Assert.assertTrue(Common.checkTextExist(driver,"我的关注"),"检查进入我的关注页面");
		  //点击完成
		  Common.touchText(driver, "完成");
		  //选择关联车型
		  Common.touchText(driver, "ic tianjiachexing");
		  Common.touchText(driver, "奥迪");
		  Common.touchText(driver, "奥迪Q5");//点击奥迪Q5
		  //检查关联车型成功
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪Q5")&&Common.checkTextExist(driver, "发表话题"),"检查关联车型成功");
		  //点击引用话题
		  Common.touchText(driver, "ic tianjiahuati");
		  //检查进入引用话题页面
		  Assert.assertTrue(Common.checkTextExist(driver, "我的话题"),"检查进入引用话题页面");
		  //返回
		  Common.touchText(driver, "nav right close");
		  //点击发布
		  Common.touchText(driver, "发布");
		  //检查话题发布成功，可以在我的社区-话题 中查看
		  WoDe.enterTopicPage(driver);
		  Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过话题"),"检查话题发布成功");
		  
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	    
	  /** 
		 * 投票-车款投票
		 * 
		 */	
	  @Test(priority = 3)
	  public void bangmaiche_opentopic_testcase3()  {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车-投票发帖页面
		  BangMaiChe.enterVoteTopicPage(driver);
		  //点击投票类型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		  //点击发车款投票
		  Common.touchText(driver, "车款投票");
		  //选择两款车
		  BangMaiChe.addCars(driver);
		  //选择在意方面：
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")), "检查在意的方面选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]")), "检查在意的方面选择成功");
		  //点击发布
		  Common.touchText(driver,"发布");
		  //检查投票发布成功，可以在我的社区-话题中查看
		  WoDe.enterTopicPage(driver);
		  Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过话题"),"检查话题发布成功");
		  
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	  
	  /** 
		 * 投票-车型投票
		 * 
		 */	
	  @Test(priority = 4)
	  public void bangmaiche_opentopic_testcase4()  {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车-投票话题页面
		  BangMaiChe.enterVoteTopicPage(driver);//默认进入车型投票页面
		  //添加两种车型
		  BangMaiChe.addModels(driver);
		  //选择在意方面：
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")), "检查在意的方面选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]")), "检查在意的方面选择成功");
		  //点击发布
		  Common.touchText(driver,"发布");
		  //检查投票发布成功，可以在我的社区-话题中查看
		  WoDe.enterTopicPage(driver);
		  Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过话题"),"检查话题发布成功");
		  
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	  
	  /** 
		 * 投票-观点投票
		 * 
		 */	
	  @Test(priority = 5)
	  public void bangmaiche_opentopic_testcase5()  {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车-投票发帖页面
		  BangMaiChe.enterVoteTopicPage(driver);
		  //点击投票类型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		  //点击观点投票
		  Common.touchText(driver, "观点投票");
		  //输入两个选项内容
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]"), "北京资源好适宜居住");
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextView[1]"), "北京压力大不宜居住");
		  //输入投票说明(必填)
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIATextView[1]"), "我爱北京！！！");
		  
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIATextView[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAKey[27]");//删除一个字符，是发布按钮可用
		  
		  //上滑屏幕，收起键盘
		  Common.swipeToUp(driver, 500, 1);
		  //点击发布
		  Common.touchText(driver,"发布");
		  ///检查投票发布成功，可以在我的社区-话题中查看
		  WoDe.enterTopicPage(driver);
		  Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过话题"),"检查话题发布成功");
		  
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	  
	  /** 
		 * 文章-发布文章
		 * 
		 */	
	  @Test(priority = 6)
	  public void bangmaiche_opentopic_testcase6()  {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车-文章发帖页面
		  BangMaiChe.enterArticleTopicPage(driver);
		  //添加封面
		  Common.touchText(driver, "ic fbwz tjfm nor");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAImage[1]"); //选择一张照片
		  Common.touchText(driver, "确定");//点击确定
		  //输入标题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]");
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "老舍 住的梦");
		  //输入内容
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[2]"), "天堂是什么样子，我不晓得，但是从我的生活经验去判断，北平之秋便是天堂。论天气，不冷不热。论吃食，苹果，梨，柿，枣，葡萄，都每样有若干种。至于北平特产的小白梨与大白海棠，恐怕就是乐园中的禁果吧，连亚当与夏娃见了，也必滴下口水来！果子而外，羊肉正肥，高粱红的螃蟹刚好下市，而良乡的栗子也香闻十里。论花草，菊花种类之多，花式之奇，可以甲天下。西山有红叶可见，北海可以划船——虽然荷花已残，荷叶可还有一片清香。衣食住行，在北平的秋天，是没有一项不使人满意的。即使没有余钱买菊吃蟹，一两毛钱还可以爆二两羊肉，弄一小壶佛手露啊！");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[2]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAKey[27]");//删除一个字符，是发布按钮可用
		  //点击发布
		  Common.touchText(driver,"发布");
		  ///检查投票发布成功，可以在我的社区-话题中查看
		  WoDe.enterTopicPage(driver);
		  Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过话题"),"检查话题发布成功");
		  
		  //返回首页
		  Common.multiBack(driver,2);
	  }

}

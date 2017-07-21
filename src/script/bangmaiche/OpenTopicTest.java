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
	  public void bangmaiche_opentopic_testcase1() throws Exception {
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //点击发帖
		  Common.touchText(driver, "发帖");
		  //检查显示显示话题、投票、删除icon
		  Assert.assertTrue(Common.checkTextExist(driver, "话题"), "检查显示话题icon");
		  Assert.assertTrue(Common.checkTextExist(driver,"投票"), "检查显示投票icon");
		  Assert.assertTrue(Common.checkTextExist(driver, "community sendtopic close"), "检查显示删除icon");
		  //点击话题icon
		  Common.touchText(driver,"话题");
		  //检查进入发表话题页面
		  Assert.assertTrue(Common.checkTextExist(driver, "发表话题"),"检查进入发表话题页面");
		  //返回
		  Common.touchText(driver,"nav right close");
		  //点击投票icon
		  Common.touchText(driver, "发帖");
		  Common.touchText(driver, "投票");
		  //检查进入发布投票页面
		  Assert.assertTrue(Common.checkTextExist(driver, "发布投票"),"检查进入发布投票页面");
		  //返回
		  Common.touchText(driver,"nav right close");
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
	  public void bangmaiche_opentopic_testcase2() throws Exception {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //点击发帖
		  Common.touchText(driver,"发帖");
		  //点击话题icon
		  Common.touchText(driver, "话题");
		  //输入内容
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "奥迪Q5空间大吗");
		  //点击拍照
		  Common.touchText(driver, "ic add nor");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");//点击拍照
		  Common.touchText(driver,"FrontBackFacingCameraChooser");//点击前置摄像头
		  Common.touchText(driver,"PhotoCapture");//点击拍照
		  Common.touchText(driver,"使用照片");//点击使用照片
		  //点击从相册选择照片
		  Common.touchText(driver, "ic add nor");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");//点击从相册选择
		  Common.pressLocation(driver,100,120);//通过坐标选择照片
		  Common.touchText(driver, "完成");//点击完成
		  //点击提醒谁看
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  //检查进入我的关注页面
		  Assert.assertTrue(Common.checkTextExist(driver,"我的关注"),"检查进入我的关注页面");
		  //点击完成
		  Common.touchText(driver, "完成");
		  //选择关联车型
		  Common.touchText(driver, "关联车型");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");//点击奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]");//点击奥迪Q5
		  //检查关联车型成功
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪Q5")&&Common.checkTextExist(driver, "发表话题"),"检查关联车型成功");
		  //点击引用话题
		  Common.touchText(driver, "引用话题");
		  //检查进入引用话题页面
		  Assert.assertTrue(Common.checkTextExist(driver, "我的话题"),"检查进入引用话题页面");
		  //返回
		  Common.touchText(driver, "nav right close");
		  //点击提交
		  Common.touchText(driver, "提交");
		  //检查提交成功，可以在帮买车-最新 中查看
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪Q5")&&Common.checkTextExist(driver,"最新"),"检查话题发表成功");
		  
		  //收尾：删除话题，返回
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Common.touchText(driver, "topic btn action 4 nor");
		  Common.touchText(driver, "确定");
	  }
	    
	  /** 
		 * 投票-车款投票
		 * 
		 */	
	  @Test(priority = 3)
	  public void bangmaiche_opentopic_testcase3() throws Exception {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //点击发帖
		  Common.touchText(driver,"发帖");
		  //点击投票icon
		  Common.touchText(driver, "投票");
		  //点击投票类型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		  //点击发车款投票
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]");
		  //选择两款车
		  BangMaiChe.addCars(driver);
		  //选择在意方面：
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")), "检查在意的方面选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]")), "检查在意的方面选择成功");
		  //点击发布
		  Common.touchText(driver,"提交");
		  //检查提交成功，可以在最新中查看
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪A4L 2017款 40 TFSI 进取型 Plus、奥迪A6L 2017款 TFSI 技术型"),"检查提交成功，可以在最新中查看");
		  
		  //收尾：删除话题，返回
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Common.touchText(driver, "topic btn action 4 nor");
		  Common.touchText(driver, "确定");
	  }
	  
	  /** 
		 * 投票-车型投票
		 * 
		 */	
	  @Test(priority = 4)
	  public void bangmaiche_opentopic_testcase4() throws Exception {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //点击发帖
		  Common.touchText(driver,"发帖");
		  //点击投票icon
		  Common.touchText(driver, "投票");
		  //添加两种车型
		  BangMaiChe.addModels(driver);
		  //选择在意方面：
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")), "检查在意的方面选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]")), "检查在意的方面选择成功");
		  //点击发布
		  Common.touchText(driver,"提交");
		  //检查提交成功，可以在最新中查看
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪A4L、奥迪A6L"),"检查提交成功，可以在最新中查看");
		  //收尾：删除话题，返回
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Common.touchText(driver, "topic btn action 4 nor");
		  Common.touchText(driver, "确定");
	  }
	  
	  /** 
		 * 投票-观点投票
		 * 
		 */	
	  @Test(priority = 5)
	  public void bangmaiche_opentopic_testcase5() throws Exception {
		  //清空话题
		  WoDe.setTopicEmpty(driver);
		  //点击进入帮买车
		  Common.touchText(driver,"帮买车");
		  //点击最新
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  //点击发帖
		  Common.touchText(driver,"发帖");
		  //点击投票icon
		  Common.touchText(driver, "投票");
		  //点击投票类型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		  //点击观点投票
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[3]");
		  //输入两个选项内容
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]"), "北京资源好适宜居住");
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextView[1]"), "北京压力大不宜居住");
		  //点击发布
		  Common.touchText(driver,"提交");
		  //检查提交成功，可以在最新中查看
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]");
		  Assert.assertTrue(Common.checkTextExist(driver, "北京资源好适宜居住、北京压力大不宜居住"),"检查提交成功，可以在最新中查看");
		  //收起键盘
		  Common.swipeToUp(driver, 500, 1);
		  //收尾：删除话题，返回
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  Common.touchText(driver, "topic btn action 4 nor");
		  Common.touchText(driver, "确定");
	  }

}

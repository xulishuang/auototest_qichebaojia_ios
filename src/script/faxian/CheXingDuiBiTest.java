package script.faxian;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import common.Common;
import constant.Text;
import models.FaXian;
import models.WoDe;
import script.AppTestSuite;

public class CheXingDuiBiTest extends AppTestSuite{

	/**
	 * 车型对比-车型对比
	 * @throws Exception
	 */
	@Test
	public void faxian_chexingduibi_testCase1() throws Exception {
		//点击发现
		Common.touchText(driver,"发现");
	    //点击车型对比
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
        //清空已添加车款
        if (Common.checkTextExist(driver,"编辑")){
        	Common.touchText(driver, "编辑");
        	Common.touchText(driver, "清空");
        	Common.touchText(driver,"确认");
        }
        //添加两种车款
        Common.touchText(driver, "添加车款");
        Common.touchText(driver, "奥迪");
        Common.touchText(driver, "奥迪A4L");
        Common.touchText(driver, "40 TFSI 进取型 Plus");
        
        Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
        Common.touchText(driver, "奥迪");
        Common.touchText(driver, "奥迪A6L");
        Common.touchText(driver, "TFSI 技术型");
		//点击开始对比
        Common.touchText(driver,"开始对比");
		//进入车型对比页
        Assert.assertTrue(Common.checkTextExist(driver,"车型对比(2)"), "检查进入车型对比页面");
        //返回首页
        Common.multiBack(driver, 2);
	}
	
	/** 
	 * 编辑-删除
	 *  
	 */
	@Test(priority = 2)
	public void faxian_chexingduibi_testcase2() throws Exception {
		//进入车型对比
		Common.touchText(driver,"发现");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//去勾选其中一个车型后，点击删除
		Common.touchText(driver, "编辑");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		Common.touchText(driver,"删除");
		//检查删除成功
		Assert.assertTrue(Common.checkXpathNotExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"),"Delete successfully");
		//点击完成
		Common.touchText(driver, "完成");
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * 编辑-清空
	 *  
	 */
	@Test(priority = 3)
	public void faxian_chexingduibi_testcase3() throws Exception{
		//进入车型对比
		Common.touchText(driver,"发现");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//清空
		Common.touchText(driver, "编辑");
		Common.touchText(driver, "清空");
		Common.touchText(driver,"确认");
		//检查清空成功
		Assert.assertTrue(Common.checkXpathNotExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"), "clear successfully");
		//返回首页
		Common.back(driver);		  
	}
	
	/** 
	 *  发帖问网友-车款投票
	 *  
	 */
	@Test(priority = 4)
	public void faxian_chexingduibi_testcase4() throws Exception{
		//进入我的，清空已发话题
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		while (Common.checkTextNotExist(driver,"您还没有发表过话题")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			Common.touchText(driver, "topic btn action 4 nor");
			Common.touchText(driver,"确定");
		}
		Common.back(driver);
		Common.touchText(driver, "old navBackButton nor");
		  
		//进入发现-车型对比
		Common.touchText(driver,"发现");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//清空已添加车款
	    if (Common.checkTextExist(driver,"编辑")){
	    	Common.touchText(driver, "编辑");
	    	Common.touchText(driver, "清空");
	    	Common.touchText(driver,"确认");
	      }
	    //添加两种车款
	    Common.touchText(driver, "添加车款");
	    Common.touchText(driver, "奥迪");
	    Common.touchText(driver, "奥迪A4L");
	    Common.touchText(driver, "40 TFSI 进取型 Plus");
        
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	    Common.touchText(driver, "奥迪");
	    Common.touchText(driver, "奥迪A6L");
	    Common.touchText(driver, "TFSI 技术型");
	    //点击发帖问网友
	    Common.touchText(driver, "发帖问网友");
	    //检查进入车款投票页面，且显示已选择的两个车款
	    Assert.assertTrue(Common.checkTextExist(driver,"车款投票"), "默认条件是车款投票");
		Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"));
		//选择两个选项
		Common.touchText(driver,Text.ITEM1);
		Common.touchText(driver,Text.ITEM2);
		//检查两个选项选中
		String value1=driver.findElement(By.name(Text.ITEM1)).getAttribute("value");
		Assert.assertEquals(value1, "1", "检查选项1选中");
		String value2=driver.findElement(By.name(Text.ITEM1)).getAttribute("value");
		Assert.assertEquals(value2, "1", "检查选项2选中");
		//点击提交并返回首页
		Common.touchText(driver, "提交");		  
		Common.back(driver);
		  
		//检查话题发送成功
		Common.touchText(driver,"我的");
		Common.touchText(driver, "我的社区");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"),"检查话题发送成功");
		//恢复环境，清空已发话题
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.touchText(driver, "topic btn action 4 nor");
		Common.touchText(driver,"确定");
		//返回首页
		Common.back(driver);
		Common.touchText(driver, "old navBackButton nor");
	}
	
	/** 
	 * 发帖问网友-车型投票
	 *  
	 */
  @Test(priority = 5)
  public void faxian_chexingduibi_testcase5() throws Exception {
	  //清空已发话题
	  WoDe.setTopicEmpty(driver);
	  //清空车型对比中已添加的车型
	  FaXian.setContrastCarsEmpty(driver);
	  //进入发现-车型对比
	  Common.touchText(driver,"发现");
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
	  //添加两种车款
	  Common.touchText(driver, "添加车款");
	  Common.touchText(driver, "奥迪");
	  Common.touchText(driver, "奥迪A4L");
	  Common.touchText(driver, "40 TFSI 进取型 Plus");
      
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	  Common.touchText(driver, "奥迪");
	  Common.touchText(driver, "奥迪A6L");
	  Common.touchText(driver, "TFSI 技术型");
	  //点击发帖问网友
	  Common.touchText(driver, "发帖问网友");
	  Assert.assertTrue(Common.checkTextExist(driver,"发布投票"), "Vote Page");
	  //选择投票类型为车型投票
	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	  Common.touchText(driver, "车型投票");
	  //点击添加车型
	  Common.touchText(driver,"添加车型");
	  Common.touchText(driver,"奥迪");
	  Common.touchText(driver,"奥迪A4L");
	  
	  Common.touchText(driver,"添加车型");
	  Common.touchText(driver,"奥迪");
	  Common.touchText(driver,"奥迪A6L");
	  //选择两个选项
	  Common.touchText(driver,Text.ITEM1);
	  Common.touchText(driver,Text.ITEM2);
	  //检查两个选项选中
	  String value1=driver.findElement(By.name(Text.ITEM1)).getAttribute("value");
	  Assert.assertEquals(value1, "1", "检查选项1选中");
	  String value2=driver.findElement(By.name(Text.ITEM1)).getAttribute("value");
	  Assert.assertEquals(value2, "1", "检查选项2选中");
	  //点击提交并返回首页
	  Common.touchText(driver, "提交");		  
      Common.back(driver);
		  
      //检查话题发送成功
      Common.touchText(driver,"我的");
      Common.touchText(driver, "我的社区");
      Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
      Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"),"检查话题发送成功");
      //恢复环境，清空已发话题
      Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
      Common.touchText(driver, "topic btn action 4 nor");
      Common.touchText(driver,"确定");
      //返回首页
      Common.back(driver);
      Common.touchText(driver, "old navBackButton nor");
      }
  
  /** 
	 * 发帖问网友-观点投票
	 *  
	 */
  @Test(priority = 6)
  public void faxian_chexingduibi_testcase6() throws Exception {
//	  //清空已发话题
//	  WoDe.setTopicEmpty(driver);
//	  //清空车型对比中已添加的车型
//	  FaXian.setContrastCarsEmpty(driver);
//	  //进入发现-车型对比
//	  Common.touchText(driver,"发现");
//	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
//	  //添加两种车款
//	  FaXian.addCars(driver);
//	  //点击发帖问网友
//	  Common.touchText(driver, "发帖问网友");
//	  Assert.assertTrue(Common.checkTextExist(driver,"发布投票"), "Vote Page");
//	  //选择投票类型为车型投票
//	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
//	  Common.touchText(driver, "观点投票");
//	  
//	  //输入两个选项内容
//	  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"),"Audi Q5");
//	  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"), "BMW X5");
//	  //输入投票说明
//	  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]"),"How to choose");
//	  //收起键盘
//	  Common.swipeToDown(driver, 500, 1);
//	  //点击提交并返回首页
//	  Common.touchText(driver, "提交");
//      Common.back(driver);
//		  
//      //检查话题发送成功
//      Common.touchText(driver,"我的");
//      Common.touchText(driver, "我的社区");
//      Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
//      Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"),"检查话题发送成功");
//      //恢复环境，清空已发话题
//      Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
//      Common.touchText(driver, "topic btn action 4 nor");
//      Common.touchText(driver,"确定");
//      //返回首页
//      Common.back(driver);
//      Common.touchText(driver, "old navBackButton nor");
      }
}


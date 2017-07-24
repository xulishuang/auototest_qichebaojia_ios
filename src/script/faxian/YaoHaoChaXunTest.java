package script.faxian;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;
import models.FaXian;

public class YaoHaoChaXunTest extends AppTestSuite{
	
     /**
      * 摇号查询-全局添加摇号-页底添加摇号
      * 
      */
	 @Test(priority = 1)
	 public void fanxian_yaohaochaxun_testcase1() throws Exception{
		//进入摇号查询
		FaXian.enterYaoHaoChaXunPage(driver);
		//进入添加申请人页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//检查进入添加申请人页面
		Assert.assertTrue(Common.checkTextExist(driver, "添加申请人"),"进入添加申请人页");
		//输入编号、姓名
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"), "1234567890123");//未中签
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]"), "测试");
		//检查默认城市为北京
		Assert.assertTrue(Common.checkTextExist(driver, "北京"), "检查默认城市显示为北京");
		//修改所在城市
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		Common.selectValue(driver, "广州");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAToolbar[1]/UIAButton[1]");//点击完成
		//判断城市是否修改成功
		Assert.assertTrue(Common.checkTextExist(driver, "广州"), "修改城市成功");
		//点击提交
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		//提交成功后，返回到摇号查询首页
		Assert.assertTrue(Common.checkTextExist(driver, "摇号查询"), "检查成功返回到摇号查询首页");
		//判断摇号申请是否添加成功
		String text1 = Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertEquals(text1, "广州", "检查广州显示在列表第一位");
		Assert.assertTrue(Common.checkTextExist(driver, "1234567890123"),"摇号申请添加成功");
		//返回首页
		Common.back(driver);
		
	 }
	 
	 /**
      * 摇号查询-局部添加摇号-固定城市添加摇号
      * @precondition 接续testcase1
      * 
      */
	 @Test(priority = 2)
	 public void faxian_yaohaochaxun_testcase2() throws Exception{
		 //进入摇号查询
		 FaXian.enterYaoHaoChaXunPage(driver);
		 //进入广州添加编码
		 Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		 //判断城市是否为广州
		 Assert.assertTrue(Common.checkTextExist(driver, "广州"), "检查城市为广州");
		 //输入编号、姓名
		 Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"), "2167101435820");//已中签
		 Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]"), "姓名");
		 //点击提交
		 Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		 //提交成功后，返回到摇号查询首页
		 Assert.assertTrue(Common.checkTextExist(driver, "摇号查询"), "成功返回到摇号查询首页");
		 //判断摇号申请是否添加成功
		 Assert.assertTrue(Common.checkTextExist(driver, "2167101435820"),"检查摇号申请添加成功");
		 //返回首页
		 Common.back(driver);
		 }
     
	 /**
	  * 摇号查询-中签效果-看我多幸运
	  * @precondtion 接续testcase2
	  */
	  @Test(priority = 3)
	  public void fanxian_yaohaochaxun_testcase3()  throws Exception{
		  //进入摇号查询
		  FaXian.enterYaoHaoChaXunPage(driver);
		  //点击看我多幸运
		  Common.touchText(driver, "car num lucky");
		  //检查进入看我多幸运页面
		  Assert.assertTrue(Common.checkTextExist(driver, "看我有多幸运"),"检查进入看我有多幸运页面");
		  //选择日期
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		  Common.selectValue(driver, "2016");
		  //点击确定
//		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		  Common.touchText(driver,"确定");
		  //检查日期选择成功
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[6]"));
		  System.out.println(text);
		  Assert.assertTrue(text.contains("2016"), "日期选择成功");
		  //判断分享按钮是否显示正确
		  Assert.assertTrue(Common.checkTextExist(driver, "喜上眉梢，昭告天下"), "按钮显示正常");
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	  
	 /**
	  * 摇号查询-中签效果-看我多倒霉
	  * @precondition 接续testcase1
	  */
	  @Test(priority=4)
	  public void faxian_yaohaochaxun_testcase4() throws Exception{
		  //进入摇号查询
		  FaXian.enterYaoHaoChaXunPage(driver);
		  //点击看我多倒霉
		  Common.touchText(driver,"car num unlucky");
		  //检查进入看我多倒霉页面
		  Assert.assertTrue(Common.checkTextExist(driver, "看我有多倒霉"),"检查进入看我有多倒霉页面");
		  //选择日期
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		  Common.selectValue(driver, "2016");
		  //点击确定
//		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		  Common.touchText(driver,"确定");
		  //检查日期选择成功
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[6]"));
		  System.out.println(text);
		  Assert.assertTrue(text.contains("2016"), "日期选择成功");
		  //判断分享按钮是否显示正确
		  Assert.assertTrue(Common.checkTextExist(driver, "告诉朋友我有多不爽"), "按钮显示正常");
		  //返回首页
		  Common.multiBack(driver,2);
	  }
	  
	   /**
		 * 摇号查询-删除记录-删除
		 * 
		 */
	  @Test(priority = 5)
	  public void fanxian_yaohaochaxun_testcase5()  throws Exception{ 
		  //进入摇号查询
		  FaXian.enterYaoHaoChaXunPage(driver);
		  //点击编辑
		  Common.touchTopRight(driver);//通过坐标点击编辑
		  //点击删除已添加的两个编号
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
		  Common.touchText(driver, "删除");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
		  Common.touchText(driver, "删除");
		  //返回首页
		  Common.back(driver);
		  }
	}

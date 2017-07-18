package script.ershouche;

import org.openqa.selenium.By;  
import org.testng.Assert;
import org.testng.annotations.*; 

import script.AppTestSuite;
 
import common.*;
import constant.Text;

public class HomePageTest extends AppTestSuite{

	  /** 
		 * 地区-更换地区
		 * 
		 */	
	  @Test(priority = 1)
	  public void ershouche_homepage_testcase1() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击地区
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		  //检查弹出城市选择页，且显示当前所在城市为北京
		  Assert.assertTrue(Common.checkTextExist(driver,"选择城市"), "检查进入选择城市页面");
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		  Assert.assertEquals(text,"北京","检查城市默认显示为北京");
		  //选择某省份、城市：重庆
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAButton[4]");	  
		  //检查返回到二手车列表页，显示选择的城市
		  Assert.assertTrue(Common.checkTextExist(driver,"二手车"), "检查返回二手车页面");
		  Assert.assertTrue(Common.checkTextExist(driver,"重庆"), "检查城市显示为重庆");
		  //恢复环境：选择城市为北京
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		  Common.touchXpath(driver, " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	  }
	  
//	  /** 
//		 * 帮买帮卖-帮买、帮卖出现逻辑 
//		 * 
//		 */	
//	  @Test(priority = 2)
//	  public void ershouche_homepage_testcase2() throws Exception {
//		  
//	  }
	    
	  /** 
		 * 帮买帮卖-帮买、帮卖链接跳转
		 * 
		 */	
	  @Test(priority = 3)
	  public void ershouche_homepage_testcase3() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击帮买二手车
		  if(Common.checkTextExist(driver,"帮买二手车")){
			  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
			  //检查进入帮买服务页面
			  Assert.assertTrue(Common.checkTextExist(driver, "帮买服务"),"检查进入帮买服务页面");
			  //点击返回至二手车
			  Common.back(driver);
		  }  
		  //点击帮您卖车
		  if(Common.checkTextExist(driver,"帮您卖车")){
			  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
			  //检查进入帮您卖车页面
			  Assert.assertTrue(Common.checkTextExist(driver,"帮您卖车"),"检查进入帮您卖车页面");
			  //点击返回二手车页面
			  Common.back(driver);
			  Assert.assertTrue(Common.checkTextExist(driver, "二手车"), "检查返回二手车页面");
		  }
	  }
	  
	  /** 
		 * 品牌-品牌筛选
		 * 
		 */	
	  @Test(priority = 4)
	  public void ershouche_homepage_testcase4() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击品牌下拉菜单
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[1]");
		  //检查进入品牌选择页
		  Assert.assertTrue(Common.checkTextExist(driver, "品牌")&&Common.checkTextNotExist(driver,"二手车"),"检查进入品牌选择页面");
		  //选择品牌：奥迪
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  //选择车型:奥迪Q5
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]");
		  //检查品牌车型筛选成功
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[1]"));
		  Assert.assertEquals(text,"奥迪Q5","检查品牌车型筛选成功");
		  //恢复环境，选择全部车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	  }
	  
	  /** 
		 * 价格-价格筛选
		 * 
		 */	
	  @Test(priority = 5)
	  public void ershouche_homepage_testcase5() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击价格下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]");
		  //选择价格区间:15-20
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]");
		  //检查返回到二手车列表页，显示选择的价格区间
		  String text=Common.getText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]"));
		  Assert.assertEquals(text,"15-20万","检查价格区间筛选成功");
		  //再次点击价格下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]");
		  //输入自定义价格，点【确定】
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"), "10");
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]"), "30");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		  //检查返回到二手车列表页，显示自定义价格区间
		  String text1=Common.getText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]"));
		  Assert.assertEquals(text1,"10-30万","检查价格区间筛选成功");
		  //恢复环境，选择价格为不限
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
	  }
	  
	  /** 
		 * 条件-条件筛选
		 * 
		 */	
	  @Test(priority = 6)
	  public void ershouche_homepage_testcase6() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击筛选下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[3]");
		  //选择车龄、里程、级别、车源、变速箱、排量、国别，点【确定】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[1]"); //1年内
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[7]"); //1万公里内
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[14]"); //中型车
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[1]")), "检查1年内选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[7]")), "检查1万公里内选择成功");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[14]")), "检查中型车选择成功");
		  //点击确认
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		  //检查返回到二手车列表页
		  Assert.assertTrue(Common.checkTextExist(driver, "二手车"),"检查返回二手车页面");
	  }
	    
	  /** 
		 * 条件-清空筛选条件
		 * @preconditon 接续testcase6
		 * 
		 */	
	  @Test(priority = 7)
	  public void ershouche_homepage_testcase7() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击筛选下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[3]");
		  //点【重置】
		  Common.touchXpath(driver," //UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		  //检查重置成功
		  Assert.assertFalse(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[1]")), "检查重置成功");
		  Assert.assertFalse(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[7]")), "检查重置成功");
		  Assert.assertFalse(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[14]")), "检查重置成功");
		  //点击【确定】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		  //检查返回到二手车列表页
		  Assert.assertTrue(Common.checkTextExist(driver, "二手车"),"检查返回二手车页面");
	  }
	  
	  /** 
		 *排序-价格最低排序
		 * 
		 */	
	  @Test(priority = 8)
	  public void ershouche_homepage_testcase8() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]");
		  //选择【价格最低】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		  //返回到二手车列表
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]"));
		  Assert.assertEquals(text,"价格最低","检查显示价格最低列表");
	  }
	  
	  /** 
		 * 排序-价格最高排序
		 * 
		 */	
	  @Test(priority = 9)
	  public void ershouche_homepage_testcase9() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]");
		  //选择【价格最高】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
		  //返回到二手车列表
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]"));
		  Assert.assertEquals(text,"价格最高","检查显示价格最高列表");
	  }
	  
	  /** 
		 * 排序-时间最新排序
		 * 
		 */	
	  @Test(priority = 10)
	  public void ershouche_homepage_testcase10() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]");
		  //选择【时间最新】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  //返回到二手车列表
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]"));
		  Assert.assertEquals(text,"时间最新","检查显示时间最新列表");
	  }
	  
	  /** 
		 * 排序-车龄最短排序
		 * 
		 */	
	  @Test(priority = 11)
	  public void ershouche_homepage_testcase11() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]");
		  //选择【车龄最短】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]");
		  //返回到二手车列表
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]"));
		  Assert.assertEquals(text,"车龄最短","检查显示车龄最短列表");
	  }
	  
	  /** 
		 * 排序-里程最少排序
		 * 
		 */	
	  @Test(priority = 12)
	  public void ershouche_homepage_testcase12() throws Exception {
		  //进入二手车
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]");
		  //选择【里程最少】
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]");
		  //返回到二手车列表
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[4]"));
		  Assert.assertEquals(text,"里程最少","检查显示里程最少列表");
	  }
}

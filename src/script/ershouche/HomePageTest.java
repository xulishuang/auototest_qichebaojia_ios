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
		  //默认显示当前所在城市，点击地区
		  Common.touchId(driver,Id.TITLE_LEFT_BTN);
		  String text=Common.getText(driver, By.id(Id.PROVINCE_NAME_TV));
		  Assert.assertEquals(text, Text.CURRENT_CITY, "current city is Beijing");
		  //检查弹出城市选择页
		  Assert.assertTrue(Common.checkTextExist(driver,Text.CHOOSE_CITY), "Enter city choose page");
		  //选择某省份、城市
		  Common.touchSlideText(driver,Text.PROVINCE_HUNAN,3);
		  Common.touchText(driver,Text.CITY_CHANGSHA);		  
		  //返回到二手车列表页，显示选择的城市
		  Assert.assertTrue(Common.checkTextExist(driver,Text.ERSHOUCHE), "Enter ershouche page");
		  Assert.assertTrue(Common.checkTextExist(driver,Text.CITY_CHANGSHA), "City is Changsha");
		  
		  //恢复到current city
		  Common.touchId(driver,Id.TITLE_LEFT_BTN);
		  Common.back(driver);
		  Common.swipeToDown(driver, 500, 2);
		  Common.touchText(driver, Text.CURRENT_CITY);
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
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击帮买二手车
		  if(Common.checkIdExist(driver,Id.USEDCAR_BUY_TITLE)){
			  Common.touchId(driver, Id.USEDCAR_BUY_TITLE);
			  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
			  Assert.assertEquals(text1,Text.HELP_BUY_SERVICE,"Enter Bangmai Page");
//			  Assert.assertTrue(Common.checkIdExist(driver, Id.WEBVIEW),"H5 Page");
			  //点击关闭
			  Common.touchText(driver, Text.CLOSE);
			  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
			  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  }
		  
		  //点击帮您卖车
		  if(Common.checkIdExist(driver,Id.USEDCAR_SALE_TITLE)){
			  Common.touchId(driver, Id.USEDCAR_SALE_TITLE);
			  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
			  Assert.assertEquals(text, Text.HELP_SALE_SERVICE,"Enter sBangmai Page");
//			  Assert.assertTrue(Common.checkIdExist(driver, Id.WEBVIEW),"H5 Page");
			  //点击关闭
			  Common.touchText(driver, Text.CLOSE);
			  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
			  Assert.assertEquals(text1, Text.ERSHOUCHE, "back to ershouche page");
		  }
	  }
	  
	  /** 
		 * 品牌-品牌筛选
		 * 
		 */	
	  @Test(priority = 4)
	  public void ershouche_homepage_testcase4() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击品牌下拉菜单
		  Common.touchId(driver, Id.CAR_MODELS);
		  //检查进入品牌选择页
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.BRAND, "enter brand choose page");
		  //选择品牌
		  Common.touchText(driver,Text.AUDI);
		  //选择车型
		  Common.touchSlideText(driver, Text.AUDI_A4L, 3);
		  //检查返回二手车界面
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text1, Text.ERSHOUCHE, "back to ershouche page");
		  
		  String text2=Common.getText(driver, By.id(Id.CAR_MODELS));
		  Assert.assertEquals(text2, Text.AUDI_A4L, "show A4L information");
		  
		  //恢复环境，选择全部车型
		  Common.touchId(driver, Id.CAR_MODELS);
		  Common.touchText(driver, Text.ALL_MODELS);
	  }
	  
	  /** 
		 * 价格-价格筛选
		 * 
		 */	
	  @Test(priority = 5)
	  public void ershouche_homepage_testcase5() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击价格下拉菜单
		  Common.touchId(driver, Id.CAR_PRICE);
		  //选择价格区间
		  Common.touchText(driver,Text.PRICE_15_20);
		  //检查返回到二手车列表页，显示选择的价格区间
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_PRICE));
		  Assert.assertEquals(text1, Text.PRICE_15_20, "show 15-20");
		  //再次点击价格下拉菜单
		  Common.touchId(driver, Id.CAR_PRICE);
		  //输入自定义价格，点【确定】
		  Common.sendTextById(driver, Id.EDIT1, "10");
		  Common.sendTextById(driver, Id.EDIT2, "30");
		  Common.touchText(driver,Text.OK);
		  //检查返回到二手车列表页，显示自定义价格区间
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text3=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text3, Text.ERSHOUCHE, "back to ershouche page");
		  String text4=Common.getText(driver, By.id(Id.CAR_PRICE));
		  Assert.assertEquals(text4, "10-30万", "show 10-30");
		  
		  //恢复环境，选择价格为不限
		  Common.touchId(driver, Id.CAR_PRICE);
		  Common.touchText(driver, Text.UNLIMITED);
	  }
	  
	  /** 
		 * 条件-条件筛选
		 * 
		 */	
	  @Test(priority = 6)
	  public void ershouche_homepage_testcase6() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击筛选下拉菜单
		  Common.touchId(driver, Id.CAR_YEARS);
		  //选择车龄、里程、级别、车源、变速箱、排量、国别，点【确定】
		  Common.touchText(driver,Text.LESS_THAN_1YEAR);
		  Common.touchText(driver,Text.LESS_THAN_10THOUSAND_KM);
		  Common.touchText(driver,Text.MIDSIZE_CAR);
		  Assert.assertTrue(Common.checkTextIsSelected(driver,Text.LESS_THAN_1YEAR), "Is selected");
		  Assert.assertTrue(Common.checkTextIsSelected(driver,Text.LESS_THAN_10THOUSAND_KM), "Is selected");
		  Assert.assertTrue(Common.checkTextIsSelected(driver,Text.MIDSIZE_CAR), "Is selected");
		  Common.touchText(driver, Text.OK);
		  //检查返回到二手车列表页
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
	  }
	    
	  /** 
		 * 条件-清空筛选条件
		 * 
		 */	
	  @Test(priority = 7)
	  public void ershouche_homepage_testcase7() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击筛选下拉菜单
		  Common.touchId(driver, Id.CAR_YEARS);
		  //选择车龄、里程、级别、车源、变速箱、排量、国别，点【重置】
		  Common.touchText(driver, Text.RESET);
		  Assert.assertTrue(Common.checkTextIsNotSelected(driver,Text.LESS_THAN_1YEAR), "Is not selected");
		  Assert.assertTrue(Common.checkTextIsNotSelected(driver,Text.LESS_THAN_10THOUSAND_KM), "Is not selected");
		  Assert.assertTrue(Common.checkTextIsNotSelected(driver,Text.MIDSIZE_CAR), "Is not selected");
		  //点击【确定】
		  Common.touchText(driver,Text.OK);
		  //检查返回到二手车列表页
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
	  }
	  
	  /** 
		 *排序-价格最低排序
		 * 
		 */	
	  @Test(priority = 8)
	  public void ershouche_homepage_testcase8() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchId(driver,Id.CAR_MILEAGE);
		  //选择【价格最低】
		  Common.touchText(driver, Text.LOWEST_PRICE);
		  //返回到二手车列表
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_MILEAGE));
		  Assert.assertEquals(text1, Text.LOWEST_PRICE, "lowest price");
	  }
	  
	  /** 
		 * 排序-价格最高排序
		 * 
		 */	
	  @Test(priority = 9)
	  public void ershouche_homepage_testcase9() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchId(driver,Id.CAR_MILEAGE);
		  //选择【价格最高】
		  Common.touchText(driver, Text.HIGHEST_PRICE);
		  //返回到二手车列表
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_MILEAGE));
		  Assert.assertEquals(text1, Text.HIGHEST_PRICE, "highest price");
	  }
	  
	  /** 
		 * 排序-时间最新排序
		 * 
		 */	
	  @Test(priority = 10)
	  public void ershouche_homepage_testcase10() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchId(driver,Id.CAR_MILEAGE);
		  //选择【时间最新】
		  Common.touchText(driver, Text.NEWEST_TIME);
		  //返回到二手车列表
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_MILEAGE));
		  Assert.assertEquals(text1, Text.NEWEST_TIME, "newest price");
	  }
	  
	  /** 
		 * 排序-车龄最短排序
		 * 
		 */	
	  @Test(priority = 11)
	  public void ershouche_homepage_testcase11() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchId(driver,Id.CAR_MILEAGE);
		  //选择【车龄最短】
		  Common.touchText(driver, Text.SHORTEST_CAR_AGE);
		  //返回到二手车列表
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_MILEAGE));
		  Assert.assertEquals(text1, Text.SHORTEST_CAR_AGE, "shortest car age");
	  }
	  
	  /** 
		 * 排序-里程最少排序
		 * 
		 */	
	  @Test(priority = 12)
	  public void ershouche_homepage_testcase12() throws Exception {
		  Common.touchText(driver,Text.ERSHOUCHE);
		  //点击排序下拉菜单
		  Common.touchId(driver,Id.CAR_MILEAGE);
		  //选择【车龄最短】
		  Common.touchText(driver, Text.MINIMUM_MILEAGE);
		  //返回到二手车列表
		  Common.waitForVisible(driver, By.name(Text.ERSHOUCHE), 15);
		  String text=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
		  Assert.assertEquals(text, Text.ERSHOUCHE, "back to ershouche page");
		  String text1=Common.getText(driver, By.id(Id.CAR_MILEAGE));
		  Assert.assertEquals(text1, Text.MINIMUM_MILEAGE, "minimum mileage");
	  }
}

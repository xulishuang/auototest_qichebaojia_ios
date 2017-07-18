package script.ershouche;

import org.openqa.selenium.By; 
import org.testng.Assert;
import org.testng.annotations.*;

import script.AppTestSuite;
 
import common.*;
import models.ErShouChe;
import models.WoDe;
import models.XinChe;

public class CheYuanXiangQingTest extends AppTestSuite{
	
	  /** 
		 * 车源详情页-收藏车源
		 * 
		 */	
	  @Test(priority = 1)
	  public void ershouche_cheyuanxiangqing_testcase1() throws Exception {
		  //清空二手车收藏
		  WoDe.setUsedCarCollectionEmpty(driver);
		  //收藏车源
		  ErShouChe.collectUsedCar(driver);
		  //检查收藏成功
		  XinChe.enterCheXingShouCangPage(driver);
		  Common.touchText(driver, "二手车");
		  //检查二手车收藏成功
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("二手车")), "检查进入二手车收藏页面");
		  Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查二手车收藏成功");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 车源详情页-取消收藏车源
		 * @precondition 接续testcase1
		 * 
		 */	
	  @Test(priority = 2)
	  public void ershouche_cheyuanxiangqing_testcase2() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击取消收藏
		  Common.touchText(driver, "fav nor");
		  //进入二手车收藏页面
		  Common.back(driver);
		  XinChe.enterCheXingShouCangPage(driver);
		  Common.touchText(driver,"二手车");
		  //检车二手车收藏取消成功
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("二手车")), "检查进入二手车收藏页面");
		  Assert.assertTrue(Common.checkXpathNotExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查无二手车收藏");
		  //返回首页
		  Common.back(driver);
	  }
	    
	  /** 
		 * 车源详情页-贷款
		 * 
		 */	
	  @Test(priority = 3)
	  public void ershouche_cheyuanxiangqing_testcase3() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击贷款一栏
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		  //输入姓名和手机号
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]"),"小红");
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[2]"), "13666666666");
		  //点击完善资料，提高贷款成功率
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[3]");
		  //选择职业、收入、社保、房产
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[4]"); //选择上班族
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]"); //选择有本地社保
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[4]"); //选择9000元以上
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]"); //选择有房全款
		  //检查资料完善成功
		  Assert.assertTrue(Common.checkTextExist(driver,"职业       上班族"), "检查职业选择成功");
		  Assert.assertTrue(Common.checkTextExist(driver,"社保       有本地社保"), "检查社保选择成功");
		  Assert.assertTrue(Common.checkTextExist(driver,"收入       9000元以上"), "检查收入选择成功");
		  Assert.assertTrue(Common.checkTextExist(driver,"房产       有房（全款）"), "检查房产选择成功");
		  //点击返回
		  Common.back(driver);
		  //选择首付比例
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[1]");
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[4]");
		  Assert.assertTrue(Common.checkTextExist(driver,"首付20%"),"检查首付比例选择成功");
		  //选择还款期限
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[2]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[2]");
		  Assert.assertTrue(Common.checkTextExist(driver,"还款12期"),"检查还款年限选择成功");
		  //返回首页
		  Common.touchText(driver, "nav right close");
		  Common.back(driver);
	  }
	  
	  /** 
		 * 车源详情页-新车参数
		 * 
		 */	
	  @Test(priority = 4)
	  public void ershouche_cheyuanxiangqing_testcase4() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //查看新车参数
		  Common.swipeToUp(driver, 500, 1);
		  Common.touchText(driver, "查看新车参数");
		  //检查进入新车参数页面
		  Assert.assertTrue(Common.checkTextExist(driver, "新车参数"),"检查进入新车参数页面");
		  //点击分类
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		  //点击某个分类:灯光
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAImage[1]/UIAScrollView[1]/UIAButton[10]");
		  //检查点击某个分类后，收起分类弹框，页面定位到选择的分类处
		  Assert.assertTrue(Common.checkTextExist(driver, "前照灯自动清洗功能"), "检查分类成功");
		  //返回首页
		  Common.multiBack(driver, 2);
	  }
	  
	  /** 
		 * 车源详情页-举报车源
		 * 
		 */	
	  @Test(priority = 5)
	  public void ershouche_cheyuanxiangqing_testcase5() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击举报该车源
		  Common.swipeToUp(driver, 500, 1);
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  //检查进入举报车源页
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]"));
		  Assert.assertEquals(text, "举报车源", "检查进入举报车源页面");
		  //点击此车已售并输入补充说明
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
		  Assert.assertTrue(Common.checkIsSelected(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")), "检查此车已售选择成功");
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"), "test");
		  Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[10]"), "检查可提交");
		  //返回首页
		  Common.touchText(driver, "nav right close");
		  Common.back(driver);
	  }
	  
	  /** 
		 * 车源详情页-卖家描述规则2
		 * 
		 */	
	  @Test(priority = 6)
	  public void ershouche_cheyuanxiangqing_testcase6() throws Exception {
		  //进入商家车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击经销商名称
		  Common.swipeToUp(driver, 500, 1);
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]");
		  Assert.assertTrue(Common.checkTextExist(driver, "商家信息"), "检查进入商家信息页面");
		  //点击免费咨询
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver, "呼叫"), "检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //点击查看地图
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
		  //检查进入商家地图页面
		  Assert.assertTrue(Common.checkTextExist(driver, "去这里"),"检查进入商家地图页面");
		  //返回首页
		  Common.multiBack(driver, 3);
	  }
	    
	  /** 
		 * 车源详情页-同价位/同车系列表
		 * 
		 */	
	  @Test(priority = 7)
	  public void ershouche_cheyuanxiangqing_testcase7() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击同车系标签
		  
		  //点击同价位标签
		  
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 车源详情页-砍价
		 * 
		 */	
	  @Test(priority = 8)
	  public void ershouche_cheyuanxiangqing_testcase8() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击砍价
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		  //输入心理价位+手机号
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[1]"), "2");
		  Common.sendText(driver,By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[2]"), "1366666666");
		  //检查输入心理价位成功
		  String text1=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[1]"), "value");
		  Assert.assertEquals(text1, "2", "检查输入心理价位成功");
		  //检查输入手机号成功
		  String text2=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[2]"), "value");
		  Assert.assertEquals(text2, "1366666666", "检查输入手机号码成功");
		  //返回首页
		  Common.touchText(driver, "nav right close");
		  Common.back(driver);
	  }
	  
	  /** 
		 * 车源详情页-拨打电话
		 * 
		 */	
	  @Test(priority = 9)
	  public void ershouche_cheyuanxiangqing_testcase9() throws Exception {
		  //进入二手车车源详情页
		  ErShouChe.enterUsedCarDetailPage(driver);
		  //点击免费咨询
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");
		  //检查弹出呼叫提示
		  Assert.assertTrue(Common.checkTextExist(driver, "呼叫"), "检查弹出呼叫提示");
		  //点击取消
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //返回首页
		  Common.back(driver);
	  }
	  
}

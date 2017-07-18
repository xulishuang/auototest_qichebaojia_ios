package script.xinche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import common.Common;
import models.XinChe;
import script.AppTestSuite;

public class JiangJiaPaiHangTest extends AppTestSuite{
	/**
	 *车型筛选-选择城市
	 *预期结果：数据刷新
	 * 
	 */
	@Test(priority = 1)
	public void xinche_jiangjiapaihang_testcase1() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//检查进入降价排行页面
		Assert.assertTrue(Common.checkTextExist(driver,"降价排行")&&Common.checkTextExist(driver,"车型筛选"),"检查进入降价排行页面");
		//更换城市，选择重庆
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		Common.touchText(driver,"重庆");
		//检查城市更换城市成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]"));
		Assert.assertEquals(text, "重庆","检查更换城市成功");
		
		//恢复环境:更换城市为北京，返回首页
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		Common.touchText(driver,"北京");
		Common.back(driver);
	}
	/** 
	 * 车型筛选-全部车型
	 *  
	 */
	@Test(priority = 2)
	public void xinche_jiangjiapaihang_testcase2() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择全部车型
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//检查全部车型选择成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
		Assert.assertEquals(text, "车型筛选","检查全部车型选择成功");
		//返回首页
		Common.back(driver);
	}
  
	/** 
	 * 车型筛选-具体品牌车型
	 *  
	 */
	@Test(priority = 3)
	public void xinche_jiangjiapaihang_testcase3() throws Exception{
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择具体品牌车型：奥迪Q5
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]");
		//检查选择品牌车型成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertTrue(text.contains("奥迪Q5"),"检查选择品牌车型成功");
		//恢复环境：选择全部车型，返回首页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		Common.back(driver);
	}
 
	/** 
	 	* 车型筛选-车款筛选
	 *  
	 */
	@Test(priority = 4)
	public void xinche_jiangjiapaihang_testcase4() throws Exception{
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择具体品牌车型：奥迪Q5
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]");
		//选择车款
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]");
		//选择显示的第一个车款
		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//检查车款筛选成功
		String text2=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertTrue(text2.contains(text1),"检查车款筛选成功");
		//恢复环境：选择全部车型，返回首页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		Common.back(driver);
	}
  
	/** 
	 * 条件筛选-选择
	 *  
	 */
	@Test(priority = 5)
	public void xinche_jiangjiapaihang_testcase5() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//获得当前页面显示的第一款车型
		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		//进行条件筛选：紧凑型
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[5]");
		Assert.assertTrue(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[5]")));
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]");
		//检查条件筛选成功
		String text2=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertNotEquals(text1, text2, "检查条件筛选成功");
		//返回首页
		Common.back(driver);
  }
  
	/** 
	 * 条件筛选-重置
	 * @precondition 接续testcase5 非必须
	 *  
	 */
	@Test(priority = 6)
	public void xinche_jiangjiapaihang_testcase6() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//获得当前页面显示的第一款车型
		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		//进行重置
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");
		Assert.assertFalse(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[5]")));
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]");
		//检查条件筛选成功
		String text2=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
		Assert.assertNotEquals(text1, text2, "检查条件筛选成功");
		//返回首页
		Common.back(driver);
	}
  
	/** 
	 * 默认排序-降幅最大
	 *  
	 */  
	@Test(priority = 7)
	public void xinche_jiangjiapaihang_testcase7() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择降幅最大
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		//检查降幅最大选择成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]"));
		Assert.assertEquals(text,"降幅最大","检查降幅最大选择成功");
		//返回首页
		Common.back(driver);		  
	}
  
	/** 
	 * 默认排序-价格最高
	 *  
	 */
	@Test(priority = 8)
	public void xinche_jiangjiapaihang_testcase8() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择价格最高
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
		//检查价格最高选择成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]"));
		Assert.assertEquals(text,"价格最高","检查价格最高选择成功");
		//返回首页
		Common.back(driver);
	}
  
	/** 
	 * 默认排序-价格最低
	 *  
	 */
	@Test(priority = 9)
	public void xinche_jiangjiapaihang_testcase9() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//选择价格最低
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
		//检查价格最低选择成功
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]"));
		Assert.assertEquals(text,"价格最低","检查价格最高选择成功");
		//返回首页
		Common.back(driver);
	}
  
	/** 
	 * 数据列表-数据项：进入降价详情页面
	 *  
	 */
	@Test(priority = 10)
	public void xinche_jiangjiapaihang_testcase10() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//点击第一条数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入降价详情页面
		Assert.assertTrue(Common.checkTextExist(driver,"降价详情"),"检查进入降价详情页面");
		//返回首页
		Common.multiBack(driver, 2);
	}
  
	/** 
	 * 数据列表-电话
	 *  
	 */
	@Test(priority = 11)
	public void xinche_jiangjiapaihang_testcase11() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//点击第一条数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击购车咨询
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//检查弹出呼叫提示
		Assert.assertTrue(Common.checkTextExist(driver,"呼叫"),"检查弹出呼叫提示");
		//点击取消
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//返回首页
		Common.multiBack(driver, 2);
	}
  
	/** 
	 * 数据列表-贷款
	 *  
	 */
	@Test(priority = 12)
	public void xinche_jiangjiapaihang_testcase12() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//点击第一条数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击贷款
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
		//检查进入贷款页面
		Assert.assertTrue(Common.checkTextExist(driver, "贷款")&&Common.checkTextExist(driver,"提交"),"检查进入贷款页面");
		//返回首页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		Common.multiBack(driver,2);
	}
  
	/** 
	 * 数据列表-询底价
	 *  
	 */
	@Test(priority = 13)
	public void xinche_jiangjiapaihang_testcase13() throws Exception {
		//进入降价排行页面
		XinChe.enterJiangJiaPaiHangPage(driver);
		//点击第一条数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击询底价
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");
		//检查进入询底价页面
		Assert.assertTrue(Common.checkTextExist(driver, "询底价")&&Common.checkTextExist(driver,"提交"),"检查进入询底价页面");
		//返回首页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
		Common.multiBack(driver, 2);
	}

}

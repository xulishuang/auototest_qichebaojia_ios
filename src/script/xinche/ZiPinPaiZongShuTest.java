package script.xinche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import common.Common;
import models.FaXian;
import models.WoDe;
import models.XinChe;
import script.AppTestSuite;

public class ZiPinPaiZongShuTest extends AppTestSuite {
	
	/** 
	 * 图片-颜色、车款筛选以及切换标签
	 * 
	 */	
	@Test(priority = 1)
	public void xinche_zipinpaizongshu_testcase1() throws Exception {
//		//进入子品牌综述页
//		XinChe.enterZongShuPage(driver);
//		//检查进入子品牌综述页面
//		Assert.assertTrue(Common.checkTextExist(driver,"询底价"), "进入子品牌综述页面");
//		//点击图片（默认外观标签）
//		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIAButton[1]");
//		//点击颜色，选择颜色
//		
//		//检查进入颜色筛选结果页
//		
//		//点击车款，选择车款
//		
//		//检查进入车款筛选结果页
//		
//		//切换到图解（或官方）标签下
//		
//		//返回首页
		
	}
	
	/** 
	 * 油耗-页面跳转
	 * 
	 */	
	@Test(priority = 2)
	public void xinche_zipinpaizongshu_testcase2() throws Exception { 
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击油耗
		Common.touchText(driver,"油耗");
		//检查进入油耗页面
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
		Assert.assertEquals(text, "油耗","enter official fuel page");
		//返回首页
		Common.multiBack(driver, 2);
		Common.swipeToRight(driver, 500, 1);
	}
	
	/** 
	 * 参数配置-收藏车款、取消车款
	 * 
	 */
	@Test(priority = 3)
	public void xinche_zipinpaizongshu_testcase3() throws Exception{
	  //清空车款收藏
	  WoDe.setCarCollectionEmpty(driver);
	  //进入子品牌综述页
	  XinChe.enterZongShuPage(driver);
	  //点击参数配置
	  Common.touchText(driver,"参数");
	  //检查进入参数配置页
	  Assert.assertTrue(Common.checkTextExist(driver, "参数配置"),"进入参数配置页面");
	  //点击收藏车款
//	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	  Common.touchText(driver, "para unfavor");
	  //检查显示已收藏
	  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[3]"));
	  Assert.assertEquals(text, "已收藏", "检查显示已收藏");
	  //返回到新车
	  Common.multiBack(driver, 2);
	  Common.swipeToRight(driver, 500, 1);
	  Common.swipeToDown(driver, 500, 1);
	  //进入新车-车型收藏-车款页面
	  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
	  Common.touchText(driver,"车款");
	  //检查车款收藏有数据
	  Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车款收藏有数据");
	  Common.back(driver);
	  //再次进入参数配置页面
	  XinChe.enterZongShuPage(driver);
	  Common.touchText(driver, "参数");
	  //点击已收藏
//	  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	  Common.touchText(driver, "para favor");
	  //检查显示收藏车款
	  String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[3]"));
	  Assert.assertEquals(text1, "收藏车款", "检查显示收藏车款");
	  ///返回到新车
	  Common.multiBack(driver, 2);
	  Common.swipeToRight(driver, 500, 1);
	  Common.swipeToDown(driver, 500, 1);
	  //进入新车-车型收藏-车款页面
	  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]");
	  Common.touchText(driver,"车款");
	  //检查车款收藏无数据
	  Assert.assertTrue(Common.checkXpathNotExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车款收藏无数据");
	  //返回首页
	  Common.back(driver);
	}
	
	/** 
	 * 参数配置-询底价
	 * 
	 */
	@Test(priority = 4)
	public void xinche_zipinpaizongshu_testcase4() throws Exception{
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击参数配置
		Common.touchText(driver,"参数");
		//检查进入参数配置页
		Assert.assertTrue(Common.checkTextExist(driver, "参数配置"),"进入参数配置页面");
		//点击询底价
		Common.touchText(driver, "询底价");
		//检查进入一键询价页
		Assert.assertTrue(Common.checkTextExist(driver, "询底价"),"进入询底价页面");
		//返回首页
		Common.close(driver);
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);	
	}
	
	/** 
	 * 参数配置-隐藏相同项
	 * 
	 */
	@Test(priority = 5)
	public void xinche_zipinpaizongshu_testcase5() throws Exception{
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击参数配置
		Common.touchText(driver,"参数");
		//检查进入参数配置页
		Assert.assertTrue(Common.checkTextExist(driver, "参数配置"),"进入参数配置页面");
		//点击隐藏相同项
		Common.touchText(driver, "hide car parameters");
		//点击取消隐藏
		Common.touchText(driver, "show car parameters");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 参数配置-分类定位
	 * 
	 */	
	@Test(priority = 6)
	public void xinche_zipinpaizongshu_testcase6() throws Exception {
		//进入子品牌综述页面
		XinChe.enterZongShuPage(driver);
		//点击参数配置
		Common.touchText(driver,"参数");
		//点击分类
		Common.touchText(driver, "分类");
		//点击某项：灯光
		Common.touchText(driver,"灯光");
		//检查列表定位到该项
		Assert.assertTrue(Common.checkTextExist(driver,"前照灯类型"),"Lighting");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 参数配置-参数筛选
	 * 
	 */	
	@Test(priority = 7)
	public void xinche_zipinpaizongshu_testcase7() throws Exception {
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击参数配置
		Common.touchText(driver,"参数");
		//点击筛选
		Common.touchText(driver,"筛选");
//		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
		//选择年款:2017
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"), "2017 year is checked");
		//选择变速箱:手动
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]");
		Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]"), "manual is checked");
	  	//选择发动机:1.8L
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]");
		Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]"), "1.8L is checked");
		//点击重置
		Common.touchText(driver, "重置");
		Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"), "2017 year is not checked");
		Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]"), "manual is not checked");
		Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]"), "1.8L is not checked");
		//再次勾选年款、变速箱、发动机
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]");
		//点击确定
		Common.touchText(driver, "确定");
		//检查收起筛选，进入参数配置页面
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
		Assert.assertEquals(text, "参数配置","enter parameter configuration page");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	
	/** 
	 * 
	 * 
	 */
	@Test(priority = 8)
	public void xinche_zipinpaizongshu_testcase8() throws Exception{ 
	
  }
  
	/** 
	 * 
	 * 
	 */
	@Test(priority = 9)
	public void xinche_zipinpaizongshu_testcase9() throws Exception{
		
	}
	
	/** 
	 * 
	 * 
	 */
	@Test(priority = 10)
	public void xinche_zipinpaizongshu_testcase10() throws Exception{ 
	
  }
  
	/** 
	 * 
	 * 
	 */
	@Test(priority = 11)
	public void xinche_zipinpaizongshu_testcase11() throws Exception{
		
	}
	
	/** 
	 * 询底价-提交功能
	 * 
	 */	
	@Test(priority = 12)
	public void xinche_zipinpaizongshu_testcase12() throws Exception { 
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击询底价
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIAButton[5]");
		//车款选择项
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//点击年款选择项
//		Common.touchXpath(driver,"");
		//选择车款
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
		//输入姓名与手机号
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"),"小红");
		Common.sendText(driver, By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[2]"),"13666666666");
		//城市选项
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
		//点击城市选项,选择城市
		Common.touchText(driver, "北京");
		//选择经销商，默认选择3个经销商
		
		//勾选其他经销商（最多勾选5个），点击已勾选的经销商，则取消勾选
		
		//切换到询价多标签下
		
		//切换到距离近标签下
		
		//返回首页
		Common.close(driver);
		Common.back(driver);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 车款列表-页面跳转
	 * 
	 */
	@Test(priority = 13)
	public void xinche_zipinpaizongshu_testcase13() throws Exception{ 
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//切换年款
		
		//点击车款
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		Assert.assertTrue(Common.checkTextExist(driver,"dealer paixu nor"), "进入车款详情页");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 车款列表-加入对比
	 * 
	 */
	@Test(priority = 14)
	public void xinche_zipinpaizongshu_testcase14() throws Exception{
		//清除车型对比中已有车型
		FaXian.setContrastCarsEmpty(driver);
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击加入对比
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//检查显示红点
		
		//点击PK对比
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
		Assert.assertTrue(Common.checkXpathExist(driver," //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]"), "Add successfully");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 车款列表-购车计算器
	 * 
	 */
  
	@Test(priority = 15)
	public void xinche_zipinpaizongshu_testcase15() throws Exception{
	 	//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击购车计算器
		Common.touchText(driver, "计算");
		//检查进入购车计算器结果页
		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "car calculation result page");
		//返回首页
		Common.multiBack(driver,2);
		Common.swipeToRight(driver, 500, 1);
  }
	
	/** 
	 * 车款列表-询底价
	 * 
	 */
  
	@Test(priority = 16)
	public void xinche_zipinpaizongshu_testcase16() throws Exception{  
		//进入子品牌综述页
		XinChe.enterZongShuPage(driver);
		//点击询底价
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		//检查进入一键询价页
		Assert.assertTrue(Common.checkTextExist(driver,"询底价")&&Common.checkTextExist(driver, "提交"),"enter xundijia page");
		//返回首页
		Common.close(driver);
		Common.back(driver);
		Common.swipeToRight(driver, 500, 1);
	}

}

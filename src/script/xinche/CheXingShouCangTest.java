package script.xinche;

import common.Common;
import models.ErShouChe;
import models.WoDe;
import models.XinChe;
import script.AppTestSuite;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheXingShouCangTest extends AppTestSuite{
	
	/** 
	 * 车型收藏为空
	 *  
	 */
	@Test
	public void xinche_chexingshoucang_testcase1()  {
		//清空车型收藏
		WoDe.setModelsCollectionEmpty(driver);
		//清空浏览历史
		WoDe.setModelsBrowseEmpty(driver);
		//进入车型收藏
		XinChe.enterCheXingShouCangPage(driver);
		//检查车型收藏为空
		Assert.assertFalse(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车型收藏为空");
		//返回首页
		Common.back(driver);
	}
	
	/** 
	 * 车型收藏有数据
	 *  
	 */
 	@Test(priority = 2)
 	public void xinche_chexingshoucang_testcase2()  {
 		//收藏车型
 		XinChe.collectModels(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//检查车型收藏有数据
 		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车型收藏有数据");
 		//点击车型数据，进入车型综述页面
 		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
 		Assert.assertTrue(Common.checkTextExist(driver, "询底价"), "check open zongshu page is normal");  
 		//返回首页
 		Common.multiBack(driver, 2);
 	}
 	
 	/** 
	 * 浏览历史为空
	 *  
	 */
 	@Test(priority = 3)
 	public void xinche_chexingshoucang_testcase3() {
 		//清空浏览历史
 		WoDe.setModelsBrowseEmpty(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
	  	//检查无浏览记录
	  	Assert.assertTrue(Common.checkTextNotExist(driver,"浏览历史"), "检查无浏览记录");
	  	//返回首页
	  	Common.back(driver);
 	}
 	
 	/** 
	 * 浏览历史有数据
	 *  
	 */
 	@Test(priority = 4)
 	public void xinche_chexingshoucang_testcase4() {
 		//浏览车型
 		Common.touchText(driver,"新车");
 		Common.touchText(driver,"奥迪");
 		Common.touchText(driver,"奥迪Q5");
 		Common.back(driver);
 		Common.swipeToRight(driver, 500, 1);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
	  	//检查有浏览记录
	  	Assert.assertTrue(Common.checkTextExist(driver,"浏览历史"), "检查有浏览记录");
	  	//返回首页
	  	Common.back(driver);
  }
 	
 	/** 
	 * 二手车收藏为空
	 *  
	 */
 	@Test(priority = 5)
 	public void xinche_chexingshoucang_testcase5()  {
 		//清空二手车收藏
 		WoDe.setUsedCarCollectionEmpty(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击二手车
 		Common.touchText(driver,"二手车");
 		//检查二手车收藏为空
 		Assert.assertTrue(Common.checkTextExist(driver,"暂无收藏相关二手车"), "检查二手车收藏为空");
 		//返回首页
 		Common.back(driver);
 	}
 	
 	/** 
	 * 二手车收藏有数据
	 *  
	 */
 	@Test(priority = 6)
 	public void xinche_chexingshoucang_testcase6()  {
 		//收藏二手车
 		ErShouChe.collectUsedCar(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击二手车
 		Common.touchText(driver,"二手车");
 		//检查二手车收藏有数据
 		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查二手车收藏有数据");
 		//返回首页
 		Common.back(driver);		
 	}
 	
 	/** 
	 * 经销商列表为空
	 *  
	 */  
 	@Test(priority = 7)
 	public void xinche_chexingshoucang_testcase7()  {
 		//清空经销商收藏
 		WoDe.setDealersCollectionEmpty(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击经销商
 		Common.touchText(driver,"经销商");
 		//检查经销商收藏为空
 		Assert.assertTrue(Common.checkTextExist(driver,"暂无收藏相关经销商"), "检查经销商收藏为空");
 		//返回首页
 		Common.back(driver);
  }
 	
 	/** 
	 * 经销商列表有数据
	 *  
	 */
 	@Test(priority = 8)
 	public void xinche_chexingshoucang_testcase8()  {
 		//收藏经销商
 		XinChe.collectDealers(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击经销商
 		Common.touchText(driver,"经销商");
 		//检查经销商收藏有数据
 		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查经销商收藏有数据");
 		//返回首页
 		Common.back(driver);
 	}
 	
 	/** 
	 * 车款列表为空
	 *  
	 */
 	@Test(priority = 9)
 	public void xinche_chexingshoucang_testcase9()  {
 		//清空车款收藏
 		WoDe.setCarCollectionEmpty(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击车款
 		Common.touchText(driver,"车款");
 		//检查车款收藏为空
 		Assert.assertTrue(Common.checkTextExist(driver,"暂无收藏相关车款"), "检查车款收藏为空");
 		//返回首页
 		Common.back(driver);
 	}
 	
 	/** 
	 * 车款列表有数据
	 *  
	 */
 	@Test(priority = 10)
 	public void xinche_chexingshoucang_testcase10()  {
 		//进行车款收藏
 		XinChe.collectCars(driver);
 		//进入车型收藏
 		XinChe.enterCheXingShouCangPage(driver);
 		//点击车款
 		Common.touchText(driver,"车款");
 		//检查车款收藏有数据
 		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车款收藏有数据");
 		//返回首页
 		Common.back(driver);
  }

}

package script.wode;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import script.AppTestSuite;
import common.*;
import models.ErShouChe;
import models.WoDe;
import models.XinChe;

public class CheXingShouCangTest extends AppTestSuite{
	
	/**
	 * @ 
	 * @function 车型-添加车型
	 */
	@Test(priority = 1)
	public void wode_chexingshoucang_testcase1()  {
		//清空车型收藏
		WoDe.setModelsCollectionEmpty(driver);
		//进入我的-车型收藏-添加车型
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "添加车型");
		Common.touchText(driver, "奥迪");
		Common.touchText(driver, "奥迪Q5");
		//检查车型收藏添加车型成功
		Assert.assertTrue(Common.checkTextExist(driver, "车型收藏")&&Common.checkTextExist(driver, "奥迪Q5"), "检查车型收藏添加车型成功");
        //返回首页
		Common.back(driver);
	}
	
	/**
	 * @ 
	 * @function 车型-查看车型
	 * @precondition 接续testcase1
	 */
	@Test(priority = 2)
	public void wode_chexingshoucang_testcase2()  {
		//进入车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		//点击车型数据
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入车型综述页面
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("综述")),"检查进入车型综述页面");
		//返回首页
		Common.multiBack(driver,2);
	}
	
	/**
	 * @function 车型-删除车型
	 * @precondition 接续testcase1
	 */
	@Test(priority = 3)
	public void wode_chexingshoucang_testcase3() {
		//进入车型收藏
		Common.touchText(driver,"我的");
		Common.touchText(driver, "车型收藏");
		//删除车型
		Common.touchTopRight(driver);//点击编辑
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");//点击-号
		Common.touchText(driver, "删除");//点击删除
		//检查车型删除成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无收藏相关车型")&&Common.checkTextExist(driver, "添加车型"), "成功返回到车型收藏页，删除成功！");
        //返回首页
		Common.back(driver);
	}
	
	/**
	 * @function 车款-添加车款
	 * @
	 */
	@Test(priority = 4)
	public void wode_chexingshoucang_testcase4() {
		//清空车款
		WoDe.setCarCollectionEmpty(driver);
		//添加车款收藏
		XinChe.collectCars(driver);
		//进入车型收藏-车款列表查看
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "车款");
		//检查车款收藏成功
		Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查车款收藏成功");
		//返回首页
		Common.back(driver);
	}
	
	/**
	 * @ 
	 * @function 车款-查看车款
	 * 
	 */
	@Test(priority = 5)
    public void wode_chexingshoucang_testcase5()  {
		//进入车型收藏-车款列表查看
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "车款");	
		//点击车款数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入车款最新报价页面
		Assert.assertTrue(Common.checkTextExist(driver, "dealer paixu nor"), "检查进入车款最新报价页面");
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 车款-删除车款
	 */
	@Test(priority = 6)
    public void wode_chexingshoucang_testcase6() {
		//进入我的-车型收藏-车款
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "车款");
		//删除车款
		Common.touchTopRight(driver);//点击编辑
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");//点击-号
		Common.touchText(driver, "删除");//点击删除	
		//检查删除车款成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无收藏相关车款"), "检查删除车款成功");
		//返回首页
		Common.back(driver);
	}
	
	/**
	 * @function 经销商-添加经销商
	 * @
	 */
	@Test(priority = 7)
	public void wode_chexingshoucang_testcase7() {
		//清空经销商
		WoDe.setDealersCollectionEmpty(driver);
		//添加经销商收藏
		XinChe.collectDealers(driver);
		//进入我的-车型收藏-经销商列表查看
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "经销商");
		//检查经销商收藏成功
		Assert.assertTrue(Common.checkXpathExist(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查经销商收藏成功");
		//返回首页
		Common.back(driver);
	}
	
	/**
	 * @ 
	 * @function 经销商-查看经销商数据
	 * @precondition 接续testcase7
	 */
	@Test(priority = 8)
	public void wode_chexingshoucang_testcase8() {
		//进入我的-车型收藏-经销商
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "经销商");
		//点击经销商数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入经销商详情页面
		Assert.assertTrue(Common.checkTextExist(driver, "促销信息"), "检查进入经销商详情页面");
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 二手车-删除经销商数据
	 * @precondition 接续testcase7
	 */
	@Test(priority = 9)
	public void wode_chexingshoucang_testcase9(){
		//进入我的-车型收藏-经销商
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "经销商");
		//删除经销商收藏
		Common.touchTopRight(driver);//点击编辑
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");//点击-号
		Common.touchText(driver, "删除");//点击删除	
		//检查删除经销商成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无收藏相关经销商"), "检查删除经销商成功");
		//返回首页
		Common.back(driver);
	}
	
	/**
	 * @ 
	 * @function 二手车-添加二手车
	 */
	@Test(priority = 10)
	public void wode_chexingshoucang_testcase10() {
		//清空二手车
		WoDe.setUsedCarCollectionEmpty(driver);
		//添加二手车收藏
		ErShouChe.collectUsedCar(driver);
		//查看我的-车型收藏-二手车列表
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "二手车");
		//检查二手车收藏成功
		Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"),"检查二手车收藏成功");
		//返回首页	
		Common.back(driver);
	}
		
	/**
	 * @function 二手车-查看二手车数据
	 * @ 
	 */
	@Test(priority = 11)
	public void wode_chexingshoucang_testcase11() {
		//查看我的-车型收藏-二手车列表
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "二手车");
		//检查二手车收藏成功
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入车源详情页面
		Assert.assertTrue(Common.checkTextExist(driver, "车源详情"), "检查进入车源详情页面");
		//返回首页
		Common.multiBack(driver,2);
	}
		
	/**
	 * @function 二手车-删除二手车
	 */
	@Test(priority = 12)
	public void wode_chexingshoucang_testcase12(){
		//进入我的-车型收藏-经销商
		Common.touchText(driver, "我的");
		Common.touchText(driver, "车型收藏");
		Common.touchText(driver, "二手车");
		//删除二手车收藏
		Common.touchTopRight(driver);//点击编辑
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");//点击-号
		Common.touchText(driver, "删除");//点击删除	
		//检查删除二手车成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无收藏相关二手车"), "检查删除二手车成功");
		//返回首页
		Common.back(driver);
		}
			
}
	

	
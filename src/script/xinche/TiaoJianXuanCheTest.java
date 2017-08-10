package script.xinche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import common.Common;
import models.XinChe;
import script.AppTestSuite;

public class TiaoJianXuanCheTest extends AppTestSuite{
	
	@Test(priority = 1)
	public void xinche_tiaojianxuanche_testcase1() throws Exception {
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//点击重置
	    Common.touchTopRight(driver);
	    //点击小型车、日系、合资
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]");
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[33]");
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[40]");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]"), "check whether xiaoxingche is selected");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[33]"), "check whether rixi is selected");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[40]"), "check whether hezi is selected");
	    //点击搜索结果，进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    Assert.assertTrue(Common.checkTextExist(driver, "选车结果"), "check whether to enter the result page");
	    //返回首页
	    Common.multiBack(driver, 2);
	  }
	
	@Test(priority = 2)
	  public void xinche_tiaojianxuanche_testcase2() throws Exception {
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
	    //点击更多选车条件
		Common.swipeToUp(driver, 500, 1);
		Common.touchText(driver, "更多选车条件");
		//选择更多条件
		Common.touchText(driver, "手动挡");
		Common.touchText(driver, "三厢轿车");
		Common.touchText(driver, "1.3L以下");
		Common.touchText(driver, "汽油");
		Common.touchText(driver, "前驱");
		Common.touchText(driver, "自然吸气");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("手动挡")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("三厢轿车")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("1.3L以下")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("汽油")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("前驱")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("自然吸气")),"选中");
		Common.swipeToUp(driver, 500, 1);
		Common.touchText(driver, "国5");
		Common.touchText(driver, "4-5座");
		Common.swipeToUp(driver, 500, 1);
	    Common.touchText(driver, "儿童锁");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("国5")),"选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("4-5座")),"选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("儿童锁")),"选中");
	    //点击搜索结果，进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    Assert.assertTrue(Common.checkTextExist(driver, "选车结果"), "check whether to enter the result page");
	    //返回首页
	    Common.multiBack(driver, 2);
	  }
	
	@Test(priority = 3)
	public void xinche_tiaojianxuanche_testcase3() throws Exception{
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//点击更多选车条件
		Common.swipeToUp(driver, 500, 1);
		Common.touchText(driver, "更多选车条件");
		//选中儿童锁
		Common.swipeToUp(driver, 500, 1);
		Common.touchText(driver, "儿童锁");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("儿童锁")), "check whether ertongsuo is selected");
		//点击清空配置
	    Common.touchText(driver, "清除配置");
	    Assert.assertFalse(Common.checkIsSelected(driver, By.name("儿童锁")), "check whether ertongsuo is not selected");
		//返回首页
	    Common.back(driver);
	  }
	
	@Test(priority = 4)
	public void xinche_tiaojianxuanche_testcase4() throws Exception{
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//点击更多选车条件
		Common.swipeToUp(driver, 500, 1);
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[45]");
		//选择更多条件
		Common.touchText(driver, "手动挡");
		Common.touchText(driver, "三厢轿车");
		Common.touchText(driver, "1.3L以下");
		Common.touchText(driver, "汽油");
		Common.touchText(driver, "前驱");
		Common.touchText(driver, "自然吸气");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("手动挡")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("三厢轿车")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("1.3L以下")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("汽油")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("前驱")),"选中");
		Assert.assertTrue(Common.checkIsSelected(driver, By.name("自然吸气")),"选中");
		Common.swipeToUp(driver, 500, 1);
		Common.touchText(driver, "国5");
		Common.touchText(driver, "4-5座");
	    Common.touchText(driver, "儿童锁");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("国5")),"选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("4-5座")),"选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("儿童锁")),"选中");
	    //点击收起后再次点击更多选车条件   
	    Common.touchText(driver, "收起");
	    Common.swipeToUp(driver, 500, 1);
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[45]"); 
        Assert.assertFalse(Common.checkIsSelected(driver, By.name("手动挡")),"不选中");
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("三厢轿车")),"不选中");
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("1.3L以下")),"不选中");
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("汽油")),"不选中");
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("前驱")),"不选中");
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("自然吸气")),"不选中");
		Common.swipeToUp(driver, 500, 1);
		Assert.assertFalse(Common.checkIsSelected(driver, By.name("国5")),"不选中");
	    Assert.assertFalse(Common.checkIsSelected(driver, By.name("4-5座")),"不选中");
	    Assert.assertFalse(Common.checkIsSelected(driver, By.name("儿童锁")),"不选中");
	    //返回首页 
	    Common.back(driver); 
	  }
	
	@Test(priority = 5)
	public void xinche_tiaojianxuanche_testcase5() throws Exception{  
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//点击重置
	    Common.touchTopRight(driver);
	    //点击小型车、日系、合资
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]");
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[33]");
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[40]");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]"), "选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[33]"), "选中");
	    Assert.assertTrue(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[40]"), "选中");  	
	    //点击重置
//	    Common.touchText(driver, "重置");
	    Common.touchTopRight(driver);
	   //点击重置
	    Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]"), "不选中");
	    Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[33]"), "不选中");
	    Assert.assertFalse(Common.checkIsSelected(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[40]"), "不选中");  	
	    //返回首页
	    Common.back(driver);  
	  }
	
	@Test(priority = 6)
	public void xinche_tiaojianxuanche_testcase6() throws Exception {
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    //检查进入最畅销页面
	    Assert.assertTrue(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")),"最畅销");
	    //返回首页
	    Common.multiBack(driver,2);
	  }
	
	@Test(priority = 7)
	public void xinche_tiaojianxuanche_testcase7() throws Exception {
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    //点击最贵
		Common.touchText(driver,"最贵");
		//检查进入最贵页面
		Assert.assertTrue(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]")),"最贵");
	    //返回首页
	    Common.multiBack(driver,2);
	  }
	
	@Test(priority = 8)
	public void xinche_tiaojianxuanche_testcase8() throws Exception {
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		//进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    //点击最便宜
		Common.touchText(driver,"最便宜");
		//检查进入最便宜页面
		Assert.assertTrue(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]")),"最便宜");
	    //返回首页
	    Common.multiBack(driver,2);
	  }
	
	@Test(priority = 9)
	public void xinche_tiaojianxuanche_testcase9() throws Exception{  
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		Common.touchTopRight(driver);
		//进入结果页面
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	    //点击某一车型
	    Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]");
	    //检查进入车型综述页面
	    Assert.assertTrue(Common.checkTextExist(driver, "综述"), "check whether to enter zongshu page");
	    Assert.assertTrue(Common.checkTextExist(driver, "询底价"), "check open zongshu page is normal");  
	    //返回首页
	    Common.multiBack(driver,3);
	  }
	
	@Test(priority = 10)
	public void xinche_tiaojianxuanche_testcase10() throws Exception{  
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		Common.touchTopRight(driver);
		//进入结果页面
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//点击某一车型
	    Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]");
	    //检查进入车型综述页面
	    Assert.assertTrue(Common.checkTextExist(driver, "综述"), "check whether to enter zongshu page");
	    Assert.assertTrue(Common.checkTextExist(driver, "询底价"), "check open zongshu page is normal");  
	    //点击某一车款
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
	    //检查进入车款详情页面
	    Assert.assertTrue(Common.checkTextExist(driver, "dealer paixu nor"), "check whether to enter 最新报价 page");
	    Assert.assertTrue(Common.checkTextExist(driver, "询底价"), "check open zongshu page is normal"); 
	    //返回首页
	    Common.multiBack(driver, 4);
	  }
	
	/** 
	 * 结果页-引导提示：二手车
	 * 预期条件级别、变速箱、排量可以带到二手车的筛选条件中
	 */	
	@Test(priority = 11)
	public void xinche_tiaojianxuanche_testcase11() throws Exception{  
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
	    Common.touchTopRight(driver);
	    //选择小型车、手动挡、排量1.3L以下
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]");
	    Common.swipeToUp(driver, 500, 1);
	    //点击更多选择条件
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[45]");
	    Common.touchText(driver, "手动挡");
	    Common.touchText(driver, "1.3L以下");
	    //进入结果页面
	  	Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");		  
	    //点击“快来看看”
	    Common.touchSlideXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIAButton[1]",10);
	    //检查进入二手车页面，检查筛选条件中已选中小型车、手动挡和排量1.3L以下，检查价格区间自定义显示0-5万
	    Assert.assertTrue(Common.checkTextExist(driver, "二手车"), "Enter ershouche page");
	    //点击筛选标签
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[3]");
	    //检查小型车、手动挡、排量1.3L以下已选中
	    Assert.assertTrue(Common.checkIsSelected(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[12]")), "landaulet is selected");
	    Common.swipeToUp(driver, 500, 1);
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("手动挡")), "manual is selected");
	    Common.swipeToUp(driver, 500, 1);
	    Assert.assertTrue(Common.checkIsSelected(driver, By.name("1.3L以下")), "manual is selected");
	    //返回首页
	    Common.multiBack(driver, 3);  
  }
	
	/** 
	 * 结果页-引导提示：发帖问网友
	 * 
	 */	
	@Test(priority = 12)
	public void xinche_tiaojianxuanche_testcase12() throws Exception{  
		//进入条件选车
		XinChe.enterTiaoJianXuanChePage(driver);
		Common.touchTopRight(driver);
		//进入结果页面
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//点击“发帖问问网友"
		Common.touchSlideXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIAButton[2]", 10);
		//检查进入发表话题页面
		Assert.assertTrue(Common.checkTextExist(driver, "发表话题"),"进入发表话题页面");
		//返回首页
		Common.multiBack(driver, 3);
  }

}

package script.wode;
  
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;
import models.WoDe;

public class BrowserHistoryTest extends AppTestSuite {
	  /**
	   * @function 车型-浏览历史
	   * @
	   */
	  @Test(priority=1)
	  public void wode_browserhistory_testcase1() {
		  //清空车型浏览历史
		  WoDe.setModelsBrowseEmpty(driver);
		  //进入新车，点击某品牌车型
		  Common.touchText(driver,"新车");
		  Common.touchText(driver,"奥迪");
		  Common.touchText(driver,"奥迪Q5");
		  Common.back(driver);
		  //进入我的-浏览历史
		  Common.touchText(driver, "我的");
		  Common.touchText(driver, "浏览历史");
		  //检查浏览历史显示车型成功
		  Assert.assertTrue(Common.checkTextExist(driver, "奥迪Q5")&&Common.checkTextExist(driver, "浏览历史"), "检查浏览历史显示车型成功");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /**
	   * @function 车型-清空浏览历史
	   * @precondition 接续testcase1
	   * @
	   */
	  @Test(priority=2)
	  public void wode_browserhistory_testcase2() {
		  //清空车型浏览历史
		  WoDe.setModelsBrowseEmpty(driver);
		  //进入浏览历史
		  Common.touchText(driver, "浏览历史");
		  //检查清空成功
		  Assert.assertTrue(Common.checkTextExist(driver,"您现在还没有浏览任何车型,")&&Common.checkTextExist(driver,"请前往车型页浏览吧！"), "检查清空成功");
		  //返回首页
		  Common.back(driver);
	  }
	  
	 /**
	  * @function 经销商-浏览历史
	  * @
	  */
	  @Test(priority = 3)
	  public void wode_browserhistory_testcase3() {
		  //清空经销商浏览历史
		  WoDe.setDealersBrowseEmpty(driver);
		  //添加经销商浏览历史
		  Common.touchText(driver, "新车");
		  Common.touchText(driver, "奥迪");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
		  Common.touchText(driver, "经销商");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //返回，进入我的-浏览历史-经销商，查看记录
		  Common.multiBack(driver, 2);
		  Common.touchText(driver, "我的");
		  Common.touchText(driver, "浏览历史");
		  Common.touchText(driver, "经销商");
		  //检查有浏览历史
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		  Assert.assertFalse(text.equals("您现在还没有浏览任何经销商,"), "检查有浏览历史");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /**
	   * @function 清空经销商浏览历史
	   * @
	   */
	  @Test(priority = 4)
	  public void wode_browserhistory_testcase4() {
		  //清空经销商浏览历史
		  WoDe.setDealersBrowseEmpty(driver);
		  //进入浏览历史
		  Common.touchText(driver, "浏览历史");
		  Common.touchText(driver, "经销商");
		  //检查清空成功
		  Assert.assertTrue(Common.checkTextExist(driver,"您现在还没有浏览任何经销商,")&&Common.checkTextExist(driver,"请前往经销商页浏览吧！"), "检查清空成功");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /**
	   * 添加降级浏览历史
	   */
	  @Test(priority = 5)
	  public void wode_browserhistory_testcase5() {
		  //清空降价浏览历史
		  WoDe.setCutsBrowseEmpty(driver);
		  //添加降价浏览历史
		  Common.touchText(driver,"新车");
		  Common.touchText(driver,"奥迪");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
		  Common.touchText(driver, "降价");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");	  
		  //进入我的-浏览历史-降价查看
		  Common.multiBack(driver,2);
		  Common.touchText(driver, "我的");
		  Common.touchText(driver, "浏览历史");
		  Common.touchText(driver, "降价");
		  //检查有浏览历史
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		  Assert.assertFalse(text.equals("您现在还没有浏览任何降价,"), "检查有浏览历史");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /**
	   * @function 清空降价浏览历史
	   * @
	   */
	  @Test(priority = 6)
	  public void wode_browserhistory_testcase6() {
		  //清空降价浏览历史
		  WoDe.setCutsBrowseEmpty(driver);
		  //进入浏览历史
		  Common.touchText(driver, "浏览历史");
		  Common.touchText(driver, "降价");
		  //检查清空成功
		  Assert.assertTrue(Common.checkTextExist(driver,"您现在还没有浏览任何降价,")&&Common.checkTextExist(driver,"请前往降价页浏览吧！"), "检查清空成功");
		  //返回首页
		  Common.back(driver);
	  }
}

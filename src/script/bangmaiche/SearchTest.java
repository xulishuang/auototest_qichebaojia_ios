package script.bangmaiche;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import script.AppTestSuite;

public class SearchTest extends AppTestSuite{
	
	 /** 
		 * 社区搜索
		 * 
		 */	
	@Test(priority=1)
	public void bangmaiche_search_testcase1(){
		//进入社区搜索页
		Common.touchText(driver, "帮买车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//搜索页取消操作
		Common.touchText(driver, "取消");
		Assert.assertTrue(Common.checkTextExist(driver, "推荐"), "取消操作正常！");
		//输入社区搜索关键字
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]"), "猜车");
		//清除社区搜索关键字
		Common.touchText(driver, "清除文本");
		//判断关键字是否清除成功
		Assert.assertTrue(Common.checkTextNotExist(driver, "猜车"),"清除成功");
		//输入社区搜索关键字
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]"), "猜车");
		Common.touchText(driver, "搜索“猜车”相关内容");
		//判断是否进入搜索结果页
		Assert.assertTrue(Common.checkTextExist(driver, "相关用户"), "成功进入搜索结果页!");
		//搜索结果页取消
		Common.touchText(driver, "取消");
		Assert.assertTrue(Common.checkTextExist(driver, "猜车"),"取消逻辑正常！");
		//输入社区搜索关键字
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]"), "有奖竞猜");
		//联想词链接跳转
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
		Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "成功进入话题详情页！");
		Common.multiBack(driver, 2);
	}
	
	/** 
	 * 社区搜索页-大家都在搜
	 * 
	 */	
	@Test(priority=2)
	public void bangmaiche_search_testcase2(){
		//进入社区搜索页
		Common.touchText(driver, "帮买车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//大家都在搜 跳转
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//判断是否进入搜索结果页
		Assert.assertTrue(Common.checkTextExist(driver, "相关用户"), "成功进入搜索结果页!");
		Common.touchText(driver, "取消");
		Common.touchText(driver, "取消");
	}
		
	/** 
	 * 社区搜索结果页-相关用户与相关帖子
	 * 
	 */	
	@Test(priority=3)
	public void bangmaiche_search_testcase3(){
		//进入社区搜索页
		Common.touchText(driver, "帮买车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//输入社区搜索关键字
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]"), "活动");
		Common.touchText(driver, "搜索");
		//进入相关用户列表
		Common.touchText(driver, "更多");
		Assert.assertTrue(Common.checkTextExist(driver, "相关用户"), "进入相关用户列表");
		//点击用户头像，进入个人主页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.back(driver);
		//+关注
		Common.touchText(driver, "myAttention guanzhu nor");
		Assert.assertTrue(Common.checkTextExist(driver, "myAttention ygz nor"), "+关注成功！");
		//取消关注
		Common.touchText(driver, "myAttention ygz nor");
		Assert.assertTrue(Common.checkTextNotExist(driver, "myAttention ygz nor"), "取消关注成功");
		Common.back(driver);
		//相关帖子跳转
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]");
		Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "成功进入话题详情页！");
		Common.back(driver);
		//进个人主页
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]");
		Common.multiBack(driver, 3);

	}
	
	/** 
	 * 社区搜索页-清空
	 * 
	 */	
	@Test(priority=4)
	public void bangmaiche_search_testcase4(){
		//进入社区搜索页
		Common.touchText(driver, "帮买车");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		//清空
		Common.touchText(driver, "清空");
		Assert.assertTrue(Common.checkTextNotExist(driver, "搜索历史"), "搜索历史清空成功！");
		Common.back(driver);
	}

	
}
	
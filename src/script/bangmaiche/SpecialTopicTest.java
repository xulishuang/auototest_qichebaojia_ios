package script.bangmaiche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import script.AppTestSuite;

public class SpecialTopicTest extends AppTestSuite{
	
	/** 
	 * 专题列表预览
	 * 
	 */	
	@Test(priority=1)
	public void bangmaiche_specialtopic_testcase1(){
		//热门榜查看
		Common.touchText(driver, "帮买车");
		Common.touchText(driver, "热门榜");
		Common.touchText(driver, "大神榜");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]");
		Common.back(driver);
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]"));
		if(text=="myAttention ygz nor"){
			Common.touchText(driver, "myAttention ygz nor");
			Assert.assertTrue(Common.checkTextNotExist(driver, "myAttention ygz nor"), "取消关注成功！");
		}
		else {
			Common.touchText(driver, "myAttention guanzhu nor");
			Assert.assertTrue(Common.checkTextExist(driver, "myAttention ygz nor"), "关注成功！");
		}
		Common.touchText(driver, "24小时热帖榜");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.back(driver);
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		Common.multiBack(driver, 2);	
	}
	
	@Test(priority=2)
	public void bangmaiche_specialtopic_testcase2(){
		//进入任意专题列表
		Common.touchText(driver, "今日话题");
		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]"));
		if(text=="specialTopicSubscribe"){
			Common.touchText(driver, "specialTopicSubscribe");
		}
		else{
			Common.touchText(driver, "specialTopicSubscribed");
			Common.touchText(driver, "放弃");
			Common.touchText(driver, "specialTopicSubscribed");
			Common.touchText(driver, "取消订阅");
		}
		Common.touchText(driver, "发帖");
		Common.touchText(driver, "话题");
		Common.touchText(driver, "取消");
		Common.touchText(driver, "发帖");
		Common.touchText(driver, "投票");
		Common.touchText(driver, "取消");
		Common.touchText(driver, "发帖");
		Common.touchText(driver, "文章");
		Common.touchText(driver, "取消");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		Common.back(driver);
		Common.swipeToLeft(driver, 500, 1);
	}
}
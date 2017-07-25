package script.bangmaiche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*; 
import script.AppTestSuite;
import common.*;

public class TopicIconTest extends AppTestSuite{
	
	  /** 
		 * 车型社区-标签页切换
		 * 
		 */	
	  @Test(priority = 1)
	  public void bangmaiche_topicIcon_testcase1() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //检查默认到最新页面
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("最新")), "检查默认到最新页面");
		  //点击精华
		  Common.touchText(driver,"精华");
		  //检查切换到精华页面
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("精华")), "检查切换到精华页面");
		  //点击回复
		  Common.touchText(driver,"回复");
		  //检查切换到回复页面
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("回复")), "检查切换到回复页面");
		  //返回首页
		  Common.multiBack(driver, 2);
	  }
	  
	  /** 
		 * 车型社区-最新-查看车型
		 * 
		 */	
	  @Test(priority = 2)
	  public void bangmaiche_topicIcon_testcase2() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击查看车型
		  Common.touchText(driver, "查看车型");
		  //检查进入车型综述页面
		  Assert.assertTrue(Common.checkIsSelected(driver, By.name("综述")), "检查进入车型综述页面");
		  //返回首页
		  Common.multiBack(driver, 3);
	  }
	    
	  /** 
		 * 车型社区-最新-关注
		 *  预设：车型数据未被关注
		 */	
	  @Test(priority = 3)
	  public void bangmaiche_topicIcon_testcase3() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击关注
		  if(Common.checkTextExist(driver, "myAttention guanzhu nor")){
			  Common.touchText(driver,"myAttention guanzhu nor");
			  //检查显示为已关注
			  Assert.assertTrue(Common.checkTextExist(driver,"myAttention ygz nor"), "检查显示为已关注");
			  //点击击已关注
			  Common.touchText(driver,"myAttention ygz nor");
			  //检查显示关注
			  Assert.assertTrue(Common.checkTextExist(driver,"myAttention guanzhu nor"), "检查显示为关注"); 
		  }else{
			  //点击击已关注
			  Common.touchText(driver,"myAttention ygz nor");
			  //检查显示关注
			  Assert.assertTrue(Common.checkTextExist(driver,"myAttention guanzhu nor"), "检查显示为关注");
			  //点击关注
			  Common.touchText(driver,"myAttention guanzhu nor");
			  //检查显示为已关注
			  Assert.assertTrue(Common.checkTextExist(driver,"myAttention ygz nor"), "检查显示为已关注");
		  }
		  //返回首页
		  Common.multiBack(driver, 2);
	  }
	  
	  /** 
		 * 车型数据-最新-话题详情
		 * 
		 */	
	  @Test(priority = 4)
	  public void bangmaiche_topicIcon_testcase4() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击某一条话题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.multiBack(driver, 3);
	  }
	  
	  /** 
		 * 车型社区-精华-话题详情
		 * 
		 */	
	  @Test(priority = 5)
	  public void bangmaiche_topicIcon_testcase5() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击精华
		  Common.touchText(driver,"精华");
		  //点击某一条话题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.multiBack(driver, 3);
	  }
	  
	  /** 
		 * 车型社区-回复-话题详情
		 * 
		 */	
	  @Test(priority = 6)
	  public void bangmaiche_topicIcon_testcase6() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击回复
		  Common.touchText(driver,"回复");
		  //点击某一条话题
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		  //检查进入话题详情页
		  Assert.assertTrue(Common.checkTextExist(driver, "  说点什么吧...."),"检查进入话题详情页");
		  //返回首页
		  Common.multiBack(driver, 3);
	  }
	  
	  /** 
		 * 关注-有关注
		 * 
		 */	
	  @Test(priority = 7)
	  public void bangmaiche_topicIcon_testcase7() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //选择车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");//选择奥迪A3
		  //点击关注
		  if(Common.checkTextExist(driver, "myAttention guanzhu nor")){
			  Common.touchText(driver, "myAttention guanzhu nor");
		  }
		  Common.back(driver);
		  
		  //点击关注
		  Common.touchText(driver, "关注");
		  //检查显示车社区名称
		  Assert.assertTrue(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"), "检查显示车社区名称");
		  //点击车型社区名称
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
		  //点击已关注
		  Common.touchText(driver,"myAttention ygz nor");
		  //点击返回
		  Common.back(driver);
		  //检查无关注
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]"));
		  Assert.assertTrue(text.contains("暂无关注"), "检查无关注");
		  //返回首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 关注-无关注
		 * 接续testcase7
		 */	
	  @Test(priority = 8)
	  public void bangmaiche_topicIcon_testcase8() throws Exception {
		  //进入车型社区
		  Common.touchText(driver,"帮买车");
		  Common.touchText(driver,"ic fenlei nor");
		  //点击关注
		  Common.touchText(driver, "关注");
		  //检查显示“暂无关注”
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]"));
		  Assert.assertTrue(text.contains("暂无关注"), "检查无关注");
		  //返回首页
		  Common.back(driver);
	  }

}

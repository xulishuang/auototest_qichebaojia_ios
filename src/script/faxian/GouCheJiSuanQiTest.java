package script.faxian;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import models.FaXian;
import script.AppTestSuite;

public class GouCheJiSuanQiTest extends AppTestSuite{
	/** 
	 * 首次进入-默认状态
	 *  
	 */
	@Test(priority = 1)
	public void faxian_gouchejisuanqi_testcase1()  {
		//进入购车计算器
		Common.touchText(driver,"发现");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款页面");
		//返回首页
		Common.back(driver);
		}
	/** 
	 * 全款-选择车款
	 *  
	 */
	@Test(priority = 2)
	public void faxian_gouchejisuanqi_testcase2()  {
		//进入购车计算器
		Common.touchText(driver,"发现");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		//点击重置
		if(Common.checkTextExist(driver,"重置")){
			Common.touchText(driver,"重置");
		}
		//选择车款
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		Common.touchText(driver, "奥迪");
        Common.touchText(driver, "奥迪A4L");
        Common.touchText(driver, "40 TFSI 进取型 Plus");
		//判断进入全款结果页
		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "进入全款计算结果页面");
		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款计算结果页面");
	  
	 	//点击重置，回到全款计算首页
		Common.touchText(driver,"重置");
		//返回首页
		Common.back(driver);
		}
	
	/** 
	 * 全款-裸车价格
	 *  
	 */
	@Test(priority = 3)
	public void faxian_gouchejisuanqi_testcase3()  {
		//进入购车计算器
		Common.touchText(driver,"发现");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		//点击重置
		if(Common.checkTextExist(driver,"重置")){
			Common.touchText(driver,"重置");
		}
		//输入裸车价格，点击计算
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
		Common.touchText(driver, "计算");
		//判断进入全款结果页
		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "进入全款计算结果页面");
		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款计算结果页面");
			  
		//点击重置，回到全款计算首页
		Common.touchText(driver,"重置");
		//返回首页	  
		Common.back(driver);
		}
	
	/** 
	 * 全款结果页-修改结果页参数
	 *  
	 */
 	@Test(priority = 4)
 	public void faxian_gouchejisuanqi_testcase4()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		
 		//选择车款
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
 		//判断进入全款结果页
 		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "进入全款计算结果页面");
 		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款计算结果页面");
 		//获取当前全款总价
 		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
 		//修改裸车价格及上牌费用
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "500000");
 		Common.touchText(driver, "完成");
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]"), "600");
 		Common.touchText(driver, "完成");
 		//检查全款总价数据刷新
 		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
 		Assert.assertNotEquals(text1,text,"fullPayment refresh");
 		
 		//点击重置，回到全款计算首页
 		Common.touchText(driver,"重置");
 		//返回首页	  
 		Common.back(driver);
 	}
 	
 	/** 
	 * 底价购车-选择车款
	 *  
	 */
 	@Test(priority = 5)
 	public void faxian_gouchejisuanqi_testcase5()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
	  
 		//选择车款
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
 		//判断进入全款结果页
 		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "进入全款计算结果页面");
 		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款计算结果页面");
	  
 		//点击底价购车
 		Common.touchText(driver,"底价购车");
 		Assert.assertTrue(Common.checkTextExist(driver,"询底价"), "XunDiJia Page");
 		//返回首页
 		Common.close(driver);
 		Common.touchText(driver,"重置");
 		Common.back(driver);
 		}
 	
 	/** 
	 * 底价购车-裸车价格：全款结果页面选择车款
	 *  
	 */
 	@Test(priority = 6)
 	public void faxian_gouchejisuanqi_testcase6()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
	  
		//输入裸车价格，点击计算
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
		Common.touchText(driver, "计算");
		//判断进入全款结果页
		Assert.assertTrue(Common.checkTextExist(driver,"底价购车"), "进入全款计算结果页面");
		Assert.assertTrue(Common.checkTextNotExist(driver,"首付比例"), "进入全款计算结果页面");
 		//获取当前全款总价
 		String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
	
 		//选择车款，数据刷新
	  	Common.touchText(driver,"选择车款");
	  	Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
 		//检查全款总价数据刷新
 		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
 		Assert.assertNotEquals(text1,text,"fullPayment refresh");
	  
 		//点击底价购车
 		Common.touchText(driver,"底价购车");
 		Assert.assertTrue(Common.checkTextExist(driver,"询底价"), "XunDiJia Page");
 		//返回首页
 		Common.close(driver);
 		Common.touchText(driver,"重置");
 		Common.back(driver);
  }
 	
 	/** 
	 * 底价购车-裸车价格：询底价页面选择车款
	 *  
	 */
 	@Test(priority = 7)
 	public void faxian_gouchejisuanqi_testcase7()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		
 		//输入裸车价格，点击计算，进入全款结果页
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
 		Common.touchText(driver, "计算");
 		//点击底价购车，检查没有经销商信息
 		Common.touchText(driver,"底价购车");
 		Assert.assertTrue(Common.checkTextExist(driver,"询底价"), "XunDiJia Page");
// 		Assert.assertTrue(Common.checkTextExist(driver,"北京暂无支持的询价经销商"), "no dealer information");
 		//选择车款
 		Common.touchText(driver,"请选择车款");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
	  
 		//检查询底价页面刷新，显示经销商信息
 		Assert.assertTrue(Common.checkTextExist(driver,"询底价"), "XunDiJia Page");
	 	Assert.assertFalse(Common.checkTextExist(driver,"北京暂无支持的询价经销商"), "show dealername");
	 	//返回首页
	  	Common.close(driver);
	  	Common.touchText(driver,"重置");
	  	Common.back(driver);
  }
 	
 	/** 
	 * 贷款-选择车款
	 *  
	 */
 	@Test(priority = 8)
 	public void faxian_gouchejisuanqi_testcase8()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		//点击贷款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASegmentedControl[1]");
	  
	  	//选择车款
 		Common.touchText(driver,"选择车款");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
	  
		//检查进入贷款结果页面
		Assert.assertTrue(Common.checkTextExist(driver,"申请贷款"), "Enter loan result page");
	  
		//点击重置，回到贷款计算首页
		Common.touchText(driver,"重置");
		//返回首页  
		Common.back(driver);		  
	  }
 	
 	/** 
	 * 贷款-裸车价格
	 *  
	 */
 	@Test(priority = 9)
 	public void faxian_gouchejisuanqi_testcase9()  {
 		//进入购车计算器
		Common.touchText(driver,"发现");
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		//点击重置
		if(Common.checkTextExist(driver,"重置")){
			Common.touchText(driver,"重置");
		}
		//点击贷款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASegmentedControl[1]");
	  
	  	//输入裸车价格，点击计算
	  	Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
	  	Common.touchText(driver, "计算");
	  	//判断进入贷款结果页
	  	Assert.assertTrue(Common.checkTextExist(driver,"申请贷款"), "Loan result page");
	  
	  	//点击重置，回到贷款计算首页
	  	Common.touchText(driver,"重置");
	 	//返回首页
	 	Common.back(driver);
	 	}
 	
 	/** 
	 * 贷款结果页-修改结果页参数
	 *  
	 */
 	@Test(priority = 10)
 	public void faxian_gouchejisuanqi_testcase10()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		//点击贷款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASegmentedControl[1]");
	  
	  	//修改首付比例为50%，还款年限为2
	  	Common.touchText(driver,"50%");
	  	Common.touchText(driver,"2年");
	  
	  	//选择车款
 		Common.touchText(driver,"选择车款");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
	  
 		//检查首付比例和贷款年限显示正确
 		String sfbl=Common.getAttribute(driver, By.name("50%"), "value");
 		Assert.assertEquals(sfbl, "1", "首付比例为50%");
 		String years=Common.getAttribute(driver, By.name("2年"), "value");
 		Assert.assertEquals(years, "1", "还款年限为2年");
 		
 		//获取当前总价
 		String text=Common.getText(driver, By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]"));
	  
 		//修改首付比例、贷款年限、裸车价格、上牌费用
 		Common.touchText(driver,"30%");
 		Common.touchText(driver,"5年");
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"), "500000");
 		Common.touchText(driver, "完成");
	 	Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]"), "600");
	 	Common.touchText(driver, "完成");
	  
	 	//验证修改后数据刷新
	 	String text1=Common.getText(driver, By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]"));
	 	Assert.assertNotEquals(text, text1, "Data refresh after modify");
	 	//点击重置，返回首页
	 	Common.touchText(driver,"重置");
	 	Common.back(driver);
	 	}
 	
 	/** 
	 * 申请贷款-选择车款
	 *  
	 */
 	@Test(priority = 11)
 	public void faxian_gouchejisuanqi_testcase11()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		//点击贷款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASegmentedControl[1]");
	  	
	  	//选择车款
 		Common.touchText(driver,"选择车款");
 		Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
 		
 		//点击申请贷款
		Common.touchText(driver,"申请贷款");
		Assert.assertTrue(Common.checkTextExist(driver,"申请贷款"),"进入申请贷款页面");
		
		//返回首页
	    Common.close(driver);
		Common.touchText(driver,"重置");
		Common.back(driver);
	  }
 	
 	/** 
	 * 申请贷款-裸车价格：贷款结果页选择车款
	 *  
	 */
 	@Test(priority = 12)
 	public void faxian_gouchejisuanqi_testcase12()  {
 		//进入贷款页面
 		FaXian.enterLoanPage(driver);
 		//输入裸车价格，点击计算
	  	Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
	  	Common.touchText(driver, "计算");
	  	//获取当前总价
 		String text=Common.getText(driver, By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]"));
	  
 		//选择车款,刷新贷款页面数据
 		FaXian.chooseCar(driver);
 		
 		//验证修改后数据刷新
	 	String text1=Common.getText(driver, By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]"));
	 	Assert.assertNotEquals(text, text1, "Data refresh after modify");
	  
	 	//点击申请贷款
	 	Common.touchText(driver,"申请贷款");
	 	Assert.assertTrue(Common.checkTextExist(driver,"申请贷款"),"ShenQiDaiKuan Page");
	 	//返回首页
	 	Common.close(driver);
	 	Common.touchText(driver,"重置");
	 	Common.back(driver);
	 	}
 	
 	/** 
	 * 申请贷款-裸车价格：申请贷款页选择车款
	 *  
	 */
 	@Test(priority = 13)
 	public void faxian_gouchejisuanqi_testcase13()  {
 		//进入贷款页面
 		FaXian.enterLoanPage(driver);
 		//输入裸车价格，点击计算
	  	Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "200000");
	  	Common.touchText(driver, "计算");
	  
	  	//点击申请贷款
	  	Common.touchText(driver,"申请贷款");
	  	//检查提示该款车无金融贷款产品
	  	Assert.assertTrue(Common.checkTextExist(driver,"该款车暂无金融贷款产品"),"检查提示该款车无金融贷款产品");
      
	  	//点击请选择车款
	  	Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	  	Common.touchText(driver, "奥迪");
 		Common.touchText(driver, "奥迪A4L");
 		Common.touchText(driver, "40 TFSI 进取型 Plus");
  
 		//验证页面刷新，有贷款方案
 		Assert.assertTrue(Common.checkTextExist(driver,"该款车暂无金融贷款产品"),"检查无该款车无金融贷款产品提示");
 		//返回首页
 		Common.close(driver);
 		Common.touchText(driver,"重置");
 		Common.back(driver);
 		}
 	
 	/** 
	 * 记录-全款
	 *  
	 */
 	@Test(priority = 14)
 	public void faxian_gouchejisuanqi_testcase14()  {
 		//进入购车计算器
 		Common.touchText(driver,"发现");
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
 		//点击重置
 		if(Common.checkTextExist(driver,"重置")){
 			Common.touchText(driver,"重置");
 		}
 		//选择车款
 		FaXian.chooseCar(driver);
	  
 		//记录当前车款和全款总价
 		String fullpayment=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
 		String carname=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]"));
 		String price=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"),"value");
	 	String paizhao=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]"),"value");
	  
		//修改裸车价格和上牌费用，并验证成功
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"), "500000");
 		Common.touchText(driver, "完成");
 		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]"), "600");
 		Common.touchText(driver, "完成");
	  
		//返回再进入购车计算器
		Common.back(driver);
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
	  
		//验证记录全款界面，裸车价格和上牌费用恢复到默认数值
		String fullpayment1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
 		String carname1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]"));
 		String price1=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"),"value");
	 	String paizhao1=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]"),"value");
	 	Assert.assertEquals(fullpayment1, fullpayment,"record successfully");
	 	Assert.assertEquals(carname1, carname,"record successfully");
	  	Assert.assertEquals(price1, price,"record successfully");
	  	Assert.assertEquals(paizhao1, paizhao,"record successfully");
	  	//返回再首页
	  	Common.touchText(driver, "重置");
	  	Common.back(driver);
	  	}
 	
 	/** 
	 * 记录-贷款
	 *  
	 */
 	@Test(priority = 15)
 	public void faxian_gouchejisuanqi_testcase15()  {
 		//进入贷款首页
 		FaXian.enterLoanPage(driver);
 		//选择车款，进入贷款结果页
 		FaXian.chooseCar(driver);
 		//检查进入贷款计算结果页面
 		Assert.assertTrue(Common.checkTextExist(driver, "申请贷款"), "检查进入贷款计算结果页面");
 		//返回再进入购车计算器
 		Common.back(driver);
 		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
	  
 		//检查进入全款计算结果页面
 		Assert.assertTrue(Common.checkTextExist(driver, "底价购车"), "检查进入全款计算结果页面");
 		//返回首页
 		Common.touchText(driver, "重置");
 		Common.back(driver);
 		}
}


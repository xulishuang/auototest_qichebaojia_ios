package script.faxian;

import org.openqa.selenium.By;  
import org.testng.Assert;
import org.testng.annotations.*; 

import script.AppTestSuite;
 
import common.*;
import models.FaXian;

public class ZhiNengXuanCheTest extends AppTestSuite{
	
	  /** 
		 * 购车需求
		 *  
		 */
	  @Test(priority = 1)
	  public void faxian_zhinengxuanche_testcase1()  {
		  //进入智能选车
		  FaXian.enterZhiNengXuanChePage(driver);
		  //选择价格区间
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[10]");//40-60万
		  //检查价格区间选择成功
		  Assert.assertTrue(Common.checkTextExist(driver, "40-60万"),"检查价格区间选择成功");
		  //获取当前结果
		  String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  //选择三个需求标签
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]");
		  String text2=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]");
		  String text3=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  //检查三个标签选中
		  Assert.assertNotEquals(text,text1, "检查标签选中");
		  Assert.assertNotEquals(text1,text2, "检查标签选中");
		  Assert.assertNotEquals(text2,text3, "检查标签选中");
		  //选择第四个需求标签
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[7]");
		  String text4=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  //检查第4个标签不能被选中
		  Assert.assertEquals(text3,text4, "检查第四个标签不能被选中");
		  //获取该组标签第一个的名字
		  String text5=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]"));
		  //点击换一换
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
		  //检查换了一组购车需求标签
		  String text6=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]"));
		  Assert.assertNotEquals(text5, text6, "检查换了一组购车需求标签");
		  //再次选择三个标签
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]");
		  //返回到首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 重置
		 *  
		 */
	  @Test(priority = 2)
	  public void faxian_zhinengxuanche_testcase2()  {
		  //进入智能选车
		  FaXian.enterZhiNengXuanChePage(driver);
		  //选择三个需求标签
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]");
		  Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]");
		  //获得当前结果
		  String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  //点击重置
		  Common.touchTopRight(driver);//由于找不到重置元素，通过坐标进行点击
		  //获得重置后结果
		  String text2=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
		  //检查清空已选中标签
		  Assert.assertNotEquals(text1, text2,"检查重置成功");
		  //返回发现首页
		  Common.back(driver);
	  }
	  
	  /** 
		 * 结果
		 *  
		 */
	  @Test(priority = 3)
	  public void faxian_zhinengxuanche_testcase3() {
		  //进入智能选车
		  FaXian.enterZhiNengXuanChePage(driver);
		  //点击进入结果页
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
		  //点击车型
		  Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		  //检查进入车型综述页
		  Assert.assertTrue(Common.checkIsSelected(driver,By.name("综述")), "检查进入车型综述页");
		  //返回到发现首页
		  Common.multiBack(driver, 3);
	  }
}
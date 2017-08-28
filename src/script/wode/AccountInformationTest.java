package script.wode;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import script.AppTestSuite;

import common.*; 

public class AccountInformationTest extends AppTestSuite {
	/**
	 * @function 查看头像
	 * @
	 */
	@Test(priority = 1)
	public void wode_accountinformation_testcase1()  {
		//进入我的
		Common.touchText(driver, "我的");
		//点击头像，大图浏览
		
	}
	
	/**
	 * @function 修改账号信息
	 * @
	 */
	@Test(priority = 2)
	public void wode_accountinformation_testcase2() {
		//进入我的
		Common.touchText(driver, "我的");
		//进入账号信息
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		//点击头像
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//从相册上传
		Common.touchText(driver, "从相册上传");
		Common.touchText(driver, "相机胶卷");//点击相机胶卷
		Common.touchLocation(driver,50,100);//选择照片
		Common.touchLocation(driver, 400, 700);//点击选取		
		//检查返回账号设置页
		Assert.assertTrue(Common.checkTextExist(driver, "账号设置"),"检查返回账号设置页面");
		//修改昵称
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");//点击昵称
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "xls2017");//修改昵称
		Common.touchTopRight(driver);//点击完成
		//检查昵称修改成功
		Assert.assertTrue(Common.checkTextExist(driver,"xls2017"),"检查昵称修改成功");
		//修改性别
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");//点击性别
		String text=Common.getAttribute(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]"), "value");
		if(text.equals("男")){
			Common.selectValue(driver, "女");
			Common.touchText(driver, "完成");
			//检查性别修改成功
			Assert.assertTrue(Common.checkTextExist(driver, "女"),"检查性别修改成功");
		}
		else{
			Common.selectValue(driver, "男");
			Common.touchText(driver, "完成");
			//检查性别修改成功
			Assert.assertTrue(Common.checkTextExist(driver, "男"),"检查性别修改成功");
		}
//		//修改生日
//		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
//		Common.selectValue(driver, "1989");//选择年份为1989
//		Common.touchText(driver, "完成");
//		//检查生日修改成功
//		String text1=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[2]"));
//		Assert.assertTrue(text1.contains("1989"),"检查生日修改成功");
		//修改我的爱车
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]");
		Common.touchText(driver,"奥迪");
		//检查修改成功
		Assert.assertTrue(Common.checkTextExist(driver, "账号设置")&&Common.checkTextExist(driver, "奥迪"), "检查修改成功");
		//修改签名
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]");
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "future");//输入文字
		Common.touchTopRight(driver);//点击完成
		//检查修改成功
		Assert.assertTrue(Common.checkTextExist(driver, "账号设置")&&Common.checkTextExist(driver, "future"), "检查修改成功");
		//返回首页
		Common.back(driver);
		
	}

}

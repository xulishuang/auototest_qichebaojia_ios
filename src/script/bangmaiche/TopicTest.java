package script.bangmaiche;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import script.AppTestSuite;
import common.*;
import constant.Text;
import models.BangMaiChe;

public class TopicTest extends AppTestSuite {
	
	  /** 
		 * 普通话题-发表评论
		 * 
		 */	
	  @Test(priority = 1)
	  public void bangmaiche_topic_testcase1()  {
		  //进入最新页面
		  Common.touchText(driver, "帮买车");
		  Common.touchText(driver,"最新");
		  //发布一条普通话题并点击进入
		  BangMaiChe.releaseGeneralTopic(driver);
		  Common.touchText(driver, Text.ACCOUNT);
		  //点击底部文字输入框
		  Common.touchText(driver,"  说点什么吧....");
		  //输入文字
		  Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "看一看");
		  //点击关联车型
		  Common.touchText(driver,"关联车型");
		  //选择车型
		  Common.touchText(driver,"奥迪");
		  Common.touchText(driver, "奥迪A3");
		  //检查选择车型成功
		  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3"),"检查选择车型成功");
		  //选择引用话题
		  Common.touchText(driver,"引用话题");
		  //关闭引用话题页面
		  Common.touchText(driver,"nav right close");
		  //点击发布
		  Common.touchText(driver, "发布");
		  //下滑刷新数据
		  Common.swipeToDown(driver, 500, 1);
		  //检查发布成功
		  Assert.assertTrue(Common.checkTextExist(driver,"奥迪A3")&&Common.checkTextExist(driver,"话题详情"),"检查发布成功");
		  //收尾：删除话题，返回
		  Common.touchText(driver, "topic btn action 4 nor");
		  Common.touchText(driver, "确定");
	  }
	  
	  /** 
		 * 普通话题-删除评论
		 * 
		 */	
//	  @Test(priority = 2)
//	  public void bangmaiche_topic_testcase2()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条普通话题
//		  a:for (int i=0;i<10;i++){
//			  for(int index=0; index<2;index++){
//				  Common.touchId(driver,Id.TOPIC_CONTENT,index);
//				  if (Common.checkIdNotExist(driver, Id.SNS_VOTE_COUNT_TV)){
//					  break a;
//				  }else{
//					  Common.back(driver);  
//				  }
//				  Common.swipeToUp(driver, 500, 1);
//			}
//		  }
//		  //记录当前评论数
//		  String num=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  //点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "看一看");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //删除本人已发布的评论
//		  Common.touchText(driver, Text.DELETE);
//		  Common.touchText(driver,Text.OK);
//		  //检查删除成功
//		  Assert.assertTrue(Common.checkTextNotExist(driver,"看一看"), "Comment shows correctly");
//		  String num1=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  Assert.assertEquals(num,num1, "Delete successfully");
//		  
//		  Common.back(driver);
//	  }
//	    
//	  /** 
//		 * 普通话题-话题点赞
//		 * 
//		 */	
//	  @Test(priority = 3)
//	  public void bangmaiche_topic_testcase3()  {
//		  //进入我的页面获取用户名称
//		  Common.touchText(driver, Text.WODE);
//		  String username=Common.getText(driver, By.id(Id.SNS_USER_MAIN_NICKNAME_TV));
//		  //进入最新页面
//		  Common.touchText(driver, Text.BANGMAICHE);
//		  Common.touchText(driver,Text.NEWEST);
//		  //点击某一条普通话题
//		  a:for (int i=0;i<10;i++){
//			  for(int index=0; index<2;index++){
//				  Common.touchId(driver,Id.TOPIC_CONTENT,index);
//				  if (Common.checkIdNotExist(driver, Id.SNS_VOTE_COUNT_TV)){
//					  break a;
//				  }else{
//					  Common.back(driver);  
//				  }
//				  Common.swipeToUp(driver, 500, 1);
//			}
//		  }
//		  //记录当前点赞数目
//		  String num=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  //点赞
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_LIKE_IV,5);
//		  //检查点赞数增1
//		  String num_actual=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  String num_expected=Integer.toString(Integer.parseInt(num)+1);
//		  Assert.assertEquals(num_actual, num_expected, "like add 1");
//		  //点击进入点赞用户列表
//		  Common.touchId(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT);
//		  Common.waitForVisible(driver, By.id(Id.USERNAME), 15);
//		  //检查用户名称存在
//		  Assert.assertTrue(Common.checkTextExist(driver, username), "check username exist");
//		  Common.back(driver);
//		  //再次点赞
//		  Common.touchId(driver, Id.SNS_TOPIC_LIKE_IV);
//		  //检查取消点赞，点赞数减1
//		  String num_actual1=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  Assert.assertEquals(num_actual1, num, "like minus 1");
//		  
//		  //点赞用户列表没有用户名称
//		  if(Common.checkIdExist(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT)){
//			  Common.touchId(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT);
//			  //检查用户名称不存在
//			  Common.waitForVisible(driver, By.id(Id.USERNAME), 15);
//			  Assert.assertTrue(Common.checkTextNotExist(driver, username), "check username does not exist");
//			  Common.back(driver);
//		  }
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 普通评论-给评论回复
//		 * 
//		 */	
//	  @Test(priority = 4)
//	  public void bangmaiche_topic_testcase4()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条普通话题
//		  a:for (int i=0;i<10;i++){
//			  for(int index=0; index<2;index++){
//				  Common.touchId(driver,Id.TOPIC_CONTENT,index);
//				  if (Common.checkIdNotExist(driver, Id.SNS_VOTE_COUNT_TV)){
//					  break a;
//				  }else{
//					  Common.back(driver);  
//				  }
//				  Common.swipeToUp(driver, 500, 1);
//			}
//		  }
//		  //点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "看一看");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //点击评论回复
//		  Common.touchSlideId(driver,Id.COMMENT_SEND_TV,3);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "嘿嘿");
//		  //点击关联车型
//		  Common.touchText(driver,Text.REFERENCE_CARTYPE);
//		  //选择车型
//		  Common.touchText(driver,Text.AUDI);
//		  Common.touchSlideText(driver, Text.AUDI_A3,3);
//		  //检查评论框显示已选择车型
//		  String text=Common.getText(driver, By.id(Id.REFERENCE_CARTYPE_BT));
//		  Assert.assertEquals(text, Text.AUDI_A3, "Refer cartype successfully");
//		  //选择引用话题
//		  Common.touchText(driver,Text.REFERENCE_TOPIC);
//		  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
//		  Assert.assertEquals(text1, Text.REFERENCE_TOPIC, "Enter reference topic page");
//		  //选择话题
//		  
//		  Common.back(driver);
//		  //点击发布
//		  Common.touchText(driver, Text.RELEASE);
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  //检查发布成功
//		  for(int n=0;n<5;n++){
//			  if (Common.checkTextExist(driver, "嘿嘿 ")){
//				  break;
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Thread.sleep(500);
//			  }
//		  }
//		  Assert.assertTrue(Common.checkTextExist(driver, "嘿嘿 "), "Send successfully");
//		  Assert.assertTrue(Common.checkIdExist(driver,Id.COMMENT_REPLYCONTENT_TV), "Send successfully");
//		  
//		  //恢复环境，删除已发评论
//		  for(int i=0;i<2;i++){
//			  if(Common.checkTextExist(driver, Text.DELETE)){
//				  Common.touchText(driver, Text.DELETE);
//				  Common.touchText(driver,Text.OK);
//			  }
//		  }
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 普通话题-给评论点赞
//		 * 
//		 */	
//	  @Test(priority = 5)
//	  public void bangmaiche_topic_testcase5()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条普通话题
//		  a:for (int i=0;i<10;i++){
//			  for(int index=0; index<2;index++){
//				  Common.touchId(driver,Id.TOPIC_CONTENT,index);
//				  if (Common.checkIdNotExist(driver, Id.SNS_VOTE_COUNT_TV)){
//					  break a;
//				  }else{
//					  Common.back(driver);  
//				  }
//				  Common.swipeToUp(driver, 500, 1);
//			}
//		  }
//		  //点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "点赞");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //找到发布评论的位置
//		  for(int n=0;n<5;n++){
//			  if (Common.checkTextExist(driver, "点赞 ")){
//				  break;
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Thread.sleep(500);
//			  }
//		  }
//		  //给评论点赞
//		  Common.touchId(driver, Id.SNS_COMMENT_LIKE_IV);
//		  //检查点赞数增1
//		  String num=Common.getText(driver, By.id(Id.SNS_COMMENT_LIKE_TV));
//		  Assert.assertEquals(num, "1", "like add 1");
//		  //再次点赞
//		  Common.touchId(driver, Id.SNS_COMMENT_LIKE_IV);
//		  //检查取消点赞，点赞数减1
//		  String num1=Common.getText(driver, By.id(Id.SNS_COMMENT_LIKE_TV)); 
//		  Assert.assertEquals(num1, "", "like minus 1");
//		  
//		  //删除评论
//		  Common.touchText(driver,Text.DELETE);
//		  Common.touchText(driver,Text.OK);
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 投票话题-发表评论
//		 * 
//		 */	
//	  @Test(priority = 6)
//	  public void bangmaiche_topic_testcase6()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  //记录当前评论数
//		  String num=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  //点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "看一看");
//		  //点击关联车型
//		  Common.touchText(driver,Text.REFERENCE_CARTYPE);
//		  //选择车型
//		  Common.touchText(driver,Text.AUDI);
//		  Common.touchSlideText(driver, Text.AUDI_A3,3);
//		  //检查评论框显示已选择车型
//		  String text=Common.getText(driver, By.id(Id.REFERENCE_CARTYPE_BT));
//		  Assert.assertEquals(text, Text.AUDI_A3, "Refer cartype successfully");
//		  //选择引用话题
//		  Common.touchText(driver,Text.REFERENCE_TOPIC);
//		  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
//		  Assert.assertEquals(text1, Text.REFERENCE_TOPIC, "Enter reference topic page");
//		  //选择话题
//		  
//		  Common.back(driver);
//		  //点击发布
//		  Common.touchText(driver, Text.RELEASE);
//		  //检查发布成功，返回话题详情页面，评论数目增1
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Back to topic details page");
//		  String num_actual=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  String num_expected=Integer.toString(Integer.parseInt(num)+1);
//		  Assert.assertEquals(num_actual, num_expected, "Comments add 1");
//		  //检查评论内容显示正确
//		  for(int n=0;n<5;n++){
//			  if (Common.checkTextExist(driver, "看一看 ")){
//				  break;
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Thread.sleep(500);
//			  }
//		  }  
//		  Assert.assertTrue(Common.checkTextExist(driver,"看一看 "), "Comment shows correctly");
//		  Assert.assertTrue(Common.checkTextExist(driver,Text.AUDI_A3), "Comment shows correctly");
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 投票话题-删除评论
//		 * 
//		 */	
//	  @Test(priority = 7)
//	  public void bangmaiche_topic_testcase7()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  
//		  //记录当前评论数
//		  String num=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  //点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "看一看");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //删除本人已发布的评论
//		  Common.touchText(driver, Text.DELETE);
//		  Common.touchText(driver,Text.OK);
//		  //检查删除成功
//		  Assert.assertTrue(Common.checkTextNotExist(driver,"看一看"), "Comment shows correctly");
//		  String num1=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  Assert.assertEquals(num,num1, "Delete successfully");
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 投票话题-话题点赞
//		 * 
//		 */	
//	  @Test(priority = 8)
//	  public void bangmaiche_topic_testcase8()  {
//		  //进入我的页面获取用户名称
//		  Common.touchText(driver, Text.WODE);
//		  String username=Common.getText(driver, By.id(Id.SNS_USER_MAIN_NICKNAME_TV));
//		  //进入最新页面
//		  Common.touchText(driver, Text.BANGMAICHE);
//		  Common.touchText(driver,Text.NEWEST);
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  
//		  //记录当前点赞数目
//		  String num=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  //点赞
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_LIKE_IV,5);
//		  //检查点赞数增1
//		  String num_actual=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  String num_expected=Integer.toString(Integer.parseInt(num)+1);
//		  Assert.assertEquals(num_actual, num_expected, "like add 1");
//		  //点击进入点赞用户列表
//		  Common.touchId(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT);
//		  //检查用户名称存在
//		  Common.waitForVisible(driver, By.id(Id.USERNAME), 15);
//		  Assert.assertTrue(Common.checkTextExist(driver, username), "check username exist");
//		  Common.back(driver);
//		  //再次点赞
//		  Common.touchId(driver, Id.SNS_TOPIC_LIKE_IV);
//		  //检查取消点赞，点赞数减1
//		  String num_actual1=Common.getText(driver, By.id(Id.SNS_TOPIC_LIKE_TV));
//		  Assert.assertEquals(num_actual1, num, "like minus 1");
//		  //点赞用户列表没有用户名称
//		  if(Common.checkIdExist(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT)){
//			  Common.touchId(driver,Id.SNS_TOPIC_LIKE_USER_LAYOUT);
//			  //检查用户名称不存在
//			  Common.waitForVisible(driver, By.id(Id.USERNAME), 15);
//			  Assert.assertTrue(Common.checkTextNotExist(driver, username), "check username does not exist");
//			  Common.back(driver);
//		  }
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 投票话题-给评论回复
//		 * 
//		 */	
//	  @Test(priority = 9)
//	  public void bangmaiche_topic_testcase9()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  
//		//点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "看一看");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //点击评论回复
//		  Common.touchSlideId(driver,Id.COMMENT_SEND_TV,3);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "嘿嘿");
//		  //点击关联车型
//		  Common.touchText(driver,Text.REFERENCE_CARTYPE);
//		  //选择车型
//		  Common.touchText(driver,Text.AUDI);
//		  Common.touchSlideText(driver, Text.AUDI_A3,3);
//		  //检查评论框显示已选择车型
//		  String text=Common.getText(driver, By.id(Id.REFERENCE_CARTYPE_BT));
//		  Assert.assertEquals(text, Text.AUDI_A3, "Refer cartype successfully");
//		  //选择引用话题
//		  Common.touchText(driver,Text.REFERENCE_TOPIC);
//		  String text1=Common.getText(driver, By.id(Id.TITLE_CENTER_TXT));
//		  Assert.assertEquals(text1, Text.REFERENCE_TOPIC, "Enter reference topic page");
//		  //选择话题
//		  
//		  Common.back(driver);
//		  //点击发布
//		  Common.touchText(driver, Text.RELEASE);
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  //检查发布成功
//		  for(int n=0;n<5;n++){
//			  if (Common.checkTextExist(driver, "嘿嘿 ")){
//				  break;
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Thread.sleep(500);
//			  }
//		  }
//		  Assert.assertTrue(Common.checkTextExist(driver, "嘿嘿 "), "Send successfully");
//		  Assert.assertTrue(Common.checkIdExist(driver,Id.COMMENT_REPLYCONTENT_TV), "Send successfully");
//		  
//		  //恢复环境，删除已发评论
//		  for(int i=0;i<2;i++){
//			  if(Common.checkTextExist(driver, Text.DELETE)){
//				  Common.touchText(driver, Text.DELETE);
//				  Common.touchText(driver,Text.OK);
//			  }
//		  }
//		  
//		  Common.back(driver);		  
//	  }
//	  
//	  /** 
//		 * 投票话题-给评论点赞
//		 * 
//		 */	
//	  @Test(priority = 10)
//	  public void bangmaiche_topic_testcase10()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  
//		//点击底部文字输入框
//		  Common.touchId(driver,Id.BOTTOM_EDIT);
//		  //输入文字
//		  Common.sendTextById(driver, Id.SNS_COMMENT_CONTENT, "点赞");
//		  //点击发布
//		  Common.touchText(driver,Text.RELEASE);
//		  
//		  //找到发布评论的位置
//		  for(int n=0;n<5;n++){
//			  if (Common.checkTextExist(driver, "点赞 ")){
//				  break;
//			  }else{
//				  Common.swipeToUp(driver, 500, 1);
//				  Thread.sleep(500);
//			  }
//		  }
//		  //给评论点赞
//		  Common.touchId(driver, Id.SNS_COMMENT_LIKE_IV);
//		  //检查点赞数增1
//		  String num=Common.getText(driver, By.id(Id.SNS_COMMENT_LIKE_TV));
//		  Assert.assertEquals(num, "1", "like add 1");
//		  //再次点赞
//		  Common.touchId(driver, Id.SNS_COMMENT_LIKE_IV);
//		  //检查取消点赞，点赞数减1
//		  String num1=Common.getText(driver, By.id(Id.SNS_COMMENT_LIKE_TV)); 
//		  Assert.assertEquals(num1, "", "like minus 1");
//		  
//		  //删除评论
//		  Common.touchText(driver,Text.DELETE);
//		  Common.touchText(driver,Text.OK);
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 投票话题-发表投票
//		 * 
//		 */	
//	  @Test(priority = 11)
//	  public void bangmaiche_topic_testcase11()  {
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击某一条投票话题
//		  Common.touchSlideId(driver, Id.SNS_TOPIC_VOTE_COUNT, 10);
//		  
//		  //记录当前投票数
//		  String num=Common.getText(driver, By.id(Id.SNS_VOTE_COUNT_TV));
//		  //点击投票
//		  if(Common.checkIdExist(driver,Id.SNS_VOTE_TXT)){
//			  Common.touchId(driver,Id.SNS_VOTE_TXT);
//			  //检查投票数增1
//			  String num_actual=Common.getText(driver, By.id(Id.SNS_VOTE_COUNT_TV));
//			  String num_expected=Integer.toString(Integer.parseInt(num)+1);
//			  Assert.assertEquals(num_actual, num_expected, "Vote counts add 1");
//		  }else{
//			  //检查已经参与投票啦
//			  Assert.assertTrue(Common.checkIdExist(driver, Id.SNS_VOTE_COUNT), "Vote already");
//			  Assert.assertTrue(Common.checkIdExist(driver, Id.SNS_VOTE_PERCENT), "Vote already");
//		  }
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 话题详情页-收藏
//		 * 
//		 */	
//	  @Test(priority = 12)
//	  public void bangmaiche_topic_testcase12()  {
//		  //进入我的社区-收藏夹，清空所有收藏
//		  WoDe.setTopicEmpty(driver);
//		  // 检查清空成功
//		  Assert.assertTrue(Common.checkIdExist(driver,Id.SNS_USERINFO_EMPTY_TV), "clear successfully");
//		  Common.multiBack(driver, 2);
//		  
//		  //进入最新页面
//		  Common.touchText(driver, "帮买车");
//		  Common.touchText(driver,"最新");
//		  //点击进入话题详情页
//		  Common.touchId(driver, Id.TOPIC_CONTENT);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Enter topic details page");
//		  //点击收藏
//		  Common.touchId(driver,Id.TITLE_RIGHT_FAV_BTN);
//		  //检查收藏成功
//		  Common.back(driver);
//		  Common.touchText(driver,Text.WODE);
//		  Common.touchText(driver, Text.MY_COMMUNITY);
//		  Common.touchText(driver,Text.FAVORITE);
//		  Assert.assertTrue(Common.checkIdNotExist(driver,Id.SNS_USERINFO_EMPTY_TV), "favorite");
//		 
//		  Common.multiBack(driver, 2);
//	  }
//	  
//	  /** 
//		 * 话题详情页-分享
//		 * 
//		 */	
//	  @Test(priority = 13)
//	  public void bangmaiche_topic_testcase13()  {
//		  //进入最新页面
//		  Common.touchText(driver, Text.BANGMAICHE);
//		  Common.touchText(driver,Text.NEWEST);
//		  //点击进入话题详情页
//		  Common.touchId(driver, Id.TOPIC_CONTENT);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Enter topic details page");
//		  //点击右上角button
//		  Common.touchId(driver,Id.TITLE_RIGHT_MORE_BTN);
//		  //点击分享
//		  Common.touchText(driver,Text.SHARE);
//		  //检查弹出分享媒体弹框，显示微信好友，朋友圈，微博，qq空间，qq好友，浏览器
//		  Assert.assertTrue(Common.checkIdExist(driver, Id.MSHAREPLATFORMS), "Pop up media share plateform");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.WEIXIN_FRIEND), "weixin friend");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.WEIXIN_CIRCLE), "weixin circle");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.SINA_WEIBO), "sina weibo");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.QQ_ZONE), "QQ zone");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.QQ_FRIEND), "QQ friend");
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.BROWSER), "browser");
//		  //点击取消
//		  Common.touchText(driver,Text.CANCEL);
//		  //检查返回话题详情页面
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Back to topic details page");
//		  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 话题详情页-筛选评论
//		 * 
//		 */	
//	  @Test(priority = 14)
//	  public void bangmaiche_topic_testcase14()  {
//		  //进入最新页面
//		  Common.touchText(driver, Text.BANGMAICHE);
//		  Common.touchText(driver,Text.NEWEST);
//		  //点击进入话题详情页,话题评论数不为0
//		  Common.touchId(driver, Id.TOPIC_CONTENT);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Enter topic details page");
//		  //点击右上角button
//		  Common.touchId(driver,Id.TITLE_RIGHT_MORE_BTN);
//		  //点击只看楼主
//		  Common.touchText(driver,Text.ONLY_HOST);
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Back to topic details page");
//		  //点击优先显示最早评论
//		  Common.touchId(driver,Id.TITLE_RIGHT_MORE_BTN);
//		  Common.touchText(driver, Text.SHOW_EARLIEST_COMMENT);
//		  //检查显示最早评论
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  
//		  String text=Common.getText(driver, By.id(Id.SNS_TOPIC_COMMENT_TV));
//		  if(!text.equals("0")){
//			  for(int i=0;i<5;i++){
//				  if(Common.checkIdExist(driver, Id.SNS_DETAIL_ALL_COMM)){
//					  break;
//				  }else{
//					  Common.swipeToUp(driver, 500, 1);
//					  Thread.sleep(500);
//				  }
//			  }
//			  Assert.assertTrue(Common.checkTextExist(driver, Text.EARLIEST_COMMENT), "show earliest comment");
//		  }
//		  //点击显示最新评论
//		  Common.touchId(driver,Id.TITLE_RIGHT_MORE_BTN);
//		  Common.touchText(driver, Text.SHOW_NEWEST_COMMENT);
//		 //检查显示最新评论
//		  Common.waitForVisible(driver, By.name(Text.TOPIC_DETAILS), 15);
//		  if(!text.equals("0")){
//			  for(int i=0;i<5;i++){
//				  if(Common.checkIdExist(driver, Id.SNS_DETAIL_ALL_COMM)){
//					  break;
//				  }else{
//					  Common.swipeToUp(driver, 500, 1);
//					  Thread.sleep(500);
//				  }
//			  }
//			  Assert.assertTrue(Common.checkTextExist(driver, Text.NEWEST_COMMENT), "show newest comment"); 
//		  }
//  
//		  Common.back(driver);
//	  }
//	  
//	  /** 
//		 * 话题详情页-取消
//		 * 
//		 */	
//	  @Test(priority = 15)
//	  public void bangmaiche_topic_testcase15()  {
//		  //进入最新页面
//		  Common.touchText(driver, Text.BANGMAICHE);
//		  Common.touchText(driver,Text.NEWEST);
//		  //点击进入话题详情页
//		  Common.touchId(driver, Id.TOPIC_CONTENT);
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Enter topic details page");
//		  //点击右上角button
//		  Common.touchId(driver,Id.TITLE_RIGHT_MORE_BTN);
//		  //点击取消
//		  Common.touchText(driver,Text.CANCEL);
//		  //检查返回话题详情页面
//		  Assert.assertTrue(Common.checkTextExist(driver, Text.TOPIC_DETAILS), "Back to topic details page");
//		  
//		  Common.back(driver);
//	  }

}

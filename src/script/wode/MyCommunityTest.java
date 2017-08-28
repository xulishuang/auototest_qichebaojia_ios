package script.wode;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import script.AppTestSuite;
import common.*;
import models.BangMaiChe;
import models.WoDe;

public class MyCommunityTest extends AppTestSuite{
	
    /**
     * @function 我的话题列表-添加话题
     * @
     */
	@Test(priority = 1)
	public void wode_mycommunity_testcase1() {
		//清空我的话题列表
		WoDe.setTopicEmpty(driver);
		//发布话题
		BangMaiChe.releaseGeneralTopic(driver);
		//进入我的话题列表页
		WoDe.enterTopicPage(driver);
		//检查话题添加成功
		Assert.assertTrue(Common.checkTextNotExist(driver,"您还没有发表过话题"),"检查话题发布成功");
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 我的话题列表-话题跳转
	 * @precondition 接续testcase1
	 * @
	 */
	@Test(priority = 2)
	public void wode_mycommunity_testcase2() {
		//进入我的-我的社区-话题
		WoDe.enterTopicPage(driver);
		//点击话题数据
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//检查进入话题详情页
		Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "成功进入话题详情页");
		//返回首页
		Common.multiBack(driver, 3);
	}
	
	/**
	 * @function 我的话题列表-点赞
	 * @preconditon 接续testcase1
	 * @
	 */
	@Test(priority = 3)
	public void wode_mycommunity_testcase3() {
		//进入我的-我的社区-话题
		WoDe.enterTopicPage(driver);
		//点赞
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]");
		//检查点赞成功
		  
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 我的话题列表-评论
	 * @precondion 接续testcase1
	 * @
	 */
	@Test(priority = 4)
	public void wode_mycommunity_testcase4() {
		//进入我的-我的社区-话题
		WoDe.enterTopicPage(driver);
		//进行评论
		Common.touchText(driver, "topic btn action 2 nor");//点击评论
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "嗯嗯");//输入内容
		Common.touchText(driver, "引用话题");//点击引用话题
		Common.touchText(driver,"nav right close");//关闭
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");//点击发布
		//检查评论成功
				
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 我的评论列表-添加评论
	 * @
	 */
	@Test(priority = 5)
	public void wode_mycommunity_testcase5() {
		//清空评论
		WoDe.setCommentsEmpty(driver);
		//进入帮买车发表评论
		Common.touchText(driver, "帮买车");
		Common.touchText(driver, "最新");
		Common.touchText(driver, "topic btn action 2 nor");
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "支持汽车大咖");
		Common.touchText(driver, "引用话题");//点击引用话题
		Common.touchText(driver,"nav right close");//关闭
		Common.touchText(driver, "发布");
		//返回，进入我的-我的社区-评论
		WoDe.enterCommentPage(driver);;//点击评论
		//检查评论发表成功
        Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有发表过评论"),"检查评论发表成功");
        //返回首页
        Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 我的评论列表-话题跳转
	 * @
	 */
	@Test(priority = 6)
	public void wode_mycommunity_testcase6() {
		//进入我的评论列表	
		WoDe.enterCommentPage(driver);
		//点击某一条收到的评论
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		//检查进入话题详情页面
		Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "成功进入话题详情页");
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 我的评论列表-删除
	 * @
	 */
	@Test(priority = 7)
	public void wode_mycommunity_testcase7() {
		//进入我的评论列表,删除评论列表
		WoDe.setCommentsEmpty(driver);
		//检查评论删除成功		
		Assert.assertTrue(Common.checkTextNotExist(driver, "删除"), "检查评论删除成功");
		//返回首页
		Common.multiBack(driver, 2);	
	}
	
	/**
	 * @function 我的关注列表-添加关注
	 * @
	 */
	@Test(priority = 8)
	public void wode_mycommunity_testcase8() {
		//清空关注列表
		WoDe.setFollowsEmpty(driver);
		//进入帮买车，添加关注
		BangMaiChe.addUserFollow(driver);
		//进入我的社区关注列表查看
		WoDe.enterFollowPage(driver);
		//检查关注成功
		Assert.assertTrue(Common.checkTextNotExist(driver, "您还没有关注任何人"), "检查添加关注成功！");
		//取消关注
		Common.touchXpath(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
		Common.back(driver);
		//检查取消关注成功
		Assert.assertTrue(Common.checkTextNotExist(driver, "myAttention xhgz nor")&&Common.checkTextNotExist(driver, "myAttention ygz nor"),"检查取消关注成功！");//关注Text
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 我的关注列表-页面跳转
	 * @
	 */
	@Test(priority = 9)
	public void wode_mycommunity_testcase9() {
		//进入帮买车，添加关注
		BangMaiChe.addUserFollow(driver);
		//进入我的社区-关注
		WoDe.enterFollowPage(driver);
	    //点击关注列表
	    Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		// 检查成功进入他人主页
		Assert.assertTrue(Common.checkTextExist(driver, "btn yiguanzhu")||Common.checkTextExist(driver, "btn xhgz"), "检查成功进入他人主页！");
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 我的粉丝列表-加关注
	 * @
	 */
	@Test(priority = 10)
	public void wode_mycommunity_testcase10() {
		//进入我的社区-粉丝			
		WoDe.enterFansPage(driver);
	    String text=Common.getText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]"));
	    //进行关注或取消关注
	    if(text.equals("myAttention guanzhu nor")){
	    	Common.touchText(driver,"myAttention guanzhu nor");
	    	Assert.assertTrue(Common.checkTextExist(driver, "myAttention xhgz nor"), "检查关注成功！");
	    }
	    else{
	    	Common.touchText(driver,"myAttention xhgz nor");
	    	Assert.assertTrue(Common.checkTextExist(driver, "myAttention guanzhu nor"), "检查取消关注成功！");
	    }
	    //返回首页
		Common.multiBack(driver, 2);	
	}
	
	/**
	 * @function 我的粉丝列表-页面跳转
	 * @
	 */
	@Test(priority = 11)
	public void wode_mycommunity_testcase11() {
		//进入我的社区-粉丝			
		WoDe.enterFansPage(driver);			
		//点击某一粉丝
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
		//检查成功进入他人主页		
		Assert.assertTrue(WoDe.checkIsOtherHomepage(driver), "检查成功他人主页！");     
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 收藏夹-添加收藏话题
	 * @
	 */
	@Test(priority = 12)
	public void wode_mycommunity_testcase12() {
		//请空收藏夹数据
		WoDe.setTopicCollectionEmpty(driver);
		//添加收藏话题
		BangMaiChe.addTopicCollection(driver);
		//进入我的社区-收藏夹查看
		WoDe.enterTopicCollectionPage(driver);
		//检查收藏话题成功
		Assert.assertTrue(Common.checkTextExist(driver, "topic btn action 6 nor"),"检查收藏话题成功！");
		//返回首页
		Common.multiBack(driver, 2);		
	}
	
	/**
	 * @function 收藏夹-页面跳转-他人主页
	 * @precondition 接续testcase12 已有话题收藏
	 * @
	 */
	@Test(priority = 13)
	public void wode_mycommunity_testcase13() {
		//进入我的社区-收藏夹					
		WoDe.enterTopicCollectionPage(driver);
		//页面跳转
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//检查进入成功进入他人主页
		Assert.assertTrue(WoDe.checkIsOtherHomepage(driver), "检查成功进入他人主页！");
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 收藏夹-页面跳转-话题详情页
	 * @precondition 接续testcase12 已有话题收藏
	 * @
	 */
	@Test(priority = 14)
	public void wode_mycommunity_testcase14() {
		//进入我的社区-收藏夹						
		WoDe.enterTopicCollectionPage(driver);
		//页面跳转
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");						
		//检查进入成功进入话题详情页
		Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "检查成功进入话题详情页！");
		//返回
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 收藏夹-点赞
	 * @precondition 接续testcase12 已有话题收藏
	 * @
	 */
	@Test(priority = 15)
	public void wode_mycommunity_testcase15() {
//		//进入我的社区-收藏夹						
//		WoDe.enterTopicCollectionPage(driver);
//	    //进行点赞
//		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[4]");//普通话题与投票话题xpath路径不一样	
//	    //检查点赞成功
//	    
//	    //返回首页
//		Common.multiBack(driver, 2);	
	}
		
	/**
	 * @function 收藏夹-评论
	 * @precondition 接续testcase12 已有话题收藏
	 * @
	 */
	@Test(priority = 16)
	public void wode_mycommunity_testcase16() {
		//进入我的社区-收藏夹						
		WoDe.enterTopicCollectionPage(driver);
		//进行评论
		Common.touchText(driver, "topic btn action 2 nor");
		Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "打酱油");
		Common.touchText(driver, "引用话题");
		Common.touchText(driver, "nav right close");
		Common.touchText(driver, "发布");
		//检查评论成功
		
		//返回首页
		Common.multiBack(driver, 2);	
	}
		
	
	/**
	 * @function 收藏夹列表-取消收藏
	 * @precondition 接续testcase12 已有话题收藏
	 * @
	 */
	@Test(priority = 17)
	public void wode_mycommunity_testcase17() {
		//进入我的社区-收藏夹						
		WoDe.enterTopicCollectionPage(driver);
		//取消收藏
		Common.touchText(driver, "topic btn action 6 nor");
		//检查取消收藏成功
		Assert.assertTrue(Common.checkTextExist(driver, "topic btn action 7 nor"), "检查取消收藏成功！");
		//返回首页
		Common.multiBack(driver, 2);	
	}
	
	/**
	 * @function 草稿箱-添加数据
	 * @
	 */
	@Test(priority = 18)
	public void wode_mycommunity_testcase18() {
		//清空草稿箱
		WoDe.setDraftsEmpty(driver);
		//进入帮买车，添加话题草稿
		BangMaiChe.addTopicDraft(driver);
		//进入我的-草稿箱查看
		WoDe.enterDraftsPage(driver);
		//检查草稿保存成功
		Assert.assertTrue(Common.checkTextExist(driver, "删除"),"检查保存草稿成功！");
		//返回首页
		Common.multiBack(driver, 2);		
	}
	
	/**
	 * @function 草稿箱-编辑话题
	 * @preconditon 接续testcase18 已有草稿
	 * @
	 */
	@Test(priority = 19)
	public void wode_mycommunity_testcase19() {
		//进入我的社区-草稿箱
		WoDe.enterDraftsPage(driver);
		//点击草稿
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");
		//检查进入编辑页面
		Assert.assertTrue(Common.checkTextExist(driver, "编辑话题"), "检查成功进入编辑页！");
		//返回首页
		Common.multiBack(driver, 3);
	}
	
	/**
	 * @function 草稿箱-删除话题
	 * @preconditon 接续testcase18 已有草稿
	 * @
	 */
	@Test(priority = 20)
	public void wode_mycommunity_testcase20() {
		//进入我的社区-草稿箱
		WoDe.enterDraftsPage(driver);
		//删除草稿
		Common.touchText(driver, "删除");
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
		//检查草稿删除成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无草稿"), "　检查成功删除话题草稿！");
		//返回首页
		Common.multiBack(driver, 2);
	}
	
	/**
	 * @function 草稿箱-重新发送
	 * @
	 */
	@Test(priority = 21)
	public void wode_mycommunity_testcase21() {
		//清空草稿箱
		WoDe.setDraftsEmpty(driver);
		//进入帮买车，添加话题草稿
		BangMaiChe.addTopicDraft(driver);
		//进入我的-草稿箱查看
		WoDe.enterDraftsPage(driver);		
		//点击发布
		Common.touchText(driver, "发布");
		//检查重新发布成功
		Assert.assertTrue(Common.checkTextExist(driver, "暂无草稿"), "检查重新发送草稿成功！");
		//返回首页
		Common.multiBack(driver, 2);		
	}
	
	/**
	 * @function 收到的赞-进入话题详情页
	 * @
	 */
	@Test(priority = 22)
	public void wode_mycommunity_testcase22() {
		//进入我的社区-收到的赞
		WoDe.enterReceivedPraisePage(driver);
		//如果有收到的赞，点击
		if(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			if(Common.checkTextExist(driver, "收到的赞")){
				System.out.println("该话题已删除");
				//返回首页
				Common.multiBack(driver, 2);
				}else{
					Assert.assertTrue(Common.checkTextExist(driver, "话题详情"),"检查进入话题详情页");
					//返回首页
					Common.multiBack(driver, 3);
				}
			}
	}
	
	/**
	 * @function 收到的赞-个人主页
	 * @
	 */
	@Test(priority = 23)
	public void wode_mycommunity_testcase23() {
		//进入我的社区-收到的赞
		WoDe.enterReceivedPraisePage(driver);
		//点击头像
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//检查进入个人主页
		Assert.assertTrue(WoDe.checkIsOtherHomepage(driver), "成功他人主页！");
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 收到的评论-进入话题详情页
	 * @
	 */
	@Test(priority = 24)
	public void wode_mycommunity_testcase24() {
		//进入我的社区-收到的评论
		WoDe.enterReceivedCommentPage(driver);
		//如果有收到的赞，点击
		if(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")){
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			if(Common.checkTextExist(driver, "收到的评论")){
				System.out.println("wode_mycommunity_testcase24:该话题已删除");
				//返回首页
				Common.multiBack(driver, 2);
				}else{
					Assert.assertTrue(Common.checkTextExist(driver, "话题详情"),"检查进入话题详情页");
					//返回首页
					Common.multiBack(driver, 3);
				}
			}
	}
		
	/**
	 * @function 收到的评论-个人主页
	 * @
	 */
	@Test(priority = 25)
	public void wode_mycommunity_testcase25() {
		//进入我的社区-收到的评论
		WoDe.enterReceivedCommentPage(driver);
		//点击头像
		Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
		//检查进入个人主页
		Assert.assertTrue(WoDe.checkIsOtherHomepage(driver), "成功他人主页！");
		//返回首页
		Common.multiBack(driver, 3);	
	}
	
	/**
	 * @function 收到的评论-评论
	 * @
	 */
	@Test(priority = 26)
	public void wode_mycommunity_testcase26() {
		//进入我的社区-收到的评论
		WoDe.enterReceivedCommentPage(driver);
		//点击评论
		Common.touchText(driver, "topic btn comment nor");
		if(Common.checkXpathExist(driver,"//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")){
			Common.sendText(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]"), "哈哈");
			Common.touchXpath(driver, "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");//点击发布
			//检查评论成功
			
			//返回首页
			Common.multiBack(driver,2);
		}else{
			System.out.println("wode_mycommunity_testcase26:该话题已删除");
			//返回首页
			Common.multiBack(driver, 2);
		}
	}
	
	/**
	 * @function 提到我的-话题详情页
	 * @
	 */
	@Test(priority = 27)
	public void wode_mycommunity_testcase27() {
		//进入我的社区-提到我的
		WoDe.enterMentionedMePage(driver);
		//点击进入话题详情页面
		if(Common.checkTextExist(driver, "暂无提到您的话题")){
			//返回首页
			Common.multiBack(driver, 2);
		}
		else{
//			Common.touchXpath(driver, "");
//			Assert.assertTrue(Common.checkTextExist(driver, "话题详情"), "成功进入话题详情页！");
//			//返回首页
//			Common.multiBack(driver, 3);	
		}
	}
	
	/**
	 * @function 提到我的-他人主页
	 * @
	 */
	@Test(priority = 28)
	public void wode_mycommunity_testcase28() {
		//进入我的社区-提到我的
		WoDe.enterMentionedMePage(driver);
		//点击进入他人主页
		if(Common.checkTextExist(driver, "暂无提到您的话题")){
			//返回首页
			Common.multiBack(driver, 2);
		}
		else{
//			Common.touchXpath(driver, "");
//			Assert.assertTrue(WoDe.checkIsOtherHomepage(driver), "检查成功他人主页！");
			//返回首页
//			Common.multiBack(driver, 3);
		}
	}
	
	/**
	 * @function 社区通知
	 * @
	 */
	@Test(priority = 29)
	public void wode_mycommunity_testcase29() {
		//进入我的社区-社区通知
		WoDe.enterCommunityNotificationPage(driver);
		//检查进入社区通知成功
		Assert.assertTrue(Common.checkTextExist(driver, "社区通知"), "检查成功进入社区通知！");
		//返回首页
		Common.multiBack(driver, 2);	
	}

}

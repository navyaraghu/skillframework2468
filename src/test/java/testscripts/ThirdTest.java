package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class ThirdTest extends BaseClass
{
	@Test
	public void thirdTest()
	{
		SoftAssert soft=new SoftAssert();
		home.searchFor("core java for selenium");
		soft.assertEquals(coreJava.getPageHeader(),"CORE JAVA FOR SELENIUM");
		coreJava.clickCoreJavaForSeleniumLink();
		soft.assertEquals(video.getPageHeader(),"Core Java For Selenium Training");
		video.clickCancelCookies();
		web.switchToFrame();
		video.clickPlayButton();
		video.clickPauseButton();
		web.switchBackFromFrame();
		video.clickAddToWishListTab();
		soft.assertAll();
	}

}

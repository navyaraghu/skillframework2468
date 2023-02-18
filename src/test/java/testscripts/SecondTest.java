package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class SecondTest extends BaseClass 
{
	@Test
	public void secondTest() 
	{
		SoftAssert soft=new SoftAssert();
		Assert.assertTrue(home.getLogo().isDisplayed());
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.childBrowserPopup();
		soft.assertTrue(demo.getPageHeader().isDisplayed());
		demo.selectCatagory(web, 1);
		soft.assertEquals(testing.getPageHeader(),"Testing");
		
		web.dragAndDrop(testing.getSeleniumImage(), testing.getCartArea());
		web.scrollByElement(testing.getFacebookIcon());
		testing.clickFacebookIcon();
		soft.assertAll();
		
	}

}

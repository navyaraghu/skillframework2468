package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class FirstTest extends BaseClass
{
@Test
public void firstTest() {
	SoftAssert soft=new SoftAssert();
	Assert.assertTrue(home.getLogo().isDisplayed());
	home.clickGearsTab();
	home.clickSkillraryDemoApp();
	web.childBrowserPopup();
	soft.assertTrue(demo.getPageHeader().isDisplayed());
	demo.mouseHoverToCourse(web);
	demo.clickSeleniumTrainingLink();
	soft.assertEquals(training.getPageHeader(), "Selenium Training");
	training.doubleClickPlusButton(web);
	training.clickAddToCartButton();
	web.alertAccept();
	soft.assertEquals(training.getItemAddedMessage(), "Item added to cart");
	soft.assertAll();
}
}

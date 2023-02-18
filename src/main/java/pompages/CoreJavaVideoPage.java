package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaVideoPage 
{
//Declaration
	@FindBy(xpath="//a[@class='close_cookies']") private WebElement cancelCookies;
	@FindBy(xpath="//h1[text()='Core Java For Selenium Training']") private WebElement pageHeader;
	@FindBy(xpath="//button[@aria-label='Play']") private WebElement playButton;
	@FindBy(xpath="//button[@aria-label='Pause']") private WebElement pauseButton;
	@FindBy() private WebElement addToWishListTab;
	
//Initialization 
public 	CoreJavaVideoPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

//Utilization
public String getPageHeader() {
	return pageHeader.getText();
}

public void clickPlayButton() {
	playButton.click();
}
public void clickPauseButton() {
	pauseButton.click();
}
public void clickAddToWishListTab() {
	addToWishListTab.click();
}
public void clickCancelCookies() {
	cancelCookies.click();
}
}

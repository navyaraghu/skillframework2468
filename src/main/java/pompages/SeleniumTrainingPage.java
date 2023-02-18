package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class SeleniumTrainingPage
{
@FindBy(xpath="//h1[text()='Selenium Training']") private WebElement pageHeader;
@FindBy(id="add") private WebElement plusButton;
@FindBy(xpath="//button[contains(.,'Add to Cart')]") private WebElement addToCartButton;
@FindBy(xpath="//span[text()='Item added to cart']") private WebElement itemAddedMessage;

//Intialization
public SeleniumTrainingPage(WebDriver driver) 
{
PageFactory.initElements(driver, this);	
}

//Utilization

public String getPageHeader() {
	return pageHeader.getText();
}
public void doubleClickPlusButton(WebDriverUtility web) {
	web.doubleClick(plusButton);
}
public void clickAddToCartButton() {
	addToCartButton.click();
}
public String getItemAddedMessage() {
	return itemAddedMessage.getText();
}
}

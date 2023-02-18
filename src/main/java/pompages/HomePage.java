package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
//Declaration
	@FindBy(xpath="//img[@alt='SkillRary']") private WebElement logo;
	@FindBy(name="q") private WebElement searchField;
	@FindBy(xpath="//input[@value='go']") private WebElement searchButton;
	@FindBy(xpath="//a[text()=' GEARS ']") private WebElement gearsTab;
	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/descendant::a[.=' SkillRary Demo APP']") private WebElement skillraryDemoApp;
	
//Intialization
	public HomePage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	}
	
//Utilization
	public WebElement getLogo() {
		return logo;
	}
	
	public void searchFor(String data) {
		searchField.sendKeys(data);
		searchButton.click();
	}
	public void clickGearsTab() {
		gearsTab.click();
	}
	
	public void clickSkillraryDemoApp() {
		skillraryDemoApp.click();
	}
	
}

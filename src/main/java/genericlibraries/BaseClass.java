package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.CoreJavaForSeleniumPage;
import pompages.CoreJavaVideoPage;
import pompages.HomePage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

public class BaseClass 
{
	protected PropertiesFileUtility property;
	protected ExcelFileUtility excel;
	protected WebDriverUtility web;
	protected ContactUsPage contact;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage video;
	protected HomePage home;
	protected SeleniumTrainingPage training;
	protected SkillraryDemoAppPage demo;
	protected TestingPage testing;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	
	
	public void classConfiguration() {
		
		property=new PropertiesFileUtility();
		excel=new ExcelFileUtility();
		web=new WebDriverUtility();
		
		property.propertyFileInitialization(IConstantpath.PROPERTIES_FILE_PATH);
		excel.excelIntialization(IConstantpath.EXCEL_FILE_PATH);
		
	}
	
	@BeforeMethod
	public void methodConfiguration() 
	{
		long time=Long.parseLong(property.fetchProperty("timeouts"));
		WebDriver driver=web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		contact=new ContactUsPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		video=new CoreJavaVideoPage(driver);
		home=new HomePage(driver);
		
		training=new SeleniumTrainingPage(driver);
		demo=new SkillraryDemoAppPage(driver);
		testing=new TestingPage(driver);	
	}
	@AfterMethod
	public void methodTeardown() {
		web.closeAll();
	}
	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
	//@AfterTest
//	@AfterSuite
	
	

}

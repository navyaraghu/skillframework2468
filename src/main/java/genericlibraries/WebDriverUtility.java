package genericlibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
WebDriver driver;
public WebDriver openApplication(String Browser, String url, long time) 
{
	switch(Browser) 
	{
	case "chrome":driver=new ChromeDriver();break;
	case "firefox":driver=new FirefoxDriver();break;
	case "edge":driver=new EdgeDriver();break;
	default:System.out.println("Invalid Browser");
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	return driver;
}
public void explicitlyWait(long time, WebElement Element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
	wait.until(ExpectedConditions.visibilityOf(Element));
}
public void mouseHover(WebElement element) 
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
}
public void doubleClick(WebElement element) 
{
	Actions a=new Actions(driver);
	a.doubleClick(element).perform();
}
public void rightClick(WebElement element) {
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
}
public void dragAndDrop(WebElement src, WebElement dest) 
{
	Actions a=new Actions(driver);
	a.dragAndDrop(src, dest);
}
public void dropdown(WebElement element, int index) 
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
public void dropdown(WebElement element, String text) 
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
public void dropdown(String value,WebElement element) 
{
	Select s=new Select(element);
	s.selectByValue(value);
}
public String getParentWindowID() {
	return driver.getWindowHandle();
}
public void childBrowserPopup() {
	Set<String> set=driver.getWindowHandles();
	for(String window:set)
	{
		driver.switchTo().window(window);
	}
}
public void switchToFrame() {
	driver.switchTo().frame(0);
}
public void switchToFrame(String attriute) {
	driver.switchTo().frame(attriute);
}
public void switchBackFromFrame()
{
	driver.switchTo().defaultContent();
}
public void alertAccept() {
	driver.switchTo().alert().accept();
}
public void alertDismiss() {
	driver.switchTo().alert().dismiss();
}
public void alertgetText() 
{
	driver.switchTo().alert().getText();
}
public void scrollByElement(WebElement element) 
{
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)", element);
}
public void takesScreenshot() 
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/picture.png");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public ChromeOptions disableNotification() {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	return options;
}
public void close() {
	driver.close();
}
public void closeAll() {
	driver.quit();
}


}

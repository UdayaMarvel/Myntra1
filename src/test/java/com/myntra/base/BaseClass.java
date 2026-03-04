package com.myntra.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass implements IBaseClass {
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor js;
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Myntra1\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		 js = (JavascriptExecutor)driver;
	}
	
	public void browserClose() {
		driver.quit();
	}
	
	
	public void applicationLaunch(String string) {
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void sendText(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public String retrieveText(WebElement ele) {
		String text = ele.getText();
		return text;
	}
	 public void waitForVisibility(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	
	public String retrieveAttribute(WebElement ele, String attr) {
		String attribute = ele.getAttribute(attr);
		return attribute;
	}
	
	public boolean displayed(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		return displayed;
	}
	
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public void sendText(String value, WebElement ele) {
		action.sendKeys(value).build().perform();
	}
	
	public void clickOnElement(WebElement ele, int i) {
		action.click(ele).build().perform();
	}
	public void sendText(String value, WebElement ele, int j) {
		js.executeScript("arguments[0].setAttribute('value','"+value+"');", ele);
	}
	
	public void clickOnElement(int x, WebElement ele) {
		js.executeScript("arguments[0].click();", ele);
	}
	
	public List<WebElement> retrieveOptions(WebElement ele) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	public static String getCurrentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public void switchToWindow(String parent) {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handles : windowHandles) {
			if(!parent.equals(handles)) {
				driver.switchTo().window(handles);
			}
		}
	}
}

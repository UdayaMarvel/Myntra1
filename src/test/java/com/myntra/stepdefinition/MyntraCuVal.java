package com.myntra.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.myntra.base.BaseClass;
import com.myntra.objectRepository.FiltersLocators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MyntraCuVal extends BaseClass  {

	BaseClass base = new BaseClass();
	public static  WebDriver webdriver;
	public static Actions action;
	
	@When("Select the men option")
	public void select_the_men_option() {
	   WebElement men=	webdriver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]//preceding::div//a[text()='Men']"));
	   action.moveToElement(men).build().perform();
	   	}
	
	@When("select clicks on T-shirts:")
	public void select_clicks_on_t_shirts() {
		webdriver = Filters.driver;
		 Actions action =new Actions(webdriver);
		WebElement tshirt=webdriver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]//preceding::div//a[text()='Men']//following::a[2]"));
	    String gotval=tshirt.getAttribute("value");
	    System.out.println(gotval);
		action.moveToElement(tshirt).click().build().perform();	
		}
	
	@Then("Validate the Tshirt page loaded")
	public void validate_the_tshirt_page_loaded() {
		WebElement tshirt_val=webdriver.findElement(By.xpath("//div//span[text()='Categories']//following::li//input[@value='Tshirts']"));
		String valu=tshirt_val.getAttribute("value");
	System.out.println(valu);
	if(	valu.contains("Tshirt"))
		{
			System.out.println("correct page");
		}
			 	}

	@When("clicks on the brands")
	public void clicks_on_the_brands() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement brand = webdriver.findElement(By.xpath("//div//span[text()='Brand']"));
		JavascriptExecutor js =(JavascriptExecutor) webdriver;
		js.executeScript("arguments[0].scrollIntoView(true)", brand);
		WebElement  select_brand=webdriver.findElement(By.xpath("//li//input[@value='WOOSTRO']"));
		 Actions action =new Actions(webdriver);
		 action.click(select_brand).build().perform();
		 Thread.sleep(2000);
	}
	
@When("selecting discount range")
public void selecting_discount_range() throws InterruptedException, AWTException {
	WebElement discount = webdriver.findElement(By.xpath("//div//span[text()='Discount Range']"));
	WebElement radio =webdriver.findElement(By.xpath("//input[@type='radio' and contains(@value,'60.0 TO 100')]"));
	Actions action =new Actions(webdriver);
	action.moveToElement(radio).build().perform();
	Thread.sleep(5000);
	action.click(radio).perform();
}

}

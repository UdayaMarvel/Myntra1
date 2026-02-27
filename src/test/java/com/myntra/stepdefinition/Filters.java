package com.myntra.stepdefinition;

import java.lang.module.ModuleDescriptor.Builder;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.myntra.base.BaseClass;
import com.myntra.objectRepository.FiltersLocators;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Filters extends BaseClass{

	BaseClass base = new BaseClass();
	FiltersLocators locators = new FiltersLocators();
	public static WebDriver driver;
	public static Actions action;
	
	@Given("Launch the Myntra Application {string}")
	public void launch_the_myntra_application(String string) {
		driver = base.driver;
		action = base.action;
	
		base.applicationLaunch(string);
	}
	@When("User mouse over to Men")
	public void user_mouse_over_to_men() {
	   locators.mouseOverToMen();
	}

	@When("User clicks on T-Shirts")
	public void user_clicks_on_t_shirts() {
	   locators.clickOnTshirts();
	}

	@Then("Validate the T-Shirts page loaded")
	public void validate_the_t_shirts_page_loaded() {
		locators.verifyNavigatedToTshirts();
	}
	
	@When("User clicks on Categories with one dim list")
	public void user_clicks_on_categories_with_one_dim_list(DataTable dataTable) {
		List<String> asList = dataTable.asList();
		String tshirt = asList.get(1);
		 WebElement lounge = driver.findElement(By.xpath("//input[@value='"+tshirt+"']"));
		    action.click(lounge).perform();
	}

	@Then("Validate the filters with one dim map")
	public void validate_the_filters_with_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> asMap = dataTable.asMap(String.class, String.class);
	String tshirt = asMap.get("Filter2");
	 WebElement lounge = driver.findElement(By.xpath("//div[text()='"+tshirt+"']"));
	   String text = lounge.getText();
	   if(text.contains(tshirt)) {
		   System.out.println("Lounge T Shirts Category");
	   }
	}
	
	@When("User clicks on Categories {string}")
	public void user_clicks_on_categories(String string) {
		 WebElement lounge = driver.findElement(By.xpath("//input[@value='"+string+"']"));
		    action.click(lounge).perform();
	}

	@Then("Validate the filters {string}")
	public void validate_the_filters(String string) {
		 WebElement lounge = driver.findElement(By.xpath("//div[text()='"+string+"']"));
		   String text = lounge.getText();
		   if(text.contains(string)) {
			   System.out.println("Filtered with "+string+" Category");
		   }
	}


	@Then("Verify the count matches the products")
	public void verify_the_count_matches_the_products() {
	    int count = 0;
	    count = locators.getProds().size();
	   	JavascriptExecutor js = (JavascriptExecutor)driver;
	    action.moveToElement(locators.getCountOfPage()).build().perform();
	    String text = locators.getCountOfPage().getText();
	    String[] split = text.split(" ");
	    int pageCount = Integer.parseInt(split[split.length-1]);
	    for(int i= 1; i<= pageCount;i++) {
	 
		    if(locators.getNextButton().isDisplayed()&&locators.getNextButton().isEnabled()) {
		    	action.moveToElement(locators.getNextButton()).build().perform();
		    	action.click(locators.getNextButton()).perform();
		    }
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    
	    	count = count + locators.getProds().size();
	    }
	    
	    System.out.println(count);
	}
}

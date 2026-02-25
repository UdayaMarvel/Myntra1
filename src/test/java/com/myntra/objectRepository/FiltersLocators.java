package com.myntra.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.BaseClass;
import com.myntra.base.IBaseClass;

public class FiltersLocators extends BaseClass implements IBaseClass{

	public WebElement getMen() {
		return men1;
	}

	public WebElement gettShirts() {
		return tShirts;
	}

	public WebElement getHeader() {
		return header;
	}

	public List<WebElement> getProds() {
		return prods;
	}

	public WebElement getCountOfPage() {
		return countOfPage;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	BaseClass base = new BaseClass();
	
	public FiltersLocators() {
		PageFactory.initElements(base.driver, this);
	}
	
	@FindBy(xpath = men)
	private WebElement men1;
	
	@FindBy(xpath = "//a[text()='Men']/following-sibling::div/descendant::a[text()='T-Shirts']")
	private WebElement tShirts;
	
	@FindBy(xpath = "//span[text()='Men T-shirts']")
	private WebElement header;
	
	@FindBy(xpath = "//li[@*='product-base']")
	private List<WebElement> prods;
	
	@FindBy(xpath = "//li[contains(text(),'Page 1 of ')]")
	private WebElement countOfPage;
	
	@FindBy(xpath = "//li[text()='Next']")
	private WebElement nextButton;

	public void clickOnTshirts() {
		if(gettShirts().isDisplayed()) {
			Actions action = new Actions(base.driver);
			action.click(gettShirts()).build().perform();
		}
	}
	
	public void mouseOverToMen() {
		if(getMen().isDisplayed()){
			Actions action = new Actions(base.driver);
			action.moveToElement(getMen()).build().perform();
		}
	}
	
	public void verifyNavigatedToTshirts() {
		
		if(base.retrieveText(getHeader()).contains("T-shirts")) {
			   System.out.println("Navigated to T Shirts page");
		   }
	}	   

}

package com.myntra.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.myntra.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	// BaseClass base = new BaseClass();
	
	@Before
	public void initialisation(Scenario scenario) {
		browserLaunch(); //launching the browser with object creation
		final byte[] start = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(start, "image/png", "BrowserStarts");
	}
	
	
	@After
	public void closeInstance(Scenario scenario) {
		final byte[] start = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(start, "image/png", "BrowserEnd");
		browserClose(); //closing the browser with object creation
	}

}

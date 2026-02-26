package com.myntra.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.myntra.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	
	@Before
	public void initialisation(Scenario scenario) {
		browserLaunch();
		final byte[] start = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(start, "image/png", "BrowserStart");
	
	}
	
	
	@After
	public void closeInstance(Scenario scenario) {
		final byte[] start = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(start, "image/png", "BrowserStart");
		browserClose();
	}

}

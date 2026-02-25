package com.myntra.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "D:\\Workspace\\Myntra1\\src\\test\\resources\\Features",
					glue = {"com.myntra.stepdefinition","com.myntra.hooks"},
					monochrome = true,
					dryRun = false,
					plugin = {"html:target\\index.html","json:target\\report.json"},
					tags = "@Filters")
public class TestRunner {

}

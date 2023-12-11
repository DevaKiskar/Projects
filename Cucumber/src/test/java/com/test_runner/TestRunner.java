package com.test_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
	features= "src/test/resources/features", //feature directory or location. 
	glue="stepdefinition", //stepdefinition package name.
	dryRun = false,
	monochrome =true
		)

public class TestRunner {


}

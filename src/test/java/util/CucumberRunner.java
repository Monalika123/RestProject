package util;

import cucumber.api.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true, features = {
"resources" }, glue = "stepdefs", plugin = { "pretty", "html:target/reports",
		"json:target/cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:" }, tags = { "@SmokeTest" })

public class CucumberRunner {

}

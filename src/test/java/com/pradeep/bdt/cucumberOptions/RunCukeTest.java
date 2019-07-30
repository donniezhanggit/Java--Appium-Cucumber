package com.pradeep.bdt.cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, strict = true, features = "src/test/java/com/pradeep/bdt/features",
        glue = "src/test/java/com/pradeep/bdt/stepDefinitions",
        tags = { "@executeThis" }, monochrome = true,
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        format = { "pretty", "html:target/cucumber", "json:target_json/cucumber.json", "junit:taget_junit/cucumber.xml" }
)

public class RunCukeTest{

}

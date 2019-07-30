package com.pradeep.bdt;

import java.io.File;
import java.net.MalformedURLException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.Reporter;
import org.junit.AfterClass;

public class Hooks extends DriverFactory {

    DriverFactory at = new DriverFactory();

    @Before
    public void beforeScenario() throws MalformedURLException, InterruptedException {
        at.createDriver();
    }


    @After
    public void afterScenario() {
        {
            at.teardown();
        }
    }

}

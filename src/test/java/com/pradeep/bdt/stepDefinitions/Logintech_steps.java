package com.pradeep.bdt.stepDefinitions;

import com.pradeep.bdt.DriverFactory;
import com.pradeep.bdt.pages.Android.Logintech;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;

public class Logintech_steps {
    DriverFactory df = new DriverFactory();
    Logintech test = new Logintech();

    @Given("^user is on Application Home Page$")
    public void user_is_on_Application_Home_Page() throws Throwable {
        test.verifyHomePage();
    }

    @When("^user choose movie \"(.*)\"$")
    public void userChooseMovie(String movieName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        test.click_movie(movieName);
    }

    @Then("^\"(.*)\" movie detail page displayed$")
    public void movieDetailPageDisplayed(String movieName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        test.verify_movieDetailPage(movieName);
    }

    @Then("^I verify movie \"(.*)\" appeared in home screen$")
    public void iVerifyMovieAppearedInHomeScreen(String movieName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        test.click_movie(movieName);
    }

    @When("^user tap on movie co-ordinates \"(.*)\"$")
    public void userTapOnMovie(String movieName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        test.tapByCoordinates(366,606);
        test.contains_text(movieName);
    }
}
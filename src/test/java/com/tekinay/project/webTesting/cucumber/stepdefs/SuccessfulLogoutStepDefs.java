package com.tekinay.project.webTesting.cucumber.stepdefs;

import com.tekinay.project.webTesting.pom.pages.HomePage;
import com.tekinay.project.webTesting.pom.pages.SignupLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessfulLogoutStepDefs {
    private static HomePage homePage;
    private static SignupLoginPage signupLogin;
    private static WebDriver driver = BackgroundStepdefs.getDriver();

    @Given("I have launched the browser and navigated to the correct URL")
    public void iHaveLaunchedTheBrowserAndNavigatedToTheCorrectURL() {
        homePage = new HomePage(driver);
    }

    @When("I click on the correct Login button")
    public void iClickOnTheCorrectLoginButton() {
        signupLogin = homePage.goToSignUPLoginPage();
    }

    @Then("I should see Login to your account displayed on the page")
    public void iShouldSeeLoginToYourAccountDisplayedOnThePage() {
        signupLogin.isTheLoginToYourAccountMessageDisplayed();
        assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
    }

    @When("I enter my correct email address and password")
    public void iEnterMyCorrectEmailAddressAndPassword() {
        signupLogin.enteringIncorrectEmailAndPassword();
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        signupLogin.clickingActualLoginButton();
    }

    @Then("I should see Logged in as username displayed on the page")
    public void iShouldSeeLoggedInAsUsernameDisplayedOnThePage() {
        signupLogin.checkThatTheUsernameOnTheTopIsCorrect();
    }

    @When("I click on the Logout button")
    public void iClickOnTheLogoutButton() {
        signupLogin.clickTheLogoutButton();
    }

    @Then("I should be navigated to the login page")
    public void iShouldBeNavigatedToTheLoginPage() {
        assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
    }
}
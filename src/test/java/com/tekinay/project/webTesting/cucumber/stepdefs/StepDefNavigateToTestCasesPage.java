package com.tekinay.project.webTesting.cucumber.stepdefs;

import com.tekinay.project.webTesting.pom.pages.HomePage;
import com.tekinay.project.webTesting.pom.pages.TestCasesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefNavigateToTestCasesPage {
    private static WebDriver driver = BackgroundStepdefs.getDriver();
    private static HomePage homePage;

    private static TestCasesPage testCasesPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = new HomePage(driver);
    }

    @When("I click the Test Cases button")
    public void iClickTheTestCasesButton() {
        testCasesPage = homePage.goToTestCasesPage();
    }

    @Then("I should be directed to the test_cases page")
    public void iShouldBeDirectedToTheTest_casesPage() {
        assertEquals("https://automationexercise.com/test_cases", testCasesPage.getUrl());
    }


}

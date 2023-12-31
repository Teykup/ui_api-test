package com.webTesting.cucumber.stepdefs;

import com.webTesting.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithCorrectDetails {
    private HomePage homePage;
    private static WebDriver driver = BackgroundStepdefs.getDriver();
    private static String name = "Onur Belek";
    private static String email = "onur123@gmail.com";
    private static String password = "lmao";


    @Given("I am on the Index Page")
    public void iAmOnTheIndexPage() {
        homePage = new HomePage(driver);
    }

    @When("I press the login button")
    public void iPressTheLoginButton() {
        WebElement signupLoginButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signupLoginButton.click();
    }

    @Then("I should see Login to your account displayed")
    public void iShouldSeeLoginToYourAccountDisplayedOnThePage() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed(), "Login Account is not displayed!");
    }

    @When("I enter my correct email and password")
    public void iEnterMyCorrectEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(password);
    }

    @And("I click on the Login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
    }

    @Then("I should see Logged in as username displayed on page")
    public void iShouldSeeLoggedInAsUsernameDisplayedOnPage() {
        assertTrue(driver.findElement(By.xpath("//*[contains(text(), '" + name + "')]")).isDisplayed(), "Element with Logging in as username is not displayed on the page");
    }
}
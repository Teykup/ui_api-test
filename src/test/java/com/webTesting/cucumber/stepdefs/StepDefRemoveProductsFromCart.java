package com.webTesting.cucumber.stepdefs;

import com.webTesting.pom.pages.CartPage;
import com.webTesting.pom.pages.CheckoutPage;
import com.webTesting.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class StepDefRemoveProductsFromCart {


    private static WebDriver driver = BackgroundStepdefs.getDriver();

    private HomePage homePage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;

    @Given("I launch the browser")
    public void iLaunchWebsite() {
        Assert.assertEquals(WebDriver.class, driver.getClass());
    }

    @When("I navigate to the Homepage")
    public void iNavigateToTheUrlHttpAutomationexerciseCom() {
        homePage = new HomePage(driver);
    }

    @Then("the homepage is displayed successfully")
    public void theHomePageIsDisplayedSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/",homePage.getUrl());
    }


    @And("I add products to cart")
    public void iAddProductsToCart() {
        homePage.addToCart();
    }

    @And("I click the cart button")
    public void iClickTheCartButton() {
        cartPage = homePage.goToCartPage();

    }

    @Then("the cart page is displayed successfully")
    public void theCartPageIsDisplayedSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/view_cart", cartPage.getUrl());
    }

    @When("I click the X button corresponding to a particular product")
    public void iClickTheXButtonCorrespondingToAParticularProduct() {
     cartPage.deleteItemFromCart();
    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
        Assert.assertEquals("Cart is empty!", cartPage.checkCartIsEmpty());
    }
}

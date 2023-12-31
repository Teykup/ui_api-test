package com.webTesting.cucumber.stepdefs;

import com.webTesting.pom.pages.HomePage;
import com.webTesting.pom.pages.CartPage;
import com.webTesting.pom.pages.ProductsPage;
import com.webTesting.pom.util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class StepDefsProductsInCart {

    private static WebDriver driver;
    private static HomePage homePage;
    private static ProductsPage productPage;
    private static CartPage cart;

    @Given("I am on the main page")
    public void iAmOnTheHomePage() {
        //DO NOT CHANGE TO BACKGROUND STEP DEFS
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @When("I click products button")
    public void iClickProductsButton() {
        productPage = homePage.goToProductsPage();
    }

    @Then("I am redirected to product page")
    public void iAmRedirectedToProductPage() {
        productPage.turnOffAd();
        Assertions.assertEquals("https://automationexercise.com/products", productPage.getURL());
    }

    @When("I add product to the cart")
    public void iAddProductToTheCart() {
        productPage = homePage.goToProductsPage();
        productPage.AddProductToCart("1", "2");//add to cart method
    }

    @And("I click continue shopping button")
    public void iClickContinueShoppingButton() {
        productPage.continueShopping();
    }

    @And("I add second product to the cart")
    public void iAddSecondProductToTheCart() {
        productPage.goToProductsPage();
        productPage.AddProductToCart("2", "1");
    }

    @Then("two product should be in the cart")
    public void twoProductShouldBeInTheCart() {
        productPage.goToProductsPage();
        cart = productPage.goToCartPage();
        Assertions.assertEquals(2, cart.checkNumberOfProductsInCart());
    }

    @When("I go to cart")
    public void iAmOnTheCartPage() {
        cart = productPage.goToCartPage();
        Assertions.assertEquals("https://automationexercise.com/view_cart", cart.getUrl());
    }

    @And("products are in the cart")
    public void productsAreInTheCart() {
        Assertions.assertEquals(2, cart.checkNumberOfProductsInCart());
    }

    @Then("I check if price, quantity and total price is correct")
    public void iCheckIfAmount() {
        Assertions.assertEquals(500, cart.returnPrice("1"));
        Assertions.assertEquals(2, cart.returnQuantity("1"));
        Assertions.assertTrue(cart.checkIfTotalPriceIsCorrect(cart.returnPrice("1"), cart.returnQuantity("1"), cart.returnTotal("1")));
        Assertions.assertEquals(400, cart.returnPrice("2"));
        Assertions.assertEquals(1, cart.returnQuantity("2"));
        Assertions.assertTrue(cart.checkIfTotalPriceIsCorrect(cart.returnPrice("2"), cart.returnQuantity("2"), cart.returnTotal("2")));

    }

    @When("I add {int} units of the same product to cart")
    public void iAddUnitsOfTheSameProductToCart(int arg0) {
        productPage.turnOffAd();
        productPage.AddProductToCart("1", String.valueOf(arg0));
        productPage.continueShopping();

    }

    @Then("Cart should have {int} same items")
    public void cartShouldHaveSameItems(int arg0) {
        Assertions.assertEquals(arg0, cart.returnQuantity("1"));
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}

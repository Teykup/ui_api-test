package com.tekinay.project.webTesting.cucumber.stepdefs;

import com.tekinay.project.webTesting.pom.pages.ProductDetailsPage;
import com.tekinay.project.webTesting.pom.pages.ProductsPage;
import com.tekinay.project.webTesting.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsStepDefs {

  private static WebDriver driver = BackgroundStepdefs.getDriver();
  private static HomePage homePage;

  private static ProductsPage productsPage;
  private ProductDetailsPage productDetailsPage;
  private static WebElement inputForm;

  @Given("I am on the Automation Exercise homepage")
  public void iAmOnTheAutomationExerciseHomepage() {
    driver.manage().window().maximize();
    homePage = new HomePage(driver);
  }

  @When("I click on the Products button")
  public void iClickOnTheProductsButton() {
    productsPage = homePage.goToProductsPage();
  }

  @Then("the products list is visible")
  public void theProductsListIsVisible() {
    Assertions.assertTrue(productsPage.getProductsList());
  }

  @Given("I am on the Products page")
  public void iAmOnTheProductsPage() {
    driver = BackgroundStepdefs.getDriver();
    homePage = new HomePage(driver);
    productsPage = homePage.goToProductsPage();
    Assertions.assertEquals("https://automationexercise.com/products", productsPage.getURL());
  }

  @When("I click on the view product button for the first product")
  public void iClickOnTheViewProductButtonForTheFirstProduct() {
    productDetailsPage = productsPage.goToProductDetails();
  }

  @Then("then I see a page with details about the product")
  public void thenISeeAPageWithDetailsAboutTheProduct() {
//    System.out.println(productDetails.productInfoDivDisplayed());
  }

  @When("I enter a product name and click search button")
  public void iEnterAProductNameAndClickSearchButton() {
  }

  @Then("the text SEARCHED PRODUCTS is visible")
  public void theTextSEARCHEDPRODUCTSIsVisible() {
  }

  @And("all products related to search are visible")
  public void allProductsRelatedToSearchAreVisible() {
  }
}

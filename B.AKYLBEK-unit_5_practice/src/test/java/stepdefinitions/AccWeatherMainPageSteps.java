package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccuweatherMainPage;

import static io.qameta.allure.Allure.step;

public class AccWeatherMainPageSteps {
    AccuweatherMainPage accuweatherMainPage = new AccuweatherMainPage();

    @Given("I open the Weather page")
    public void openWeatherPage(){
        step("Open the Weather page");
        Assert.assertTrue(accuweatherMainPage.state().waitForDisplayed(), "Main page is not displayed"); }

    @When("I input {string} in the search field")
    public void inputCity(String city){
        step("Input " + city + " in the search field");
        accuweatherMainPage.typeCity(city);
    }

    @Then("search results are displayed")
    public void verifySearchResults(){
        step("Verify that search results are displayed");
        Assert.assertTrue(accuweatherMainPage.isSearchResultsDisplayed(),
                "Search results are not displayed");
    }

    @And("I click on the first search result")
    public void clickFirstResult(){
        step("Click on the first search result");
        accuweatherMainPage.clickFirstSearchResult();
    }

    @And("I navigate back to the main page")
    public void navigateBackToMainPage() {
        step("Navigate back to the main page");
        AqualityServices.getBrowser().goBack();
    }

    @Then("Main page is displayed")
    public void verifyMainPage() {
        step("Verify that Main page is displayed");
        Assert.assertTrue(accuweatherMainPage.state().waitForDisplayed(),
                "Main page is not displayed");
    }

    @When("I choose the first city in Recent locations")
    public void chooseFirstRecentLocation() {
        step("Choose the first city in Recent locations");
        accuweatherMainPage.chooseFirstRecentLocation();
    }

    @When("I click the search field")
    public void clickSearchField() {
        step("Click the search field");
        accuweatherMainPage.clickSearchField();
    }

    @Then("the Use your current location label is displayed")
    public void verifyCurrentLocationLabel() {
        step("Verify that 'Use your current location' label is displayed");
        Assert.assertTrue(accuweatherMainPage.isCurrentLocationLabelDisplayed(),
                "'Use your current location' label is not displayed.");
    }
}
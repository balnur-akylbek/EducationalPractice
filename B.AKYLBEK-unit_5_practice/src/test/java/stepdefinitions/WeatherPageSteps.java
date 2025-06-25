package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.WeatherPage;

import static io.qameta.allure.Allure.step;

public class WeatherPageSteps {
    WeatherPage weatherPage = new WeatherPage();

    @Then("the city weather page header contains {string}")
    public void checkCityWeatherHeader (String cityName) {
        step("Check that the city weather page header contains " + cityName);
        Assert.assertTrue(weatherPage.getHeaderText().contains(cityName),
                "Header does not contain the expected city name. Header text: "
                        + weatherPage.getHeaderText());

    }
}
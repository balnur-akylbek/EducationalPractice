package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

public class AccuweatherMainPage extends Form {

    private final ITextBox searchField = AqualityServices.getElementFactory().getTextBox(
            By.className("search-input"),
            "Search Input Field"
    );

    private final ILabel recentLocation = AqualityServices.getElementFactory().getLabel(
            By.cssSelector(".featured-locations__locations-wrapper .recent-location-item:first-of-type"),
            "First Recent Location"
    );

    private final ILabel currentLocationLabel = AqualityServices.getElementFactory().getLabel(
            By.xpath("//div[contains(@class,'search-bar-result current-location-result')]"),
            "Use Your Current Location Label"
    );

    private final ILabel resultsContainer = AqualityServices.getElementFactory().getLabel(
            By.xpath("//*[contains(@class,'results-container')]"),
            "Results Container"
    );

    private final ILabel firstResult = resultsContainer.findChildElement(
            By.xpath(".//*[contains(@class,'search-bar-result__name')]"),
            ElementType.LABEL
    );

    public AccuweatherMainPage() {
        super(By.xpath("//div[contains(@class,'banner-button policy-accept')]"), "Main Page");
    }

    public void clickFirstSearchResult() {
        firstResult.click();
    }

    public void chooseFirstRecentLocation() {
        recentLocation.click();
    }

    public void typeCity(String cityName) {
        searchField.clearAndType(cityName);
    }

    public boolean isSearchResultsDisplayed() {
        return resultsContainer.state().waitForDisplayed();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public boolean isCurrentLocationLabelDisplayed() {
        return currentLocationLabel.state().waitForDisplayed(Duration.ofSeconds(10));
    }
}

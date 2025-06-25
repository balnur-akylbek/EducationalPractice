package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WeatherPage extends Form {

    private final ILabel headerLabel = AqualityServices.getElementFactory().getLabel(
            By.xpath("//*[contains(@class, 'header-loc')]"),
            "Weather Page Header"
    );

    public WeatherPage() {
        super(By.xpath("//*[contains(@class, 'header-loc')]"), "Weather Page");
    }

    public String getHeaderText() {
        return headerLabel.getText();
    }
}

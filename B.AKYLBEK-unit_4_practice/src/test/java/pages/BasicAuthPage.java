package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class BasicAuthPage extends Form {
    private static final String NAME = "Basic Auth";
    private static final By SUCCESS_AUTH = By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]");
    private final ILabel successLabel;

    public BasicAuthPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
        successLabel = AqualityServices.getElementFactory().getLabel(SUCCESS_AUTH, "Success Message");
    }

    public boolean isSuccessMsgDisplayed() {
        return successLabel.state().isDisplayed();
    }
}

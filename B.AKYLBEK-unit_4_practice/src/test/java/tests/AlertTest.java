package tests;

import aquality.selenium.browser.AlertActions;
import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import pages.MainPage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static io.qameta.allure.Allure.step;

public class AlertTest extends BaseTest {
    private final JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Test
    public void alertTest() {
        MainPage mainPage = new MainPage();
        step("click Navigation Link");
        mainPage.clickNavigationLink(MainPageNavigation.JAVASCRIPT_ALERT);
        step("Click for JS Alert");
        javaScriptAlertsPage.clickForJsAlertBtn();
        step("Accept Alert");
        getBrowser().handleAlert(AlertActions.ACCEPT);
        Assert.assertTrue(javaScriptAlertsPage.isSuccessLabelDisplayed(), "Success msg is not displayed");
    }
}

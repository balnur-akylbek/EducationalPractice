package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SettingsTestData;

public class Hooks {
    private Browser browser = AqualityServices.getBrowser();

    @Before
    public void setup(){
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void tearDown(){
        browser.quit();
    }
}

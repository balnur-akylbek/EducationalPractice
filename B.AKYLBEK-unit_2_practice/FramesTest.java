package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class FramesTest extends BaseTest {
    private final String initText = "Your content goes here.";
    private final String textIsNotDisplayedMsg = "Text is not displayed";
    private final By frames = By.xpath(String.format(PRECISE_TEXT_XPATH, "Frames"));
    private final By iframe = By.xpath(String.format(PRECISE_TEXT_XPATH, "iFrame"));
    private final By edit = By.xpath(String.format(PRECISE_TEXT_XPATH, "Edit"));
    private final By undo = By.xpath(String.format(PRECISE_TEXT_XPATH, "Undo"));
    private final String randomText = UUID.randomUUID().toString();
    private final String IFRAME_ID = "mce_0_ifr";
    private final By TEXT_FIELD = By.id("tinymce");

    @Test
    public void iFrameTest() {
        driver.findElement(frames).click();
        driver.findElement(iframe).click();
        driver.switchTo().frame(IFRAME_ID);
        driver.findElement(TEXT_FIELD).sendKeys(RANDOM);
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH, initText + randomText))).isDisplayed(),
                textIsNotDisplayedMsg);
        driver.switchTo().defaultContent();
        driver.findElement(edit).click();
        driver.findElement(undo).click();
        driver.switchTo().frame(IFRAME_ID);
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH,INIT_Text))).isDisplayed(),
                TEXT_IS_NOT_DISPLAYED_MSG);
    }
}

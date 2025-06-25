package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.PrimitiveIterator;

import static org.testng.reporters.RuntimeBehavior.FILE_NAME;

public class FileUploadTest extends BaseTest {
    private final String fileName = "file.json";
    private final By CHOOSE_FILE = By.id("file-upload");
    private final By FILE_SUBMIT = By.id("file-submit");
    private final By UPLOADED_FILE = By.id("uploaded-files");

    private final String filePath = RELATIVE_RESOURCE_PATH + fileName;
    private final By fileUpload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));

    @Test
    public void fileUploadTest() {
        driver.findElement(fileUpload).click();
        File fileToUpload = new File(filePath);
        driver.findElement(CHOOSE_FILE).sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(FILE_SUBMIT).click();
        Assert.assertEquals(driver.findElement(UPLOADED_FILE).getText(), FILE_NAME, "File name is incorrect");
    }
}

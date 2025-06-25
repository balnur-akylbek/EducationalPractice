package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {
    private final String fileName = "Test.txt";
    private final By fileDownload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final By fileNameXpath = By.xpath(String.format(PRECISE_TEXT_XPATH, fileName));
    private String FILE_PATH = RELATIVE_RESOURCE_PATH +FILE_NAME;
    private  final File downloadedFile= new File(FILE_PATH);

    @Test
    public void fileDownloadTest() {
        driver.findElement(fileDownload).click();
        Assert.assertTrue(driver.findElement(fileNameXpath).isDisplayed(), "File is not displayed");
        driver.findElement(fileNameXpath).click();
        Assert.assertTrue(isFileExists(downloadedFile), "File is not downloaded");
    }
    private boolean isFileExists (File file){
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        }
        catch (ConditionTimeOutException exception){
            return false;
        }
        return true;
    }
}

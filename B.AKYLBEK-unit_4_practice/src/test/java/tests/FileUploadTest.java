package tests;

import constants.MainPageNavigation;
import framework.pages.UploadedFilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.MainPage;
import utils.SettingsTestData;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage = new FileUploadPage();
    private UploadedFilePage uploadedFilePage = new UploadedFilePage();
    private final String FILE_NAME = SettingsTestData.getFileData().getUploadFile();
    private final String FILE_PATH = SettingsTestData.TEST_DATA_PATH + FILE_NAME;

    @Test
    public void fileUploadTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        fileUploadPage.uploadFile(new File(FILE_PATH).getAbsolutePath());
        fileUploadPage.clickSubmitBtn();
        Assert.assertEquals(uploadedFilePage.getUploadedFileName(), FILE_NAME, "File name is not correct or missed");
    }
}

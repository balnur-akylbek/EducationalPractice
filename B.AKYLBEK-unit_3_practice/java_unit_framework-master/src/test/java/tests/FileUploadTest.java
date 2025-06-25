package tests;

import constants.MainPageNavigation;
import framework.pages.UploadedFilePage;
import java.io.File;
import org.testng.Assert;
import pages.FileUploadPage;
import utils.SettingsTestData;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage = new FileUploadPage();
    private UploadedFilePage uploadedFilePage = new UploadedFilePage();
    private final String FILE_NAME = SettingsTestData.getFileData().getUploadFile();
    private final String FILE_PATH = SettingsTestData.TEST_DATA_PATH + FILE_NAME;

    @Test
    public void fileUploadTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        fileUploadPage.uploadFile(new File(FILE_PATH).getAbsolutePath());
        fileUploadPage.clickSubmitBtn();
        Assert.assertEquals(uploadedFilePage.getUploadedFileName(), FILE_NAME, "File name is not correct or missed");
    }
}

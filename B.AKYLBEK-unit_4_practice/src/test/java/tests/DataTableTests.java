package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pages.DataTablesPage;
import pages.MainPage;
import utils.SettingsTestData;
import utils.StringUtils;

public class DataTableTests extends BaseTest {
    private final DataTablesPage dataTablesPage = new DataTablesPage();

    @Test
    public void dataTableTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickNavigationLink(MainPageNavigation.SORTABLE_DATA_TABLES);
        Double actualSum = 0.0;
        for (String due : dataTablesPage.getFirstDueList()) {
            actualSum += StringUtils.getDoubleFromString(due);
        }
        Assert.assertEquals(actualSum, SettingsTestData.getDataTableData().getExpectedDueSum(), "Sum is not correct");
    }
}

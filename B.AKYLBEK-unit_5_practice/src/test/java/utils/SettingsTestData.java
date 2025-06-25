package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.google.gson.Gson;
import models.*;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.FileNotFoundException;

@UtilityClass
public class SettingsTestData {
    public static final String RESOURCES_PATH = "src/test/resources/";
    public static final String TEST_DATA_PATH = RESOURCES_PATH + "testdata/";
    private static final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    public static final String CITY_DATA_PATH = TEST_DATA_PATH + "cityData.json";
    private static final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private static final Gson GSON = new Gson();

    public static EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    public static CityData getCityNameFromJson() {
        return deserializeJson(CITY_DATA_PATH, CityData.class);
    }

    private static String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    private static <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Settings file %s not found or incorrect. Error msg: %s".formatted(filePath, e));
            throw new RuntimeException(e);
        }
    }
}

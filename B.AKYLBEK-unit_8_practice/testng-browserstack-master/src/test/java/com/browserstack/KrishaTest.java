package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class KrishaTest extends SeleniumTest {
    @Test
    public void checkFlats() {
        driver.get("https://krisha.kz/arenda/kvartiry/astana/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'icon icon-svg icon-logo']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'icon icon-svg icon-logo']")).isDisplayed());

        driver.findElement(By.id("das[price][to]")).sendKeys("200000");
        driver.findElement(By.id("das[live.square][to]")).sendKeys("40");

        driver.findElement(By.xpath("//*[@class='kr-btn kr-btn--blue kr-btn--large btn-submit search-btn-main']")).submit();

        wait.until(ExpectedConditions.titleContains("Аренда"));
        String ActualTitle = driver.getTitle();
        System.out.println("Page Title: " + ActualTitle);

        String ExpectedTitle = "Аренда квартир помесячно в Астане: сдать, снять квартиру – объявления на Крыше ";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

}

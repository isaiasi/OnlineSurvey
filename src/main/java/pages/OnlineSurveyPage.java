package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class OnlineSurveyPage extends BasePage {
    static WebDriverWait wait;
    static Random r = new Random();

    public OnlineSurveyPage(WebDriver webDriver){
        super(webDriver);
    }

    public static void fillDateOfBirth(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        Select month = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month"))));
        Select day = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("day"))));
        Select year = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year"))));

        month.selectByValue("April");
        day.selectByValue("22");
        year.selectByValue("1990");

    }

    public static void answerQuestions(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        List<WebElement> favLanguages = driver.findElements(By.xpath("//input[@name='favorite_language']"));
        List<WebElement> favOs = driver.findElements(By.xpath("//input[@name='favorite_os']"));
        List<WebElement> favIDE = driver.findElements(By.xpath("//input[@name='favorite_idea']"));

        favLanguages.get(r.nextInt(favLanguages.size())).click();
        favOs.get(r.nextInt(favOs.size())).click();
        favIDE.get(r.nextInt(favIDE.size())).click();

    }
}


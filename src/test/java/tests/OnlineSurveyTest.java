package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.OnlineSurveyPage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class OnlineSurveyTest extends BaseTest{
    @Test
    public void testFillDateOfBirth() {
        OnlineSurveyPage.fillDateOfBirth( webDriver );
        List<WebElement> selects = webDriver.findElements(By.tagName("select"));
        assertEquals(3, selects.size());

        for (WebElement select : selects) {
            assertNotEquals("", new Select(select).getFirstSelectedOption().getText());
        }
    }

    @Test
    public void testAnswerQuestions() {
        OnlineSurveyPage.answerQuestions(webDriver);

        List<WebElement> checkBoxes = webDriver.findElements(By.tagName("input"));

        Set<String> checked = new HashSet<>();
        for (WebElement select : checkBoxes) {
            if (select.isSelected()) {
                if (checked.contains(select.getAttribute("name"))) {
                    fail("multiple options checked");
                }
                checked.add(select.getAttribute("name"));
            }
        }
        assertEquals(3, checked.size());
    }
}

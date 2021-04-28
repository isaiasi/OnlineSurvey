package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver _webDriver;

    public BasePage(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    //The following methods are not used in this project, for simplification of the test
    protected WebElement FindElement(By byLocator)
    {
        return GetWait(10).until( ExpectedConditions.visibilityOfElementLocated( byLocator ));
    }

    protected List<WebElement> FindElements(By byLocator)
    {
        List<WebElement> webElements = GetWait(10).until( ExpectedConditions.presenceOfAllElementsLocatedBy( byLocator ));
        return webElements;
    }

    protected void WaitForElementToBeSelected(By byLocator)
    {
        GetWait(10).until(ExpectedConditions.elementToBeSelected( byLocator ));
    }

    private WebDriverWait GetWait(int waitTime) {
        return new WebDriverWait(_webDriver, waitTime);
    }
}

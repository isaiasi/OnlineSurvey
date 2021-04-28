package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    final String pageUrl = "file:///Users/isaiasi/Documents/index.html";
    protected WebDriver webDriver;

    @BeforeTest
    protected void SetUp()
    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get( pageUrl );
    }

    @AfterTest
    protected void TearDown()
    {
        webDriver.quit();
    }

}

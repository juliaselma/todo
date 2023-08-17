package org.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.pages.TodoPage;
import org.utils.ConfigReader;
import org.utils.WebDriverFactory;

public class BaseTests {
    private WebDriver driver;
    protected TodoPage todoPage;

    @BeforeMethod
    public void setUp() {

        String browserName = ConfigReader.getProperty("browser");
        driver = WebDriverFactory.createInstance(browserName);

        todoPage = new TodoPage(driver);
        todoPage.navigateTo(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

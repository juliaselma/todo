package org.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.pages.TodoPage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.utils.WebDriverFactory;

public class BaseTests {
    private WebDriver driver;
    protected TodoPage todoPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {

        driver = WebDriverFactory.createInstance(browser);

        todoPage = new TodoPage(driver);
        todoPage.navigateTo("https://todomvc4tasj.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

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
    @Parameters({"browser","URL"})
    public void setUp(@Optional("chrome") String browser,@Optional("https://todomvc4tasj.herokuapp.com/")String URL) {

        driver = WebDriverFactory.createInstance(browser);

        todoPage = new TodoPage(driver);
        todoPage.navigateTo(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.pages.TodoPage;
import org.utils.WebDriverFactory;

public class BaseTests {
    private WebDriver driver;
    protected TodoPage todoPage;

    @BeforeMethod
    public void setUp() {

        String browserName = "firefox";
        driver = WebDriverFactory.createInstance(browserName);

        todoPage = new TodoPage(driver);
        todoPage.navigateTo("https://todomvc4tasj.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

package org.salesforce.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.salesforce.pages.TodoPage;

public class BaseTests {
    private WebDriver driver;
    protected TodoPage todoPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        todoPage = new TodoPage(driver);
        todoPage.navigateTo("https://todomvc4tasj.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

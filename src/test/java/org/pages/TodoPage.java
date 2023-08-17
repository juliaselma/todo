package org.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.sql.SQLOutput;
import java.util.List;

public class TodoPage {
    private WebDriver driver;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void addTask(String taskName) throws InterruptedException {
        WebElement taskInput = driver.findElement(By.id("new-todo"));
        taskInput.sendKeys(taskName);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(taskInput).sendKeys(Keys.ENTER).perform();
    }

    public void addMultipleTasks(String taskName1,String taskName2,String taskName3,String taskName4) throws InterruptedException {
        addTask(taskName1);
        addTask(taskName2);
        addTask(taskName3);
        addTask(taskName4);
    }

    public boolean IsItemsCountVerificated(){
        WebElement itemCountElement =  driver.findElement(By.cssSelector("#todo-count strong"));
        String itemCountText = itemCountElement.getText();
        int expectedItemCount = 4;
        return itemCountText.equals(Integer.toString(expectedItemCount));
    }

    public void toggleTaskCompletion(String taskName) {
        WebElement taskLabel = driver.findElement(By.xpath("//label[contains(text(), '" + taskName + "')]/preceding-sibling::input"));
        taskLabel.click();
    }

    public void toggleAllTasksCompletion() {
        WebElement toggleAll = driver.findElement(By.id("toggle-all"));
        toggleAll.click();
    }

    public void deleteTask(String taskName) {
        WebElement taskLabel = driver.findElement(By.xpath("//label[contains(text(), '" + taskName + "')]"));
        WebElement deleteButton = taskLabel.findElement(By.xpath("./../button"));
        deleteButton.click();
    }

    public boolean isTaskPresent(String taskName) {
        return driver.findElements(By.xpath("//label[contains(text(), '" + taskName + "')]")).size() > 0;
    }

    public boolean isTaskCompleted(String taskName) {
        WebElement taskLabel = driver.findElement(By.xpath("//label[contains(text(), '" + taskName + "')]"));
        WebElement taskItem = taskLabel.findElement(By.xpath("./../.."));
        return taskItem.getAttribute("class").contains("completed");
    }

    public boolean areAllCompleted() {
        int counter=0;
        String expectedCompletedTasks = "4";
        List<WebElement> taskList = driver.findElements(By.cssSelector("#todo-list>li"));
        for(WebElement task : taskList){
            task.getAttribute("class").contains("completed");
            counter++;
        }
        return expectedCompletedTasks.equals(Integer.toString(counter));
    }

    public boolean areAllTasksActive() {
        int counter=0;
        String expectedCompletedTasks = "4";
        List<WebElement> taskList = driver.findElements(By.cssSelector("#todo-list>li"));
        for(WebElement task : taskList){
            task.getAttribute("class").contains("active");
            counter++;
        }
        return expectedCompletedTasks.equals(Integer.toString(counter));
    }

    public void clearCompletedTask() {
        WebElement clearCompletedButton = driver.findElement(By.id("clear-completed"));
        clearCompletedButton.click();
    }

    public boolean areAllTasksCleared(){
        WebElement footer = driver.findElement(By.id("footer"));
        return footer.getAttribute("style").contains("none");
    }

    public boolean isAllFilterApplied(){
        WebElement activeFilterButton = driver.findElement(By.cssSelector("a[href*=\"/\"]"));
        WebElement activeFilterList = driver.findElement(By.id("todo-list"));
        activeFilterButton.click();

        return activeFilterList.getAttribute("class").contains("");
    }

    public boolean isAllFilterCountValidated(){
        int counter=0;
        String expectedTotalTasks = "4";
        List<WebElement> taskList = driver.findElements(By.cssSelector("#todo-list>li"));
        for(WebElement task : taskList){
            if (task.getAttribute("class").contains("active")||task.getAttribute("class").contains("completed"))
                counter++;
        }
        return expectedTotalTasks.equals(Integer.toString(counter));
    }

    public boolean isFilterActiveApplied(){
        WebElement activeFilterButton = driver.findElement(By.cssSelector("a[href*=\"active\"]"));
        WebElement activeFilterList = driver.findElement(By.id("todo-list"));
        activeFilterButton.click();

        return activeFilterList.getAttribute("class").contains("active");
    }

    public boolean isActiveFilterCountValidated(){
        int counter=0;
        String expectedTotalTasks = "3";
        List<WebElement> taskList = driver.findElements(By.cssSelector("#todo-list>li"));
        for(WebElement task : taskList){
            if (task.getAttribute("class").contains("active"))
                counter++;
        }
        return expectedTotalTasks.equals(Integer.toString(counter));
    }

    public boolean isFilterCompletedApplied(){
        WebElement completedFilterButton = driver.findElement(By.cssSelector("a[href*=\"completed\"]"));
        WebElement completedFilterList = driver.findElement(By.id("todo-list"));
        completedFilterButton.click();

        return completedFilterList.getAttribute("class").contains("completed");
    }

    public boolean isCompletedFilterCountValidated(){
        int counter=0;
        String expectedTotalTasks = "1";
        List<WebElement> taskList = driver.findElements(By.cssSelector("#todo-list>li"));
        for(WebElement task : taskList){
            if (task.getAttribute("class").contains("completed"))
                counter++;
        }
        return expectedTotalTasks.equals(Integer.toString(counter));
    }
}

package org.utils;
import org.testng.annotations.DataProvider;

public class TaskDataProvider {
    @DataProvider(name = "TasksData")
    public static Object[][] getTasks() {
        return new Object[][]{
                {"Call mum","Go training","Read a book","Buy groceries"},
        };
    }

    @DataProvider(name = "TaskData")
    public static Object[][] getTask() {
        return new Object[][]{
                {"Call mum"},
        };
    }
}

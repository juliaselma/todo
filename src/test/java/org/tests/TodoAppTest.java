package org.tests;
import org.utils.TaskDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TodoAppTest extends BaseTests{

    @Test (dataProvider = "TaskData",dataProviderClass = TaskDataProvider.class)
    public void testTaskAdded(String taskName) throws InterruptedException {
        todoPage.addTask(taskName);

        Assert.assertTrue(todoPage.isTaskPresent(taskName));
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testMultipleTasksAdded(String task,String task1,String task2,String task3)throws InterruptedException{
        todoPage.addMultipleTasks(task,task1,task2,task3);
        Assert.assertTrue(todoPage.IsItemsCountVerificated());
    }

    @Test (dataProvider = "TaskData",dataProviderClass = TaskDataProvider.class)
    public void testMarkTaskAsCompleted(String taskName) throws InterruptedException {
        todoPage.addTask(taskName);
        todoPage.toggleTaskCompletion(taskName);

        Assert.assertTrue(todoPage.isTaskCompleted(taskName));
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testMarkAllTaskAsCompleted(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleAllTasksCompletion();

        Assert.assertTrue(todoPage.areAllCompleted());
    }

    @Test (dataProvider = "TaskData",dataProviderClass = TaskDataProvider.class)
    public void testDeleteCompletedTask(String taskName) throws InterruptedException {
        todoPage.addTask(taskName);
        todoPage.toggleTaskCompletion(taskName);
        todoPage.deleteTask(taskName);

        Assert.assertFalse(todoPage.isTaskPresent(taskName));
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testClearAllTask(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleAllTasksCompletion();
        todoPage.clearCompletedTask();

        Assert.assertTrue(todoPage.areAllTasksCleared());
    }

    @Test (dataProvider = "TaskData",dataProviderClass = TaskDataProvider.class)
    public void testSetTaskAsActive(String taskName) throws InterruptedException {
        todoPage.addTask(taskName);
        todoPage.toggleTaskCompletion(taskName);
        todoPage.toggleTaskCompletion(taskName);

        Assert.assertTrue(todoPage.isTaskPresent(taskName));
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testSetAllTasksAsActive(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleAllTasksCompletion();
        todoPage.toggleAllTasksCompletion();

        Assert.assertTrue(todoPage.areAllTasksActive());
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testFilterAll(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleTaskCompletion(task1);

        Assert.assertTrue(todoPage.isAllFilterApplied());
        Assert.assertTrue(todoPage.isAllFilterCountValidated());
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testFilterActive(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleTaskCompletion(task1);

        Assert.assertTrue(todoPage.isFilterActiveApplied());
        Assert.assertTrue(todoPage.isActiveFilterCountValidated());
    }

    @Test (dataProvider = "TasksData",dataProviderClass = TaskDataProvider.class)
    public void testFilterCompleted(String task,String task1,String task2,String task3) throws InterruptedException {
        todoPage.addMultipleTasks(task,task1,task2,task3);
        todoPage.toggleTaskCompletion(task1);

        Assert.assertTrue(todoPage.isFilterCompletedApplied());
        Assert.assertTrue(todoPage.isCompletedFilterCountValidated());
    }

}

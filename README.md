# To Do - Testing Project

## **Overview**:
This is a testing project focused on the automation of "To do" application, which helps people organize and track tasks and/or activities. It´s possible to create lists of tasks that need to be done and mark tasks as completed. 

### **Automated Tests to:**
* Test  a task is added
* Multiple tasks are added 
* Mark one task as completed
* Mark all the task as completed simultaneously 
* Delete completed tasks
* Clear all completed tasks
* Set one task as active (after it is set as complete)
* Set all tasks as active (after they are set as complete)
* Testing of the filter by "all tasks"
* Testing of the filter by "active tasks"
* Testing of the filter by "completed tasks"


## Installation:

### **Clone the repository:**

Git clone https://github.com/juliaselma/todo.git

### Install project dependencies:

Navigate to your project directory

Use the following command to install dependencies: mvn install

## Usage:

#### You can run the test through the 'xml' files:

It is possible to run them in:
* **Chrome browser** 
* **Firefox browser** 
* **in parallel**

## Test Structure:

The project has been created using the POM (Page Object Model) design pattern.
* src/test/java: Contains Pages, Tests and Utils.
* src/test/resources: Contains xml files for executions.



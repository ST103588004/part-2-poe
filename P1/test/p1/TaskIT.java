/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package p1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author david
 */
public class TaskIT {
    
   Task testData;

    String taskName1 = "Login Feature";
    String DEVELOPER_NAME1 = "Robyn";
    String DEVELOPER_SURNAME1 = "Harrison";
    int taskDuration1 = 8;
    String description1 = "Create Login to authenticate users";
    String taskStatus1 = "To do";

    String taskName2 = "Add Task Feature";
    String DEVELOPER_NAME2 = "MIKE";
    String DEVELOPER_SURNAME2 = "Smith";
    int taskDuration2 = 10;
    String description2 = "Create Add Task feature to add tasks for users";

    @BeforeEach
    public void setUp() {
        Task.Welcome();
        testData = new Task(taskName1, description1, DEVELOPER_NAME1 + " " + DEVELOPER_SURNAME1, taskDuration1, 1);
    }

    @Test
    public void testCheckTaskDescription() {
        assertTrue(testData.checkTaskDescription(description1));
    }

    @Test
    public void testCreateTaskID() {
        String expected1 = "L:1:SON";
        testData = new Task(taskName1, description1, DEVELOPER_NAME1 + " " + DEVELOPER_SURNAME1, taskDuration1, 1);
        String actual1 = testData.createTaskID();
        assertEquals(expected1, actual1);

        String expected2 = "A:2:ITH";
        testData = new Task(taskName2, description2, DEVELOPER_NAME2 + " " + DEVELOPER_SURNAME2, taskDuration2, 2);
        String actual2 = testData.createTaskID();
        assertEquals(expected2, actual2);
    }

    @Test
    public void testPrintTaskDetails() {
        String expected = "Task status: " + taskStatus1 + "\n" +
                "Developer Details: " + DEVELOPER_NAME1 + " " + DEVELOPER_SURNAME1 + "\n" +
                "Task Number: 1\n" +
                "taskDescription: " + description1 + "\n" +
                "Task ID: L:1:SON\n" +
                "Duration: 8 hours";
        String actual = testData.printTaskDetails();
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnTotalHours() {
        int expectedHours = taskDuration1;
        int actualHours = Task.returnTotalHours();
        assertEquals(expectedHours, actualHours);
    }

    @Test
    public void testDisplayTotalHours() {
        Task.displayTotalHours();
    }
}
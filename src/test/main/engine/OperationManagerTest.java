package main.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class is a test class for all methods in OperationManager class.
 * Through testing the use of various methods to ensure that they can operate normally.
 * @author Ziming Wang
 * @version 1.0
 */
public class OperationManagerTest {

    OperationManager operationManager;
    Task task1;
    Task task2;
    Project project1;

    public OperationManagerTest(){

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        operationManager = new OperationManager();
        task1 = new Task("test1", 1,"3");
        task2 = new Task("test2", 2, "4");
        project1 = new Project("project 1", 1, "5");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test addTask method. Add some information to add a task.
     */
    @Test
    public void testAddTask_1() {
        operationManager.addTask("www",3 ,"1");

        assertEquals("www", operationManager.getTask(3).getName());
    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddTask_2() {
        operationManager.addTask(task1);

        assertEquals("test1", operationManager.getTask(1).getName());
    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddProject_1() {
        operationManager.addProject(project1);

        assertEquals("project 1", operationManager.getProject(1).getName());
    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddProject_2() {
        operationManager.addProject("project 2", 2, "6");

        assertEquals("project 2", operationManager.getProject(2).getName());
    }

    /**
     * Test taskStatus method.
     */
    @Test
    public void testTaskStatus() {

        operationManager.addTask("www",3 ,"1");

        assertFalse(operationManager.getTask(3).getStatus());
        operationManager.taskStatus(3);
        assertTrue(operationManager.getTask(3).getStatus());

    }

    /**
     * Test projectStatus method.
     */
    @Test
    public void testProjectStatus() {
        operationManager.addProject("aaa",2 ,"4");

        assertFalse(operationManager.getProject(2).getStatus());
        operationManager.projectStatus(2);
        assertTrue(operationManager.getProject(2).getStatus());

    }

    /**
     * Test addTaskToProject method.
     */
    @Test
    public void testAddTaskToProject() {

        operationManager.addProject("aaa",2 ,"4");
        assertEquals(0, operationManager.getProject(2).getProject().size());

        operationManager.addTaskToProject(task1, 2);
        assertEquals(1, operationManager.getProject(2).getProject().size());

    }

    /**
     * Test deleteTaskFromProject method.
     */
    @Test
    public void testDeleteTaskFromProject() {
        operationManager.addProject("aaa",2 ,"4");
        operationManager.addTaskToProject(task1, 2);
        operationManager.addTaskToProject(task2, 2);
        assertEquals(2, operationManager.getProject(2).getProject().size());
        operationManager.deleteTaskFromProject(1, 2);
        assertEquals(1, operationManager.getProject(2).getProject().size());

    }
}
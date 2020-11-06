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
 * This class is a test class for all methods in the Project class.
 * Through testing the use of various methods to ensure that they can operate normally.
 * @author Ziming Wang
 * @version 1.0
 */
public class ProjectTest {

    Project test;
    Task task1;
    Task task2;

    public ProjectTest(){

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        test = new Project("test", 1, "7");
        task1 = new Task("test 1", 4, "3");
        task2 = new Task("test 2", 5, "4");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test addTask method.
     */
    @Test
    public void testAddTask() {

        assertEquals(0, test.getProject().size());
        test.addTask(task1);
        assertEquals(1, test.getProject().size());

    }

    /**
     * Test removeTask method. Make sure the task will be removed from project
     */
    @Test
    public void testRemoveTask_1() {

        test.addTask(task1);
        test.addTask(task2);
        assertEquals(2, test.getProject().size());

        test.removeTask(4);

        assertEquals(1, test.getProject().size());
    }
    /**
     * Test removeTask method. Make sure I can remove a task from project by id number.
     */
    @Test
    public void testRemoveTask_2() {

        test.addTask(task1);
        test.addTask(task2);

        assertEquals(4, test.getProject().get(0).getId());

        test.removeTask(4);

        assertEquals(5, test.getProject().get(0).getId());
    }

    /**
     * Test removeTask method. Remove the task which doesn't not exist.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveStocksIllegalArgumentException() throws IllegalArgumentException{
        test.addTask(task1);
        test.addTask(task2);

        test.removeTask(1);
    }

    /**
     * Test changeStatus method.
     */
    @Test
    public void testChangeStatus() {

        assertFalse(test.getStatus());
        test.changeStatus();
        assertTrue(test.getStatus());

    }
}
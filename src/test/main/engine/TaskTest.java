package main.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TaskTest {

    Task test;

    public TaskTest(){

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        test = new Task("Test", 1, "7");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test chargeStatus method.
     */
    @Test
    public void testChangeStatus() {
        assertFalse(test.getStatus());
        test.changeStatus();
        assertTrue(test.getStatus());
    }
}
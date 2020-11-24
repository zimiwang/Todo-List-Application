package engine;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * This class is a test class for all methods in the Todo class.
 * Through testing the use of various methods to ensure that they can operate normally.
 * @author Ziming Wang
 * @version 1.0
 */
public class TodoTest {

    //OperationManager operationManager;
    Task task1;
    Task task2;
    Project project1;
    Todo todo;

    public TodoTest(){

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        //operationManager = new OperationManager();
        task1 = new Task("test1", 1,"3");
        task2 = new Task("test2", 2, "4");
        project1 = new Project("project 1", 1, "5");
        todo = new Todo();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test addTask method. Add some information to add a task.
     */
    @Test
    public void testAddTask_1() {
        todo.addTask("www",3 ,"1");

        System.out.println(todo.getTask(3).getName() );
        assertEquals("www", todo.getTask(3).getName());

    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddTask_2() {
        todo.addTask(task1);

        assertEquals("test1", todo.getTask(1).getName());
    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddProject_1() {
        todo.addProject(project1);

        assertEquals("project 1", todo.getProject(1).getName());
    }

    /**
     * Test addTask method. Add a task into linked list.
     */
    @Test
    public void testAddProject_2() {
        todo.addProject("project 2", 2, "6");

        assertEquals("project 2", todo.getProject(2).getName());
    }

    /**
     * Test taskStatus method.
     */
    @Test
    public void testTaskStatus() {

        todo.addTask("qwe",3 ,"1");

        assertFalse(todo.getTask(3).getStatus());
        todo.taskStatus(3);
        assertTrue(todo.getTask(3).getStatus());

    }

    /**
     * Test projectStatus method.
     */
    @Test
    public void testProjectStatus() {
        todo.addProject("mba",2 ,"4");

        assertFalse(todo.getProject(2).getStatus());

        todo.projectStatus(2);

        assertTrue(todo.getProject(2).getStatus());

    }

    /**
     * Test addTaskToProject method.
     */
    @Test
    public void testAddTaskToProject() {

        todo.addProject("abc",2 ,"4");
        assertEquals(0, todo.getProject(2).getProject().size());

        todo.addTaskToProject(task1, 2);
        assertEquals(1, todo.getProject(2).getProject().size());

    }

    /**
     * Test deleteTaskFromProject method.
     */
    @Test
    public void testDeleteTaskFromProject() {
        todo.addProject("aaa",2 ,"4");
        todo.addTaskToProject(task1, 2);
        todo.addTaskToProject(task2, 2);
        assertEquals(2, todo.getProject(2).getProject().size());
        todo.deleteTaskFromProject(1, 2);
        assertEquals(1, todo.getProject(2).getProject().size());

    }
}
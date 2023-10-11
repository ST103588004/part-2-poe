/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AssignmentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSaveStudent() {
        setInput("123", "John Doe", "20", "johndoe@example.com", "Computer Science");

        StudentManagerUtils.saveStudent();

        assertFalse(StudentManagerUtils.studentList.isEmpty());
        assertEquals("123", StudentManagerUtils.studentList.get(0).getId());
        assertEquals("John Doe", StudentManagerUtils.studentList.get(0).getName());
        assertEquals(20, StudentManagerUtils.studentList.get(0).getAge());
        assertEquals("johndoe@example.com", StudentManagerUtils.studentList.get(0).getEmail());
        assertEquals("Computer Science", StudentManagerUtils.studentList.get(0).getCourse());
    }

    @Test
    public void testSearchForStudentFound() {
        Student student = new Student("123", "John Doe", 20, "johndoe@example.com", "Computer Science");
        StudentManagerUtils.studentList.add(student);

        setInput("123");

        StudentManagerUtils.searchForStudent("123"); 

        String expectedOutput = """
                                STUDENT ID: 123
                                STUDENT NAME: John Doe
                                STUDENT AGE: 20
                                STUDENT EMAIL: johndoe@example.com
                                STUDENT COURSE: Computer Science
                                """;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSearchForStudentNotFound() {
        StudentManagerUtils.studentList.clear();

        setInput("123");

        StudentManagerUtils.searchForStudent("123");

        String expectedOutput = """
                                STUDENT ID: 123
                                ==================================
                                Student with Student ID: 123 not found!!!
                                ==================================
                                """;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("123", "John Doe", 20, "johndoe@example.com", "Computer Science");
        StudentManagerUtils.studentList.add(student);

        setInput("123", "Y");

        StudentManagerUtils.deleteStudent("123"); 

        assertTrue(StudentManagerUtils.studentList.isEmpty());
    }

    @Test
    public void testStudentReport() {
        Student student1 = new Student("123", "John Doe", 20, "johndoe@example.com", "Computer Science");
        Student student2 = new Student("456", "Jane Smith", 22, "janesmith@example.com", "Mathematics");
        StudentManagerUtils.studentList.add(student1);
        StudentManagerUtils.studentList.add(student2);

        setInput("1");

        StudentManagerUtils.studentReport(); 

        String expectedOutput = """
                                STUDENT ID: 123
                                STUDENT NAME: John Doe
                                STUDENT AGE: 20
                                STUDENT EMAIL: johndoe@example.com
                                STUDENT COURSE: Computer Science
                                ------------------------------------------------------------------------
                                STUDENT ID: 456
                                STUDENT NAME: Jane Smith
                                STUDENT AGE: 22
                                STUDENT EMAIL: janesmith@example.com
                                STUDENT COURSE: Mathematics
                                ------------------------------------------------------------------------
                                Enter (1) to launch the menu or any other key to exit
                                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testExitStudentApplication() {
        setInput("Y");

        StudentManagerUtils.exitStudentApplication(); 

        String expectedOutput = "Are you sure you want to exit the application?";

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    private void setInput(String... inputs) {
        String input = String.join("\n", inputs) + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}

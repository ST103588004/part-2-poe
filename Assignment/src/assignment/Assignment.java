/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class Assignment {

    static final ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
//display 
        while (!exit) {
            String message = "Student Management Application\n"
                    + "***************************************************************\n"
                    + "Please select 1 of the following items:\n"
                    + "(1) Capture a new student\n"
                    + "(2) Search for a student\n"
                    + "(3) Delete a student\n"
                    + "(4) Print student report\n"
                    + "(5) Exit Application";

            String input = JOptionPane.showInputDialog(null, message);
//case statements
            if (input != null) {
                try {
                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            StudentManagerUtils.saveStudent();
                            break;
                        case 2:
                            String searchId = JOptionPane.showInputDialog("Enter the student ID to search:");
                            StudentManagerUtils.searchForStudent(searchId);
                            break;
                        case 3:
                            String deleteId = JOptionPane.showInputDialog("Enter the student ID to delete:");
                            StudentManagerUtils.deleteStudent(deleteId);
                            break;
                        case 4:
                            StudentManagerUtils.studentReport();
                            break;
                        case 5:
                            StudentManagerUtils.exitStudentApplication();
                            exit = true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu number.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid menu number.");
                }
            } else {
                StudentManagerUtils.exitStudentApplication();
                exit = true;
            }
        }
    }
}
    
    


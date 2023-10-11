/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
class StudentManagerUtils {
       public static final ArrayList<Student> studentList = new ArrayList<>();

    public static void saveStudent() {
        String id = null;
        String name = null;
        int age = 0;
        String email = null;
        String course = null;
//promts
        while (id == null || id.trim().isEmpty()) {
            id = JOptionPane.showInputDialog("Enter the student's ID:");
            if (id == null) {
                exitStudentApplication();
                return;
            }
        }

        while (name == null || name.trim().isEmpty()) {
            name = JOptionPane.showInputDialog("Enter the student's name:");
            if (name == null) {
                exitStudentApplication();
                return;
            }
        }

        while (true) {
            String ageStr = JOptionPane.showInputDialog("Enter the student's age:");
            if (ageStr == null) {
                exitStudentApplication();
                return;
            }
            if (isNumeric(ageStr)) {
                age = Integer.parseInt(ageStr);
                if (age >= 16) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an incorrect student age!!!\nPlease re-enter the student age >> ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number.");
            }
        }

        while (email == null || !isValidEmail(email)) {
            email = JOptionPane.showInputDialog("Enter the student's email:");
            if (email == null) {
                exitStudentApplication();
                return;
            }
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
            }
        }

        while (course == null || course.trim().isEmpty()) {
            course = JOptionPane.showInputDialog("Enter the student's course:");
            if (course == null) {
                exitStudentApplication();
                return;
            }
        }

        Student student = new Student(id, name, age, email, course);
        studentList.add(student);

        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");
    }
//search student feature
    public static void searchForStudent(String searchId) {
        boolean studentFound = false;
        for (Student student : studentList) {
            if (student.getId().equals(searchId)) {
                // Student found, display details
                JOptionPane.showMessageDialog(null, "STUDENT ID: " + student.getId() + "\n" +
                        "STUDENT NAME: " + student.getName() + "\n" +
                        "STUDENT AGE: " + student.getAge() + "\n" +
                        "STUDENT EMAIL: " + student.getEmail() + "\n" +
                        "STUDENT COURSE: " + student.getCourse());

                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            // Student not found, display error message
            JOptionPane.showMessageDialog(null, "STUDENT ID: " + searchId + "\n" +
                    "==================================\n" +
                    "Student with Student ID: " + searchId + " not found!!!\n" +
                    "==================================");
        }
    }
//delete student feature
    public static void deleteStudent(String deleteId) {
        boolean studentFound = false;
        int studentIndex = -1;

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getId().equals(deleteId)) {
                studentFound = true;
                studentIndex = i;
                break;
            }
        }
//student system 
        if (studentFound) {
            int confirm = JOptionPane.showConfirmDialog(null, "Student ID: " + deleteId + "\n" +
                    "Are you sure you want to delete student " + deleteId + " from the system?\n" +
                    "Yes (Y) to delete or (N) to go back.");

            if (confirm == JOptionPane.YES_OPTION) {
                studentList.remove(studentIndex);
                JOptionPane.showMessageDialog(null, """
                                                    -------------------------------------------
                                                    Student with Student ID: """ + deleteId + " WAS deleted!\n" +
                        "-------------------------------------------");
            }
        } else {
            JOptionPane.showMessageDialog(null, "STUDENT ID: " + deleteId + "\n" +
                    "-------------------------------------------\n" +
                    "Student with Student ID: " + deleteId + " not found!!!\n" +
                    "-------------------------------------------");
        }
    }
//function for student report
    public static void studentReport() {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No student records available for reporting.");
            return;
        }

        StringBuilder report = new StringBuilder();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);

            report.append("STUDENT ").append(i + 1).append("\n");
            report.append("------------------------------------------------------------------------\n");
            report.append("STUDENT ID: ").append(student.getId()).append("\n");
            report.append("STUDENT NAME: ").append(student.getName()).append("\n");
            report.append("STUDENT AGE: ").append(student.getAge()).append("\n");
            report.append("STUDENT EMAIL: ").append(student.getEmail()).append("\n");
            report.append("STUDENT COURSE: ").append(student.getCourse()).append("\n");
            report.append("------------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, report.toString() + "\nEnter (1) to launch the menu or any other key to exit");
    }
//exit app feature
    public static void exitStudentApplication() {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for using the application, GoodBye!");
            System.exit(0);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }
}



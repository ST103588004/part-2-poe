/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Task { 
    
     private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private int taskNumber;
    private String taskID;
    private static int totalHours;

  

    public static void Welcome() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
    }

    public static void Menu() {
        while (true) {
            String option = JOptionPane.showInputDialog(null, "Please choose an option:\n"
                    + "1. Add task\n"
                    + "2. Show report\n"
                    + "3. Quit\n"
                    + "Type the number only");

            switch (option) {
                case "1":
                    NewTask();
                    break;
                case "2":
                    ShowReport();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting the EasyKanban app.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
            }
        }
    }
    
      public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = chooseTaskStatus();
        this.taskNumber = taskNumber;
        this.taskID = createTaskID();
        totalHours += taskDuration;
    }

    public static void NewTask() {
        ArrayList<Task> tasks = new ArrayList<>();
        

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        for (int i = 1; i <= numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter the name for task " + i + ":");
            while (taskName.isBlank()){
                
                JOptionPane.showMessageDialog(null, "Please ensure Task name is not empty!!");
                 taskName = JOptionPane.showInputDialog("Enter the name for task " + i + ":");
                
            }
            
            String taskDescription = JOptionPane.showInputDialog("Enter the description for task " + i + " (less than 50 characters):");

            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--;
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog("Please enter the developer's first and last name: ");
            if (developerDetails.length() < 3) {
                JOptionPane.showMessageDialog(null, "The developers Details should be longer than 3 characters:");
                i--;
                continue;
            }
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours: "));

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, i);
            tasks.add(task);

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
    }

    public String createTaskID() {
        String taskID = taskName.substring(0, 1).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskID;
    }

    private String chooseTaskStatus() {
        String[] options = {"To do", "Done", "Doing"};
        int choice = JOptionPane.showOptionDialog(null, "Select the task status:", "Task status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return options[choice];
    }

    public String printTaskDetails() {
        return "Task status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "taskDescription: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours";
    }

    public static void ShowReport() {
        JOptionPane.showMessageDialog(null, "Coming soon!");
    }

    public static int returnTotalHours() {
        return totalHours;
    }

    public static void displayTotalHours() {
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
    }

    public boolean checkTaskDescription(String description) {
        return description != null && !description.isEmpty() && description.length() <= 50;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author david
 */
public class log {
    //Declaring variables
  String username;
  String password;
  String surname;
  String name; 
  String inputusername = "";
  String inputpassword = "";
 
  //Promt for user to enter details
public void askUserdetails(){
name = JOptionPane.showInputDialog(null,"Enter your name: ");   
surname = JOptionPane.showInputDialog(null, "Enter your surname: ");

}
 
 //Function that checks if username and password restrictions are met  
boolean CheckUserName(String username){
    if (username.length() <= 5 && username.contains("_")){
    return true;
   }else {
    return false;
    } 
}
boolean Checkpasswordcomplexity(String password){
   if (password.length()>= 8 && password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")){
   return true;
  } else {
  return false;
 } 
}
//Function to register username and password
public void RegisterUser(){
    while(true) {
        username = JOptionPane.showInputDialog(null, "Enter your username: ");
        if (CheckUserName(username)) {
         JOptionPane.showMessageDialog(null, "Username is successfully captured. ");
         break;
        }else{
        JOptionPane.showMessageDialog(null," Username isn't correctly formatted.");
            continue;
        }
    }
    while(true) {
        password = JOptionPane.showInputDialog(null, "Enter your Password: ");
        if (Checkpasswordcomplexity(password)) {
         JOptionPane.showMessageDialog(null, "password is successfully captured. ");
         break;
        }else{
        JOptionPane.showMessageDialog(null," password isn't correctly formatted.");
            continue;     
     }
   }    
}
//Function to login and message to confirm the user has logged in succesfully or not 
boolean LoginUser(String inputusername, String inputpassword){
    if (username.equals(inputusername) && password.equals( inputpassword)) {
        return true;
    }else {
        return false;
    }     
}
public String returnLoginStatus(){
    JPanel loginPanel = new JPanel(new GridLayout(0, 1));
    loginPanel.add(new JLabel("username: "));
    JTextField usernameField = new JTextField();
    loginPanel.add(usernameField);
    
    loginPanel.add(new JLabel("Password: "));
    JPasswordField passwordField = new JPasswordField();
    loginPanel.add(passwordField);
    
    while (true) {
        int loginResult = JOptionPane.showConfirmDialog(null , loginPanel, "login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_OPTION);
        if (loginResult == JOptionPane.OK_OPTION){
        String inputusername = usernameField.getText();
        String inputpassword = new String( passwordField.getPassword());
        if (LoginUser(inputusername, inputpassword)){
            JOptionPane.showMessageDialog(null , "welcome " + name + " " + surname + " it's great to see you again. ");
            break;
        }else {
            JOptionPane.showMessageDialog(null , "username or password, please try again. ");
          }
        }else{      
         break;
        }
      }
      return null;
    }

}


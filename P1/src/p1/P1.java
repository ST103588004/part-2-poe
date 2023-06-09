/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1;
import java.awt.Taskbar;
 /**
 *
 * @author david
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String username = "";
        String password = "";

        log method = new log();

        method.askUserdetails();

        method.CheckUserName(username);

       method.Checkpasswordcomplexity(password);

        method.RegisterUser();

        method.LoginUser(username, password);

        method.returnLoginStatus();
       
       Task.Welcome();
       Task.Menu();
      
       
      
    
       
    }
   }

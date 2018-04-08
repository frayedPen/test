/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanju
 */
public class Exercise_15_2 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/University","root","");
            
            System.out.print("Enter number of employees: ");
            int num = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < num; i++) {
                System.out.print("Enter employee Id: ");
                int empID = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter Surname: ");
                String surname = sc.nextLine();
                
                System.out.print("Enter other name: ");
                String otherName = sc.nextLine();
                
                System.out.print("Enter Address: ");
                String address = sc.nextLine();
                
                System.out.print("Enter nationality: ");
                int nationality = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter leave category: ");
                int category = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter Person Type: ");
                int type = sc.nextInt();
                sc.nextLine();
                
                
                String Str="INSERT INTO `Employees`(`Emp_ID`, `Emp_Surname`, `Emp_Oname`, `Emp_Address`, `Emp_Nationality_Type`, `Emp_Leave_Cat`, `Emp_Posn_Type`) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement St=con.prepareStatement(Str);
                St.setInt(1,empID);
                St.setString(2,surname);
                St.setString(3,otherName);
                St.setString(4,address);
                St.setInt(5,nationality);
                St.setInt(6,category);
                St.setInt(7,type);
                St.executeUpdate();
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Exercise_15_1.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Exercise_15_1.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

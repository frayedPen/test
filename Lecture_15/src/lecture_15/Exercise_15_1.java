/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanju
 */
public class Exercise_15_1 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/University","root","");
            
            System.out.print("Enter number of employees: ");
            int num = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < num; i++) {
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
                
                
                Statement S=con.createStatement();
                S.execute("INSERT INTO `Employees`(`Emp_Surname`, `Emp_Oname`, `Emp_Address`, `Emp_Nationality_Type`, `Emp_Leave_Cat`, `Emp_Posn_Type`) VALUES('" + surname + "','"+ otherName +"','"+ address +"',"+ nationality +","+ category +","+ type +")");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Exercise_15_1.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Exercise_15_1.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

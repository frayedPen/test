/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture_15;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanju
 */
public class Exercise_15_3 {
    public static void main(String[] argss) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
            Statement S = con.createStatement();
            String strSelect = "SELECT * From `employees`";

            ResultSet rset = S.executeQuery(strSelect);
            System.out.println(String.format("%-4s %-10s %-10s %-12s %-5s %-20s","ID","Surname","Other Name","Nationality","Leave","Poaition"));
            while (rset.next()) {
                int empID = rset.getInt("Emp_Id");
                String surname = rset.getString("Emp_Surname");
                String otherName = rset.getString("Emp_OName");
                String nationality;
                int leave = rset.getInt("Emp_Leave_Cat");
                String position = "";
                
                if(rset.getInt("Emp_Nationality_Type") == 1) {
                    nationality = "Mauritian";
                } else {
                    nationality = "Expatriates";
                }
                
                switch(rset.getInt("Emp_Posn_Type")) {
                    case 1: position = "academic staff";
                    case 2: position = "administrative staff";
                    case 3: position = "technical staff";
                    case 4: position = "others";
                }
                    
                String str = String.format("%-4s %-10s %-10s %-12s %-5s %-20s",empID,surname,otherName,nationality,leave,position);
                System.out.println(str);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        } catch (SQLException ex) {
            System.out.println("Sql error");
        }
    }
}

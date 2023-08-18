/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conn;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author saichudin
 */
public class DbMysql {
    
    Connection conn;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
   
        // test connect to db
        Connection conn = OpenConn();
        Statement stmt=conn.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from contacts");  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        conn.close();     
    }
    
    public static Connection OpenConn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8888/parto-test","root","");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

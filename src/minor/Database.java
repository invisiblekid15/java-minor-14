package minor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brij
 */

public class Database {
    Connection conn= null;
    String JDBC_DRIVER;
    String DB_URL;
    String Db_User;
    String Db_Pass;
    Statement stmt;
    
   Database(){
       JDBC_DRIVER="com.mysql.jdbc.Driver";
       DB_URL="jdbc:mysql://localhost:3306/minor?zeroDateTimeBehavior=convertToNull";
       Db_User="root";
       Db_Pass="";
    try{
         Class.forName(JDBC_DRIVER);
         conn =DriverManager.getConnection(DB_URL,Db_User,Db_Pass);
         //JOptionPane.showMessageDialog(null, "Connection Established");
        }
    catch (ClassNotFoundException e){
        System.out.println(e);
       
        } 
    catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt=conn.createStatement();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   ResultSet getRS(String sql){

       ResultSet rs = null;
        try {
            rs=stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
}

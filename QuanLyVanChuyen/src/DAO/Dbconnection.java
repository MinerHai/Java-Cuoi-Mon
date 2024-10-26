/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Dbconnection {

    public static java.sql.Connection getConnection()
    {
        java.sql.Connection conn = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYVANCHUYEN;Integrated Security=true; TrustServerCertificate=true;";
        String username = "sql_quanlyvanchuyen"; // chỉnh theo tài khoảng sql server của mình
        String password = "12345";

        try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}

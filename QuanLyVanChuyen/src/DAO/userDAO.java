/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class userDAO {

    public boolean login(Users user) {
        String qr = "SELECT * FROM Users WHERE Username = ? and Pass = ?";
        try {
            Connection conn = Dbconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean signUp(Users user) {
        String qr = "INSERT INTO USERS(Username, Pass, Role) VALUES(?,?, 'User')";
        try {
            Connection conn = Dbconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Users> dsUser() {
        List<Users> ds = new ArrayList<>();
        String qr = "SELECT * FROM Users";
        try {
            Connection conn = Dbconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Userid");
                String username = rs.getString("Username");
                String pass = rs.getString("Pass");
                String role = rs.getString("Role");
                ds.add(new Users(id, username, pass, role));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }
}

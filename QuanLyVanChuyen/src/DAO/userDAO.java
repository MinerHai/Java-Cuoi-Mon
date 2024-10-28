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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class userDAO {

    public userDAO() {
        this.conn = Dbconnection.getConnection();
    }
    private Connection conn;

    public Users login(String username, String password) {
        String qr = "SELECT * FROM Users WHERE Username = ? and Pass = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("UserId");
                String role = rs.getString("Role");
               return new Users(id, username, password, role);
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean signUp(Users user) {
        String qr = "INSERT INTO USERS(Username, Pass, Role) VALUES(?,?, 'User')";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Người dùng đã tồn tại");
                try {
                    throw new SQLException("Lỗi: ID đã tồn tại trong cơ sở dữ liệu.", ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
            return false;
        }
    }

    public List<Users> dsUser() {
        List<Users> ds = new ArrayList<>();
        String qr = "SELECT * FROM Users";
        try {
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

    public boolean Add_User(Users user) {
        String qr = "INSERT INTO USERS(Username, Pass, Role) VALUES(?,?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getRole());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Người dùng đã tồn tại");
                try {
                    throw new SQLException("Lỗi: ID đã tồn tại trong cơ sở dữ liệu.", ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        }
    }

    public boolean Remove_User(String username) {
        String qr = "DELETE FROM USERS WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, username);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean Edit_User(Users user) {
        String qr = "UPDATE USERS SET Pass = ?, Role = ? WHERE Username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, user.getPass());
            ps.setString(2, user.getRole());
            ps.setString(3, user.getUsername());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Dbconnection;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DigestUtils;
import model.Users;

/**
 *
 * @author Dell
 */
public class userController {

    private DigestUtils digestUtils;
    private Connection conn;

    public userController() {
        digestUtils = new DigestUtils();
        this.conn = Dbconnection.getConnection();
    }

    public Users login_user(String username, String password) throws NoSuchAlgorithmException, SQLException {

        String qr = "SELECT * FROM Users WHERE Username = ?";
        PreparedStatement ps = conn.prepareStatement(qr);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("UserId");
            String hashpass = rs.getString("Pass");
            String role = rs.getString("Role");
            Users user = new Users(id, username, hashpass, role);
            if (user == null) {
                return null;
            }
            if (!digestUtils.verify(password, user.getPass())) {
                return null;
            }
            return user;
        } else {
            return null;
        }
    }

    public boolean signup_user(String username, String password, String confirmPW) throws SQLException {
        password = digestUtils.hashPassword(password);
        String qr = "INSERT INTO USERS(Username, Pass, Role) VALUES(?,?, 'User')";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Người dùng đã tồn tại");
                throw new SQLException("Lỗi: ID đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return false;
        }
    }

    public boolean add_user(String username, String password, String role) throws SQLException {

        String qr = "INSERT INTO USERS(Username, Pass, Role) VALUES(?,?,?)";
        try {
            String hashPassword = digestUtils.hashPassword(password);
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, username);
            ps.setString(2, hashPassword);
            ps.setString(3, role);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Người dùng đã tồn tại");
                throw new SQLException("Lỗi: ID đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return false;
        }
    }

    public boolean remove_user(String username) {
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

    public boolean edit_user(Users user) {
        String qr = "UPDATE USERS SET Pass = ?, Role = ? WHERE Username = ?";
        try {
            String hashPassword = digestUtils.hashPassword(user.getPass());
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, hashPassword);
            ps.setString(2, user.getRole());
            ps.setString(3, user.getUsername());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Users> getdsUser() {
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

    public List<Users> get_ds_timkiem(String key_word) throws SQLException {
        String qr = "SELECT * FROM Users WHERE Userid = ? or Username = ?";
        int key_word_int;
        try {
            key_word_int = Integer.parseInt(key_word);
        } catch (Exception e) {
            key_word_int = -1;
        }

        List<Users> ds = new ArrayList();
        PreparedStatement ps = conn.prepareStatement(key_word);
        ps.setInt(1, key_word_int);
        ps.setString(2, key_word);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("UserId");
            String username = rs.getString("Username");
            String hashpass = rs.getString("Pass");
            String role = rs.getString("Role");
            Users user = new Users(id, username, hashpass, role);
        }
        return ds;
    }

    public String get_solg_role(String role) {
        String solg = null;
        String qr = "SELECT COUNT(*) as solg FROM Users Where Role = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, role);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                solg = rs.getString("solg");
            }
            return solg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "null";
        }
    }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.userDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Users;

/**
 *
 * @author Dell
 */
public class userController {

    private userDAO USERDAO;

    public userController() {
        USERDAO = new userDAO();
    }

    public boolean login_user(Users user) {
        if (user.getUsername().isEmpty() || user.getPass().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        } else {
            return USERDAO.login(user);
        }
    }

    public boolean signup_user(String username, String password, String confirmPW) throws SQLException {

        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "User name không được chứa dấu cách!!");
            return false;
        }
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        if (username.length() <= 3 || password.length() <= 3) {
            JOptionPane.showMessageDialog(null, "Ussername và Password yêu cầu có 4 kí tự trở lên!!");
            return false;
        }
        if (!password.equals(confirmPW)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu confirm chưa trùng khớp!!");
            return false;
        }

        return USERDAO.signUp(new Users(username, password));
    }

    public boolean add_user(Users user) {

        if (user.getUsername().contains(" ")) {
            JOptionPane.showMessageDialog(null, "User name không được chứa dấu cách!!");
            return false;
        }
        if (user.getUsername().isEmpty() || user.getPass().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        if (user.getUsername().length() <= 3 || user.getPass().length() <= 3) {
            JOptionPane.showMessageDialog(null, "Ussername và Password yêu cầu có 4 kí tự trở lên!!");
            return false;
        }

        return USERDAO.Add_User(user);
    }

    public boolean remove_user(String username) {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "User name không được để trống");
            return false;
        }
        int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn xóa người dùng: " + username + "?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
        );
        if (confirmation == JOptionPane.YES_OPTION) {
            return USERDAO.Remove_User(username);
        }
        return false;
    }
    public boolean edit_user(Users user){
        if (user.getUsername().isEmpty()) {
            JOptionPane.showMessageDialog(null, "User name không được để trống");
            return false;
        }
        int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn thay đổi người dùng: " + user.getUsername() + "?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION
        );
        if (confirmation == JOptionPane.YES_OPTION) {
            return USERDAO.Edit_User(user);
        }
        return false;
    }

    public List<Users> getdsUser() {
        return USERDAO.dsUser();
    }
}

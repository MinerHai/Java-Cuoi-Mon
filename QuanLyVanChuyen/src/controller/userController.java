/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.userDAO;
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

    public boolean signup_user(String username, String password, String confirmPW) {

        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "User name không được chứa dấu cách!!");
            return false;
        }
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        if (username.length() <= 5 || password.length() <= 5) {
            JOptionPane.showMessageDialog(null, "Ussername và Password yêu cầu có 5 kí tự trở lên!!");
            return false;
        }

        if (!password.equals(confirmPW)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu confirm chưa trùng khớp!!");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Đăng kí thành công");
        return USERDAO.signUp(new Users(username, password));
    }

    public List<Users> getdsUser() {
        return USERDAO.dsUser();
    }
}

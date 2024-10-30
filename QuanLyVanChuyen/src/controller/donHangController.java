/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class donHangController {
    private Connection conn;

    public donHangController() {
        this.conn = Dbconnection.getConnection();
    }
    public int get_solg_donhang(String trangthai) {
        int solg = 0;
        String qr = "SELECT COUNT(*) as solg FROM Donhang Where TrangThai = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, trangthai);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                solg = rs.getInt("solg");
            }
            return solg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return solg;
        }
    }
    public int get_solg_donhang() {
        int solg = 0;
        String qr = "SELECT COUNT(*) as solg FROM DonHang";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                solg = rs.getInt("solg");
            }
            return solg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return solg;
        }
    }
}

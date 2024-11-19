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
import javax.swing.JOptionPane;
import model.KhachHang;

/**
 *
 * @author Dell
 */
public class khachHangController {

    private Connection conn;

    public khachHangController() {
        conn = new Dbconnection().getConnection();
    }

    public int add_khachhang(String tenkh, String sdt, String diachi) throws SQLException {
        String qr = "INSERT INTO KhachHang(TenKhachHang, SDT, DiaChi) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(qr, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, tenkh);
            ps.setString(2, sdt);
            ps.setString(3, diachi);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

            return 0;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại");
                throw new SQLException("Lỗi: Số điện thoại đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return 0;
        }
    }

    public boolean remove_khachhang(int id) {
        String qr = "DELETE FROM KhachHang WHERE MAKHACHHANG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean edit_khachhang(KhachHang kh) throws SQLException {
        try {
            String qr = "UPDATE KHACHHANG SET TenKhachHang = ?, SDT = ?, DiaChi = ? WHERE MaKhachHang = ?";
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiachi());
            ps.setInt(4, kh.getMaKhachHang());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại");
                throw new SQLException("Lỗi: Số điện thoại đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return false;
        }
    }

    public List<KhachHang> getdsKhachHang() {
        List<KhachHang> ds = new ArrayList<>();
        String qr = "SELECT * FROM KhachHang";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaKhachHang");
                String name = rs.getString("TenKhachHang");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DiaChi");
                ds.add(new KhachHang(id, name, sdt, diachi));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }

    public List<KhachHang> getdsKhachHang(String keyword) {
        List<KhachHang> ds = new ArrayList<>();
        int id;
        try {
            id = Integer.parseInt(keyword);
        } catch (Exception e) {
            id = -1;
        }
        String qr = "SELECT * FROM KhachHang WHERE MaKhachHang = ? OR SDT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, id);
            ps.setString(2, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int _id = rs.getInt("MaKhachHang");
                String name = rs.getString("TenKhachHang");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DiaChi");
                ds.add(new KhachHang(_id, name, sdt, diachi));
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
        return ds;
    }

    public KhachHang getKH(String sdt) {

        String qr = "SELECT * FROM KhachHang WHERE SDT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int _id = rs.getInt("MaKhachHang");
                String name = rs.getString("TenKhachHang");
                String _sdt = rs.getString("SDT");
                String diachi = rs.getString("DiaChi");
                return new KhachHang(_id, name, _sdt, diachi);
            }
            return null;

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH(int id) {

        String qr = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int _id = rs.getInt("MaKhachHang");
                String name = rs.getString("TenKhachHang");
                String _sdt = rs.getString("SDT");
                String diachi = rs.getString("DiaChi");
                return new KhachHang(_id, name, _sdt, diachi);
            }
            return null;

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

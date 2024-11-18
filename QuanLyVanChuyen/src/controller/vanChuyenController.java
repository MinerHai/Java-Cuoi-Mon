/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Dbconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.KhachHang;
import model.XeVanChuyen;

/**
 *
 * @author Dell
 */
public class vanChuyenController {

    private Connection conn;

    public vanChuyenController() {
        conn = new Dbconnection().getConnection();
    }

    public boolean add_vanchuyen(String bienso, String taixe, String loaixe) throws SQLException {

        String qr = "INSERT INTO XeVanChuyen(BienSo, TaiXe, LoaiXe) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, bienso);
            ps.setString(2, taixe);
            ps.setString(3, loaixe);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Phương tiện đã tồn tại");
                throw new SQLException("Lỗi: Phương tiện đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return false;
        }
    }

    public boolean remove_vanchuyen(int id) {
        String qr = "DELETE FROM XeVanChuyen WHERE MAXE = ?";
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

    public boolean edit_vanchuyen(XeVanChuyen xe) throws SQLException {
        try {
            String qr = "UPDATE XeVanChuyen SET BienSo = ?, TaiXe = ?, LoaiXe = ? WHERE MaXe = ?";
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, xe.getBienSo());
            ps.setString(2, xe.getTaiXe());
            ps.setString(3, xe.getLoaiXe());
            ps.setInt(4, xe.getMaXe());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(null, "Phương tiện đã tồn tại");
                throw new SQLException("Lỗi: Phương tiện đã tồn tại trong cơ sở dữ liệu.", ex);
            }
            return false;
        }
    }

    public List<XeVanChuyen> getdsPhuongTien() {
        List<XeVanChuyen> ds = new ArrayList<>();
        String qr = "SELECT * FROM XeVanChuyen";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaXe");
                String bienso = rs.getString("BienSo");
                String taixe = rs.getString("TaiXe");
                String loaixe = rs.getString("LoaiXe");
                ds.add(new XeVanChuyen(id, bienso, taixe, loaixe));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }

    public List<XeVanChuyen> getdsPhuongTien(String _bienso) {
        List<XeVanChuyen> ds = new ArrayList<>();
        String qr = "SELECT * FROM XeVanChuyen WHERE BienSo = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, _bienso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaXe");
                String bienso = rs.getString("BienSo");
                String taixe = rs.getString("TaiXe");
                String loaixe = rs.getString("LoaiXe");
                ds.add(new XeVanChuyen(id, bienso, taixe, loaixe));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }

    public int get_solg_xe() {
        int solg = 0;
        String qr = "SELECT COUNT(*) as solg FROM XeVanChuyen";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                solg = rs.getInt("solg");
            }
            return solg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return solg;
        }
    }

    public XeVanChuyen getPhuongTien(String _bienso) {
        String qr = "SELECT * FROM XeVanChuyen WHERE BienSo = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, _bienso);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int id = rs.getInt("MaXe");
            String bienso = rs.getString("BienSo");
            String taixe = rs.getString("TaiXe");
            String loaixe = rs.getString("LoaiXe");
            return (new XeVanChuyen(id, bienso, taixe, loaixe));

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public XeVanChuyen getPhuongTien(int _id) {
        String qr = "SELECT * FROM XeVanChuyen WHERE MaXe = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, _id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int id = rs.getInt("MaXe");
            String bienso = rs.getString("BienSo");
            String taixe = rs.getString("TaiXe");
            String loaixe = rs.getString("LoaiXe");
            return (new XeVanChuyen(id, bienso, taixe, loaixe));

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

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
import model.DonHang;
import model.Users;
import java.sql.Date;

/**
 *
 * @author Dell
 */
public class donHangController {

    private Connection conn;

    public donHangController() {
        this.conn = Dbconnection.getConnection();
    }

    public DonHang getDonHang(int madonhang) {
        String qr = "SELECT * FROM DonHang WHERE Madonhang = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, madonhang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaDonHang");
                int id_kh = rs.getInt("MaKhachHang");
                Date ngayDathang = rs.getDate("NgayDatHang");
                String TrangThai = rs.getString("TrangTHai");
                String GhiChu = rs.getString("GhiChu");
                return new DonHang(id, id_kh, ngayDathang, TrangThai, GhiChu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        };
        return null;

    }

    public int get_solg_donhang(String trangthai) {
        int solg = 0;
        String qr = "SELECT COUNT(*) as solg FROM Donhang Where TrangThai = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, trangthai);
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

    public int get_solg_donhang() {
        int solg = 0;
        String qr = "SELECT COUNT(*) as solg FROM DonHang";
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

    public List<DonHang> getdsDonHang() {
        List<DonHang> ds = new ArrayList<>();
        String qr = "SELECT * FROM DonHang";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaDonHang");
                int id_kh = rs.getInt("MaKhachHang");
                Date ngayDathang = rs.getDate("NgayDatHang");
                String TrangThai = rs.getString("TrangTHai");
                String GhiChu = rs.getString("GhiChu");
                ds.add(new DonHang(id, id_kh, ngayDathang, TrangThai, GhiChu));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }

    public List<DonHang> TimKiem(int madonhang, Date ngaydathang) {
        List<DonHang> ds = new ArrayList<>();
        String qr = "SELECT * FROM DonHang WHERE  NgayDatHang = ? AND  Madonhang = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setDate(1, ngaydathang);
            ps.setInt(2, madonhang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaDonHang");
                int id_kh = rs.getInt("MaKhachHang");
                Date ngayDathang = rs.getDate("NgayDatHang");
                String TrangThai = rs.getString("TrangTHai");
                String GhiChu = rs.getString("GhiChu");
                ds.add(new DonHang(id, id_kh, ngayDathang, TrangThai, GhiChu));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }

    public List<DonHang> TimKiem(int madonhang) {
        List<DonHang> ds = new ArrayList<>();
        String qr = "SELECT * FROM DonHang WHERE  Madonhang = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setInt(1, madonhang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaDonHang");
                int id_kh = rs.getInt("MaKhachHang");
                Date ngayDathang = rs.getDate("NgayDatHang");
                String TrangThai = rs.getString("TrangTHai");
                String GhiChu = rs.getString("GhiChu");
                ds.add(new DonHang(id, id_kh, ngayDathang, TrangThai, GhiChu));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }
    public List<DonHang> TimKiem(Date ngaydathang) {
        List<DonHang> ds = new ArrayList<>();
        String qr = "SELECT * FROM DonHang WHERE  NgayDatHang = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setDate(1, ngaydathang);
  
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MaDonHang");
                int id_kh = rs.getInt("MaKhachHang");
                Date ngayDathang = rs.getDate("NgayDatHang");
                String TrangThai = rs.getString("TrangTHai");
                String GhiChu = rs.getString("GhiChu");
                ds.add(new DonHang(id, id_kh, ngayDathang, TrangThai, GhiChu));
            }
            return ds;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ds;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;


/**
 *
 * @author Dell
 */
public class DonHang {

    public DonHang(int maDonHang, int maKhachHang, Date NgayDatHang, String TrangThai, String GhiChu) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.NgayDatHang = NgayDatHang;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setNgayDatHang(Date NgayDatHang) {
        this.NgayDatHang = NgayDatHang;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    private int maDonHang;
    private int maKhachHang;
    private Date NgayDatHang;
    private String TrangThai;

    public int getMaDonHang() {
        return maDonHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }
    private String GhiChu;
    
    
}

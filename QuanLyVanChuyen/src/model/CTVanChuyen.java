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
public class CTVanChuyen {

    public void setMaVanChuyen(int maVanChuyen) {
        this.maVanChuyen = maVanChuyen;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public void setNgayGiaoHang(Date NgayGiaoHang) {
        this.NgayGiaoHang = NgayGiaoHang;
    }

    public void setTrangThaiVanChuyen(String TrangThaiVanChuyen) {
        this.TrangThaiVanChuyen = TrangThaiVanChuyen;
    }

    public int getMaVanChuyen() {
        return maVanChuyen;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public int getMaXe() {
        return maXe;
    }

    public Date getNgayGiaoHang() {
        return NgayGiaoHang;
    }

    public String getTrangThaiVanChuyen() {
        return TrangThaiVanChuyen;
    }

    public CTVanChuyen(int maVanChuyen, int maDonHang, int maXe, Date NgayGiaoHang, String TrangThaiVanChuyen) {
        this.maVanChuyen = maVanChuyen;
        this.maDonHang = maDonHang;
        this.maXe = maXe;
        this.NgayGiaoHang = NgayGiaoHang;
        this.TrangThaiVanChuyen = TrangThaiVanChuyen;
    }
    private int maVanChuyen;
    private int maDonHang;
    private int maXe;
    private Date NgayGiaoHang;
    private String TrangThaiVanChuyen;
}

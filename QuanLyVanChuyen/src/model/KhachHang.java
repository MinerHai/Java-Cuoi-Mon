/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class KhachHang {

    public KhachHang(int maKhachHang, String tenKhachHang, String sdt, String diachi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.diachi = diachi;
    }
    private int maKhachHang;
    private String tenKhachHang;
    private String sdt;
    private String diachi;

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }
    
}

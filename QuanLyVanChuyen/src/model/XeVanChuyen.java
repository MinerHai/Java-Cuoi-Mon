package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class XeVanChuyen {

    public XeVanChuyen(String BienSo, String TaiXe, String LoaiXe) {
        this.BienSo = BienSo;
        this.TaiXe = TaiXe;
        this.LoaiXe = LoaiXe;
    }

    public XeVanChuyen(int maXe, String BienSo, String TaiXe, String LoaiXe) {
        this.maXe = maXe;
        this.BienSo = BienSo;
        this.TaiXe = TaiXe;
        this.LoaiXe = LoaiXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public void setTaiXe(String TaiXe) {
        this.TaiXe = TaiXe;
    }

    public void setLoaiXe(String LoaiXe) {
        this.LoaiXe = LoaiXe;
    }

    public int getMaXe() {
        return maXe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public String getTaiXe() {
        return TaiXe;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }
    private int maXe;
    private String BienSo;
    private String TaiXe;
    private String LoaiXe;
}

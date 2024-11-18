/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class CTVanChuyenModel {

    public CTVanChuyenModel(int madonhang, int maxe) {
        this.madonhang = madonhang;
        this.maxe = maxe;
    }

    private int madonhang;
    private int maxe;

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }
}

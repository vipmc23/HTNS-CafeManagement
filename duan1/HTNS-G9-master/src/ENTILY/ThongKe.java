/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTILY;

/**
 *
 * @author Nguyen Tung
 */
public class ThongKe {
    private String maTk;
    private String maHD;
    private String ngayTk;
    private float luong;

    public ThongKe() {
    }

    public ThongKe(String maTk, String maHD, String ngayTk, float luong) {
        this.maTk = maTk;
        this.maHD = maHD;
        this.ngayTk = ngayTk;
        this.luong = luong;
    }

    public String getMaTk() {
        return maTk;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTk() {
        return ngayTk;
    }

    public void setNgayTk(String ngayTk) {
        this.ngayTk = ngayTk;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.maTk,this.maHD,this.ngayTk,this.luong};
    }
}

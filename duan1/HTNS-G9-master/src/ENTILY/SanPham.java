/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTILY;

/**
 *
 * @author cungtiennga
 */
public class SanPham {
    private String maSP,tenSP;
    private boolean loai;
    private double gia;
    private String hinh;
    private int soLuong;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, boolean loai, double gia, String hinh, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loai = loai;
        this.gia = gia;
        this.hinh = hinh;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public boolean isLoai() {
        return loai;
    }

    public void setLoai(boolean loai) {
        this.loai = loai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}

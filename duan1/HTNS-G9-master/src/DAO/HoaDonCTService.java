/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTILY.HoaDon;
import UTILS.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cungtiennga
 */
public class HoaDonCTService {

    public ArrayList<HoaDon> getAllHoaDonCT() {
        ArrayList<HoaDon> list = new ArrayList<>();
        Connection con = JDBCHelper.getConnection();
        String sql = "select MaHDCT,HoaDonChiTiet.MaHD,HoaDon.MaNV,SanPham.TenSP, HoaDonChiTiet.SoLuong,Gia,HoaDon.TongTien,HoaDon.NgayXuatHD\n"
                + "from HoaDonChiTiet\n"
                + "    join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD\n"
                + "    join SanPham on HoaDonChiTiet.MaSP = SanPham.MaSP;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHDCT(rs.getString("MaHDCT"));
//                HoaDon hd1 = new HoaDon();
//                hd.setHoadon(hd1);
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenSp(rs.getString("TenSP"));
                hd.setSoluong(rs.getInt("SoLuong"));
                hd.setGia(rs.getDouble("Gia"));
                hd.setTongtien(rs.getDouble("Tongtien"));
                hd.setNgayxuatxu(rs.getDate("NgayxuatHD"));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}


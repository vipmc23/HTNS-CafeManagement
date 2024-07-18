/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTILY.HoaDon;
import UTILS.JDBCHelper;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author cungtiennga
 */
public class HoaDonService {

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        Connection con = JDBCHelper.getConnection();
        String sql = "select * from HoaDon ";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTongtien(rs.getDouble("Tongtien"));
                hd.setNgayxuatxu(rs.getDate("NgayxuatHD"));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<HoaDon> timTheoMAHD(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "select MaHD,TongTien,NgayXuatHD\n"
                    + "from HoaDon where MaHD like ?";
            Connection con = JDBCHelper.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%" + mahd + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTongtien(rs.getDouble("Tongtien"));
                hd.setNgayxuatxu(rs.getDate("NgayxuatHD"));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public ArrayList<HoaDon> sapxeptheoMaHD() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "select * from HoaDon";
            Connection con = JDBCHelper.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTongtien(rs.getDouble("Tongtien"));
                hd.setNgayxuatxu(rs.getDate("NgayxuatHD"));
                list.add(hd);
                Collections.sort(list, new Comparator<HoaDon>() {
                    @Override
                    public int compare(HoaDon hd1, HoaDon hd2) {
                        String mahd1 = hd1.getMaHD();
                        String mahd2 = hd2.getMaHD();

                        // So sánh theo kí tự của chuỗi mahd
                        return mahd2.compareTo(mahd1);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public ArrayList<HoaDon> sapxeptheoTOngTien() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "select * from HoaDon";
            Connection con = JDBCHelper.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTongtien(rs.getDouble("Tongtien"));
                hd.setNgayxuatxu(rs.getDate("NgayxuatHD"));
                list.add(hd);
                Collections.sort(list, new Comparator<HoaDon>() {
                    @Override
                    public int compare(HoaDon tt1, HoaDon tt2) {
                        return Double.compare(tt2.getTongtien(), tt1.getTongtien());
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public Integer addHoaDon(HoaDon hd) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "insert into HoaDon(MaHD, TongTien, NgayXuatHD)\n"
                + "values (?',?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());
            pstm.setDouble(2, hd.getTongtien());
            pstm.setDate(3, (Date) hd.getNgayxuatxu());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

//    public Integer deleteHoaDon(String mahd) {
//        Integer row = null;
//        Connection con = JDBCHelper.getConnection();
//        String sql = "delete\n"
//                + "from HoaDonChiTiet\n"
//                + "where MaHD = ?"
//                + "delete\n"
//                + "from HoaDon\n"
//                + "where MaHD = ?";
//        try {
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1, mahd);
//            row = pstm.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return row;
//    }
}

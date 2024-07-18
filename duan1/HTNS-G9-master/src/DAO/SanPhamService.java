/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTILY.SanPham;
import java.util.ArrayList;
import java.sql.*;
import UTILS.JDBCHelper;

/**
 *
 * @author cungtiennga
 */
public class SanPhamService {

    public ArrayList<SanPham> getAllSP() {
        ArrayList<SanPham> list = new ArrayList<>();
        Connection con = JDBCHelper.getConnection();
        String sql = "select * from SanPham";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("maSP"));
                sp.setTenSP(rs.getString("tenSP"));
                sp.setLoai(rs.getBoolean("loai"));
                sp.setGia(rs.getDouble("giaGoc"));
                sp.setHinh(rs.getString("hinh"));
                sp.setSoLuong(rs.getInt("soLuong"));
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Integer addSanPham(SanPham sp) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "insert into SanPham(maSP, tenSP, loai, giaGoc, hinh, soLuong)\n"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());
            pstm.setBoolean(3, sp.isLoai());
            pstm.setDouble(4, sp.getGia());
            pstm.setString(5, sp.getHinh());
            pstm.setInt(6, sp.getSoLuong());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer updateSanPham(SanPham sp) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "update SanPham\n"
                + "set tenSP = ?,loai = ?,giaGoc = ?,hinh = ?,soLuong = ?\n"
                + "where maSP = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(6, sp.getMaSP());
            pstm.setString(1, sp.getTenSP());
            pstm.setBoolean(2, sp.isLoai());
            pstm.setDouble(3, sp.getGia());
            pstm.setString(4, sp.getHinh());
            pstm.setInt(5, sp.getSoLuong());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer deleteSanPham(String sp) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "delete\n"
                + "from SanPham\n"
                + "where maSP = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTILY.TaiKhoan;
import UTILS.JDBCHelper;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

/**
 *
 * @author sang
 */
public class TaiKhoanService {
    ArrayList<TaiKhoan> list = new ArrayList<>();
    public ArrayList<TaiKhoan> getAll() {
        Connection con = JDBCHelper.getConnection();
        String sql = "select * from TaiKhoan";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt("ID"));
                tk.setMaTK(rs.getString("TaiKhoan"));
                tk.setPass(rs.getString("Pass"));
                tk.setVaitro(rs.getBoolean("VaiTro"));
                list.add(tk);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public TaiKhoan selectByID(String taikhoan){
        List<TaiKhoan> list = selectBySql("select * from taikhoan where taikhoan = ?",taikhoan);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
            
    public ArrayList<TaiKhoan> selectBySql(String sql, Object... args){
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan enity = new TaiKhoan();
                enity.setId(rs.getInt("ID"));
                enity.setMaTK(rs.getString("TaiKhoan"));
                enity.setPass(rs.getString("Pass"));
                enity.setVaitro(rs.getBoolean("VaiTro"));
                list.add(enity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Integer addTK(TaiKhoan tk) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "insert into TaiKhoan(TaiKhoan, Pass, VaiTro)\n"
                + "values (?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tk.getMaTK());
            pstm.setString(2, tk.getPass());
            pstm.setBoolean(3, tk.isVaitro());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateTK(TaiKhoan tk) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "update TaiKhoan\n"
                + "set TaiKhoan = ?,Pass = ?,VaiTro = ?\n"
                + "where ID = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tk.getMaTK());
            pstm.setString(2, tk.getPass());
            pstm.setBoolean(3, tk.isVaitro());
            pstm.setInt(4, tk.getId());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer deleteTK(int id) {
        Integer row = null;
        Connection con = JDBCHelper.getConnection();
        String sql = "delete\n"
                + "from TaiKhoan\n"
                + "where id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}

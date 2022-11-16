/*
@author TuanPham
@Date Nov 17, 2022
 */
package com.myteam.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TravelApp.province;
import com.myteam.travel.db.ConnectMySQL;

public class ProvinceDao {

    public boolean insert(province province) {
        PreparedStatement pstm = null;
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "insert into tbProvince VALUES(?,?,?,?,?)";
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, province.getProvince());
            int i = pstm.executeUpdate();
            if (i > 0) {
                System.out.println("Thêm thành công");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                pstm.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(int id_province) {
        PreparedStatement pstm = null;
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "delete from  tbProvince where id = ?)";
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, id_province);
            int i = pstm.executeUpdate();
            if (i > 0) {
                System.out.println("xóa thành công");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                pstm.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<province> queryProvince() {
        ResultSet rs = null;
        List<province> list = new ArrayList<>();
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "select * from tbPlace ";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.executeQuery();
            rs = pstm.executeQuery();
            while (rs.next()) {
                province place = new province(rs.getInt(1), rs.getString(2));
                list.add(place);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

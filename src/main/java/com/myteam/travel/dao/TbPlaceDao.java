/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.dao;

import TravelApp.place;
import com.myteam.travel.db.ConnectMySQL;
import com.myteam.travel.model.ResPlace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uoc
 */
public class TbPlaceDao {

    public ResPlace list() {
        ResPlace resPlace = new ResPlace();

        ResultSet rs = null;
        List<place> list = new ArrayList<>();
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "select * from tbPlace";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.executeQuery();
            rs = pstm.executeQuery();
            while (rs.next()) {
                place place = new place(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                list.add(place);
            }
            resPlace.setItems(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resPlace;
    }

    public boolean insert(place place) {
        PreparedStatement pstm = null;
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "insert into tbPlace VALUES(?,?,?,?,?)";
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, place.getName());
            pstm.setString(2, place.getPhone());
            pstm.setString(3, place.getAdress());
            pstm.setString(4, place.getInfor());
            pstm.setInt(5, place.getId_province());
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

    public boolean delete(int id_place) {
        PreparedStatement pstm = null;
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "delete from  tbPlace where id = ?)";
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, id_place);
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

    public List<place> queryPlace(String placeName) {
        ResultSet rs = null;
        List<place> list = new ArrayList<>();
        Connection connect = ConnectMySQL.getMySQLConnect();
        try {
            String sql = "select * from tbPlace where name like ";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.setString(1, "%" + placeName + "%");
            pstm.executeQuery();
            rs = pstm.executeQuery();
            while (rs.next()) {
                place place = new place(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
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

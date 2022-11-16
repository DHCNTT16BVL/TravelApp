/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.dao;

import com.myteam.travel.db.DBSource;
import com.myteam.travel.model.ResPlace;
import com.myteam.travel.model.TbPlace;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uoc
 */
public class TbPlaceDao {

    public ResPlace list() {
        ResPlace resPlace = new ResPlace();
        List<TbPlace> list = new LinkedList<>();
        String sql = "select * from tbPlace";
        ResultSet rs = null;
        try {
            rs = DBSource.runQuery(sql);
            while (rs.next()) {
                TbPlace place = new TbPlace();
                place.setId(rs.getInt("id"));
                place.setName(rs.getString("name"));
                place.setPhone(rs.getString("phone"));
                place.setAddress(rs.getString("address"));
                place.setInfo(rs.getString("info"));
                place.setIdProvince(rs.getInt("IdProvince"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception ignore) {
            }
        }
        resPlace.setItems(list);
        return resPlace;
    }
}

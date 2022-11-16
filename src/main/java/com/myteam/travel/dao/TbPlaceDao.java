/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.dao;

import com.myteam.travel.db.DBSource;
import com.myteam.travel.model.TbPlace;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uoc
 */
public class TbPlaceDao {

    public List<TbPlace> list() {
        List<TbPlace> list = new LinkedList<>();
        String sql = "select * from tbPlace";
        ResultSet rs;
        try {
            rs = DBSource.runQuery(sql);
        } catch (Exception e) {
        } finally {
            //rs.close();
        }
        return list;
    }
}

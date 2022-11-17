/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import TravelApp.TravelPOA;
import TravelApp.place;
import TravelApp.province;
import com.myteam.travel.dao.PlaceDao;
import com.myteam.travel.dao.ProvinceDao;
import java.util.List;
import org.omg.CORBA.ORB;

/**
 *
 * @author uoc
 */
public class TravelImpl extends TravelPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }
    PlaceDao placedao = new PlaceDao();
    ProvinceDao provincedao = new ProvinceDao();

    @Override
    public boolean add(String placeName, String phone, String address, String info, int idProvince) { // thêm địa điểm mới

        place place = new place(1, placeName, phone, address, info, idProvince);
        if (placedao.insert(place)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {  /// xóa địa điểm
        if (placedao.delete(id)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(int id, String placeName, String phone, String address, String info, int idProvince) {  // cập nhật địa điểm
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public province findProvince() {

        return new province();
    }

    @Override
    public place findPlaceFromName(String name) {

        return new place();
    }

    @Override
    public place[] queryPlace(String name) {

        place[] list = placedao.queryPlace(name);
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override
    public province[] showAllProvince() {

        List<province> list = provincedao.queryProvince();
        if (list != null) {
            return (province[]) list.toArray();
        }
        return null;
    }

    @Override
    public place[] find(int idProvince) {

        PlaceDao tbPlaceDao = new PlaceDao();
        place[] items = tbPlaceDao.list();

        if (items != null) {

            return items;
        }
        return null;
    }

    @Override
    public boolean addProvince(int _id_province, String _province) { // thêm tỉnh thành mới

        province province = new province(_id_province, _province);
        if (provincedao.insert(province)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean DelProvince(int _id_province) { // xóa tỉnh thành 

        if (provincedao.delete(_id_province)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }
}

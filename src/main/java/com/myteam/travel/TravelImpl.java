/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import TravelApp.TravelPOA;
import TravelApp.place;
import TravelApp.province;
import com.myteam.travel.dao.PlaceDao;
import com.myteam.travel.model.ResPlace;
import java.util.List;
import org.omg.CORBA.ORB;

/**
 *
 * @author uoc
 */
public class TravelImpl extends TravelPOA {

    PlaceDao dao = new PlaceDao();
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public boolean add(String placeName, String phone, String address, String info, int idProvince) {

        place place = new place(1, placeName, phone, address, info, idProvince);
        if (dao.insert(place)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (dao.delete(id)) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(int id, String placeName, String phone, String address, String info, int idProvince) {
        return true;
    }

    @Override
    public place findPlaceFromName(String name) {

        return new place();
    }

    @Override
    public province findProvince() {

        PlaceDao tbPlaceDao = new PlaceDao();
        ResPlace resPlace = tbPlaceDao.list();

        String result = resPlace.toJson().toString();
        return new province();
    }

    public List<place> queryPlace(String placeName) {
        List<place> list = dao.queryPlace(placeName);
        if (list != null) {
            return list;
        }
        return null;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import TravelApp.TravelPOA;
import TravelApp.place;
import TravelApp.province;
import com.myteam.travel.dao.TbPlaceDao;
import com.myteam.travel.model.ResPlace;
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

    @Override
    public boolean add(String placeName, String phone, String address, String info, int idProvince) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
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

        return new province();
    }

    public String find(int idProvince) {
        TbPlaceDao tbPlaceDao = new TbPlaceDao();
        ResPlace resPlace = tbPlaceDao.list();

        String result = resPlace.toJson().toString();
        return result;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import TravelApp.TravelPOA;
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

    /**
     *
     * @param userName
     * @param pwd
     */
    @Override
    public String login(String userName, String pwd) {
        return "login";
    }

    /**
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public int register(String userName, String pwd) {
        return 1;
    }

    @Override
    public int add(String placeName, String phone, String address, String info, int idProvince) {
        return 1;
    }

    @Override
    public int delete(int id) {
        return 1;
    }

    @Override
    public int update(int id, String placeName, String phone, String address, String info, int idProvince) {
        return 1;
    }

    @Override
    public String find(int idProvince) {
        return "result";
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.model;

import TravelApp.place;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author uoc
 */
public class ResPlace {

    private List<place> items;

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        List<JSONObject> navJSON = new LinkedList<>();

        if (items != null) {
            for (place item : items) {
                //navJSON.add(item.toJson());
            }
            json.put("items", navJSON);
        }
       
        return json;
    }

    public List<place> getItems() {
        return items;
    }

    public void setItems(List<place> items) {
        this.items = items;
    }

}

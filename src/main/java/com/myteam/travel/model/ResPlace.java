/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.model;

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

    private List<TbPlace> items;

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        List<JSONObject> navJSON = new LinkedList<>();

        if (items != null) {
            for (TbPlace item : items) {
                navJSON.add(item.toJson());
            }
            json.put("items", navJSON);
        }
       
        return json;
    }

    public List<TbPlace> getItems() {
        return items;
    }

    public void setItems(List<TbPlace> items) {
        this.items = items;
    }

}

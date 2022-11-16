/*
@author TuanPham
@Date Apr 16, 2020
 */
package com.myteam.travel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {

    public static Connection getMySQLConnect() {
        Connection connect = null;
        String hostName = "103.130.213.10";
        String dbName = "TravelApp";
        String username = "cxluser";
        String password = "Thanh0974135042!";
        try {
            connect = getConnectMySQLWithParam(hostName, dbName, username, password);
            System.out.println(connect);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    private static Connection getConnectMySQLWithParam(String hostName, String dbName, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection connect = DriverManager.getConnection(url, username, password);
        return connect;
    }

//    public static void main(String[] args) {
//        getMySQLConnect();
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author uoc
 */
public class DBSource {

    private static String dbURL = "jdbc:mysql://103.130.213.10:3306/TravelApp";
    private static String userName = "cxluser";
    private static String password = "Thanh0974135042!";

    public DBSource() {

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static ResultSet runQuery(String sqlQuery) throws Exception {
        try (Connection conn = DBSource.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);) {
            ResultSet rs = stmt.executeQuery(sqlQuery);
            return rs;
        }
    }

    public static int runUpdate(String sqlQuery) throws Exception {
        try (Connection conn = DBSource.getConnection();
                Statement stmt = conn.createStatement();) {
            return stmt.executeUpdate(sqlQuery);
        }
    }
}

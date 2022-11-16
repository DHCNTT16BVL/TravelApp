/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import TravelApp.*;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author uoc
 */
public class TravelClient {

    static Travel travelImpl;
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is 
            // part of the Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Travel";
            travelImpl = TravelHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtained a handle on server object: " + travelImpl);
            place[] places = travelImpl.find(0);
            System.out.println(places);
            double nhap;
            System.out.print("Nhap vao so luong dai Fibonacci: ");
            nhap = sc.nextDouble();
            System.out.print("Chuoi Fibonacci " + (int) nhap + " so la: ");
            //String fi = travelImpl.fibonacci(nhap);
            //System.out.println(fi);
            //travelImpl.shutdown();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}

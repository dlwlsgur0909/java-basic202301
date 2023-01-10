package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;

public class Main {
    public static void main(String[] args) {
//        crewName: "총알탄소년단", myName: "춤신춤왕"
        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕");
        dancer.dance();
        System.out.println("================================");

        IdolDancer idolDancer = new IdolDancer("AB6IX", "이대휘");
        idolDancer.dance();
        System.out.println("=================================");

        IdolDancer idolDancer1 = new IdolDancer();
        idolDancer1.dance();
        System.out.println("===================================");

        StreetDancer streetDancer = new StreetDancer("길거리 춤꾼들", "박격포");
        streetDancer.dance();

    }
}
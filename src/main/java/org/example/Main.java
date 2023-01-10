package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

public class Main {
    public static void main(String[] args) {
//        crewName: "총알탄소년단", myName: "춤신춤왕"
//        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕");
//        dancer.dance();
//        System.out.println("================================");
//
//        IdolDancer idolDancer = new IdolDancer("AB6IX", "이대휘");
//        idolDancer.dance();
//        System.out.println("=================================");
//
//        IdolDancer idolDancer1 = new IdolDancer();
//        idolDancer1.dance();
//        System.out.println("===================================");
//
//        StreetDancer streetDancer = new StreetDancer("길거리 춤꾼들", "박격포");
//        streetDancer.dance();

        Dancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
        Dancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");

        Dancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿1");
        Dancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿2");

        PerformanceTeam team = new PerformanceTeam();
        team.joinDancer(idolDancer1);
        team.joinDancer(idolDancer2);
        team.joinDancer(streetDancer1);
        team.joinDancer(streetDancer2);

        team.groupDance();


    }
}
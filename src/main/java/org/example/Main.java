package org.example;

import org.example.basic.Dancer;
import org.example.beans.Goods;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

import java.util.HashSet;
import java.util.Set;

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

//        Dancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
//        Dancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");
//
//        Dancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿1");
//        Dancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿2");
//
//        PerformanceTeam team = new PerformanceTeam();
//        team.joinDancer(idolDancer1);
//        team.joinDancer(idolDancer2);
//        team.joinDancer(streetDancer1);
//        team.joinDancer(streetDancer2);
//
//        team.groupDance();

        Goods goods1 = new Goods("세탁기", 300000);
        Goods goods2 = new Goods("세탁기", 300000);

        // soutv
        System.out.println("goods1 = " + goods1);
        System.out.println("goods1.hashCode() = " + goods1.hashCode());
        System.out.println(Integer.toHexString(goods1.hashCode()));

        System.out.println("goods1 = " + goods1.toString());
        System.out.println("goods2 = " + goods2.toString());

        // equals 오버라이딩(마법사로 생성)
        System.out.println(goods1.equals(goods2));


        // Set Collection
        Set<Goods> set1 = new HashSet<>();
        set1.add(goods1);
        set1.add(goods2);
        System.out.println("set1 = " + set1);
        System.out.println("set1.size() = " + set1.size());

















    }
}
package org.example.inherit;

import org.example.basic.Dancer;

import javax.naming.directory.InitialDirContext;

public class IdolDancer extends Dancer {

    private int numberOfFan; // 팬의 수

    public IdolDancer() {
        System.out.println("idol dancer 생성됨");
    }

    public IdolDancer(String crewName, String myName) {
        super(crewName, myName);
        this.numberOfFan = 10;
        System.out.println("idol dancer 생성됨");
    }

    // 오버라이딩: 부모의 메서드 재정의
    // 부모의 메서드 시그니처(이름, 리턴타입, 파라미터)를 똑같이 맞춰야함
    @Override
    public void dance() {
        super.dance();
        wink();
    }

    private void wink() {
        System.out.println("윙크!");
    }



}

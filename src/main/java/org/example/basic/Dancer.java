package org.example.basic;

// Math. System. DanceLevel. 을 붙이지 않고 사용할 수 있다
//import static java.lang.Math.*;
//import static java.lang.System.*;
//import static org.example.basic.DanceLevel.*;

public abstract class Dancer {

    private final String crewName; // 팀의 이름
    private final String myName; // 내 이름
    private DanceLevel level = DanceLevel.BIGINNER; // 춤 수준 (전문가, 중수, 하수, 초보자)


    public  Dancer() {
        this("기본크루", "이름없음");
//        this.crewName = "기본크루";
//        this.myName = "이름없음";
    }

    public Dancer(String crewName, String myName) {
        this.crewName = crewName;
        this.myName = myName;
        System.out.println("그냥 dancer 생성됨!");
    }
    //        out.println();
    //        out.println(ceil(1.1 * PI));

    // 스트레칭 여부
    private boolean stretch;

    // 유연성 운동 여부
    private boolean flexible;

    private void stretch() {
        System.out.println(myName + "님이 스트레칭 합니다.");
        this.stretch = true;
    }

    // 다리찢기
    private void makeFlexible() {
        if(!stretch) {
            System.out.println("스트레칭 안해서 죽었습니다.");
            return;
        }
        this.flexible = true;
        System.out.println(myName + "님이 유연성 운동을 합니다.");
    }

    // 춤추기
    public abstract void dance();


    public String getCrewName() {
        return crewName;
    }

    public String getMyName() {
        return myName;
    }
}

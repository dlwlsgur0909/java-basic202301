package org.example.java8.anonymous;

public class Main {

    // 내부 클래스
    // 기능별로 구현을 하면 클래스 파일이 너무 많아지므로 내부 클래스 (inner class)를 활용
    public static class SubCalculator implements Calculator {

        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
    }


    public static void main(String[] args) {

        // 덧셈 기능을 구현한 계산기 객체를 생성
        Calculator addCal = new AddCalculator();
        System.out.println(addCal.operate(10, 20));

        // 내부 클래스를 활용한 뺄셈 기능
        Calculator subCal = new SubCalculator();
        System.out.println(subCal.operate(100, 20));

        // 내부 클래스 또한 기능마다 구현하면 코드가 너무 길어지므로 익명 클래스를 활용
        // 곱셈 기능
        Calculator multiCal = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        System.out.println(multiCal.operate(20, 5));

        //  익명 클래스 또한 코드가 너무 길어지므로 람다를 활용해 cleancode를 작성
        // 나눗셈 몫을 구하는 기능
        Calculator divCal = (n1, n2) -> n1 / n2;
        System.out.println(divCal.operate(100, 50));
        
        // 람다를 활용해서 객체를 매번 생성하는게 아니라 하나의 객체로만 실시간으로 기능 구현 
        PowerOperator op = (n1, n2, cal) -> cal.operate(n1, n2);
        int r1 = op.power(50, 60, (n1, n2) -> n1 + n2);
        System.out.println("r1 = " + r1);
        
        int r2 = op.power(500, 3, (n1, n2) -> n1 * n2);
        System.out.println("r2 = " + r2);

    }
}

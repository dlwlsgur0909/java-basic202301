package org.example.java8.lambda;

import lombok.*;

import javax.swing.*;
import java.util.List;
import java.util.logging.Filter;

public class Main {

    // 무게가 100g 이하인 사과 필터 조건 클래스
    public static class LightApplePredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 100;
        }
    }

    public static void main(String[] args) {

        //  사과 바구니 생성
        List<Apple> appleList = List.of(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(97, Color.RED),
                new Apple(200, Color.GREEN),
                new Apple(85, Color.YELLOW),
                new Apple(75, Color.YELLOW),
                new Apple(50, Color.RED)
        );

        List<Apple> greenApples = FilteringApple.filterGreenApples(appleList);

        System.out.println("===== 녹색 사과 필터링 =====");
        for(Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        List<Apple> wantedColorApples = FilteringApple.filterAppleByColor(appleList, Color.RED);
        System.out.println("===== 원하는 색 사과 필터링 ======");
        for (Apple apple : wantedColorApples) {
            System.out.println(apple);
        }


        System.out.println("===== 원하는 조건으로 필터링 (노란 사과)=====");

        // 노란 사과만 필터링
        List<Apple> yellowApples = FilteringApple.filterApples(appleList, new YellowApplePredicate());
        for (Apple apple : yellowApples) {
            System.out.println(apple);
        }

        System.out.println("===== 원하는 조건으로 필터링 (가벼운 사과)=====");

        // 무게가 100g 이하인 사과만 필터링 (필터링 조건이 추가될 때마다 클래스 파일을 만들어야 하니 내부 클래스로 해결)
        List<Apple> lightApples = FilteringApple.filterApples(appleList, new LightApplePredicate());
        for (Apple apple : lightApples) {
            System.out.println(apple);
        }

        System.out.println("===== 원하는 조건으로 필터링 (무거운 사과)=====");

        // 무게가 100g 보다 무거운 사과 필터링 (내부 클래스를 계속 만드는 것도 비효율적이니 익명 클래스로 해결)
        List<Apple> heavyApples = FilteringApple.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        });

        for (Apple apple : heavyApples) {
            System.out.println(apple);
        }

        System.out.println("===== 원하는 조건으로 필터링 (녹색 사과)=====");

        // 녹색 사과만 필터링 (람다를 활용하여 더 간단하게 구현)
        // 람다 사용 전제 조건 : 인터페이스에 추상 메서드가 하나만 존재해야 한다 !!!
        //                     추상 메서드가 아닌 다른 메서드는 존재해도 가능하다 (default, static)
        // 람다가 오버라이딩 하는 메서드가 단 한 줄일 경우 중괄호 생략 가능
        // 그 한 줄이 리턴문이라면 return 키워드 생략 가능
        // 파라미터가 단 한개라면 소괄호 생략 가능
        List<Apple> green = FilteringApple.filterApples(appleList, (apple) -> apple.getColor() == Color.GREEN);
        for (Apple apple : green) {
            System.out.println(apple);
        }

        // 100g 이하이고 색상이 빨간 사과 필터링
        List<Apple> option = FilteringApple.filterApples(appleList, apple -> apple.getColor() == Color.RED && apple.getWeight() >= 100);


        System.out.println("===== 제네릭 필터 메서드 =====");
        List<Apple> red = FilteringApple.filter(appleList, apple -> apple.getColor() == Color.RED) ; // 빨간 사과만 필터링
        System.out.println(red);


        List<Integer> numbers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );

        List<Integer> evenNumbers = FilteringApple.filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);


        /** 리스트와 변경 조건을 전달하면 리스트 내부의 값을 변경 조건에 따라
         * 변환한 뒤 반환하는 map이라는 메서드를 구현해보세요
         *
         * ex)  map(appleList, apple -> apple.setColor(Color.RED))
         *      => 리스트 안의 모든 사과가 빨간색으로 변해야 한다 (오렌지여도 가능하게 범용성)
         *
         */

        System.out.println("===== 과제 =====");


        List<Color> colors = TestMap.map(appleList, apple -> apple.getColor());
        System.out.println(colors);

        List<Integer> weights = TestMap.map(appleList, Apple::getWeight);
        System.out.println(weights);

        List<Apple> changeColorToRed = TestMap.map(appleList, (apple) -> {
            apple.setColor(Color.GREEN);
            return apple;
        });

        for(Apple apple : changeColorToRed) {
            System.out.println(apple);
        }

        List<AppleInfo> appleInfo = TestMap.map(appleList, AppleInfo::new);

        for(AppleInfo info : appleInfo) {
            System.out.println(info);
        }


    }

    @Getter @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AppleInfo {

        private Color color;
        private int weight;

        public AppleInfo(Apple a) {
            this.color = a.getColor();
            this.weight = a.getWeight();
        }
    }

}

package org.example.java8.stream;

public class Finding {

    public static void main(String[] args) {
        
        // anyMatch: 주어진 스트림에서 '적어도' 한 요소와 일치하는게 있는지 
        // return type = boolean
        // 요리 목록중 채식주의자가 먹을 수 있는 요리가 하나라도 있는가??

        boolean flag1 = Dish.menu.stream()
                .anyMatch(d -> d.isVegeterian()); // predicate 조건

        System.out.println("flag1 = " + flag1);

        System.out.println("=======================");

        // 100cal 미만인 요리가 하나라도 있는가?
        boolean flag2 = Dish.menu.stream()
                .anyMatch(d -> d.getCalories() < 100);

        System.out.println("flag2 = " + flag2);
        
        
        // allMatch: 모든 요소가 조건에 일치하는지 확인
        // 모든 요리가 1000cal 미만인가?

        boolean flag3 = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 1000);

        System.out.println("flag3 = " + flag3);

        // noneMatch: allMatch의 반대 연산
        // 모든 요소가 조건과 일치하지 않는지 확인
        // 모든 메뉴의 이름의 길이는 5글자 보다 큰가?

        boolean flag4 = Dish.menu.stream()
                .noneMatch(d -> d.getName().length() > 5);

        System.out.println("flag4 = " + flag4);

    }
}

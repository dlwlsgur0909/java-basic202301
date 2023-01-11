package org.example.java8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {


        // stream의 filter 기능 : 리턴 조건에 맞는 데이터만 필터링
        // 요리 목록중 채식 주의자가 먹을 수 있는 음식만 필터링

        List<Dish> vegeterianDishes = Dish.menu.stream()
             .filter(Dish::isVegeterian)
             .collect(Collectors.toList());


//     for (Dish d : vegeterianDishes) {
//         System.out.println(d);
//     }

        // 출력을 스트림으로 (.stream 생략하고 .forEach 가능)
        vegeterianDishes.stream().forEach(dish -> System.out.println(dish.getName()));
        vegeterianDishes.forEach(System.out::println);


        System.out.println("===== 과제 =====");

        //  요리 목록중 고기면서 600칼로리 미만인 요리만 필터링
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() < 600 && dish.getType()== Dish.Type.MEAT)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("=================================");

        // 필터링 된 요소 중복 제거
        List<Integer> nums = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);

        // nums 리스트에서 짝수만 필터링 한 후 중복을 제거해주세요
        nums.stream()
                .filter(num -> num % 2 == 0)
                .distinct() // 중복 제거
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("=================================");

        // 원하는 개수만 필터링 하기
        // 칼로리가 300cal 보다 높은 요리중 처음 발견된 3개만 필터링
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3) // 개수 제한
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("=================================");

        // 요소 생략해서 필터링
        // 칼로리가 300cal 보다 높은 요리중에 처음 2개는 제외하고 필터링
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("=================================");

        // 스트림을 사용해서 처음 등장하는 고기 요리 2개를 필터링
        Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);





    }



}

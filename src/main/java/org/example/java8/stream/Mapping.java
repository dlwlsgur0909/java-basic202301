package org.example.java8.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        
        
        List<String> dishNames = Dish.menu.stream()
                                        .map(dish -> dish.getName())
                                        .collect(Collectors.toList());

        System.out.println(dishNames.size());
        System.out.println("dishNames = " + dishNames);

        System.out.println("==================================");

        List<String> words = List.of(
                "safari", "chrome", "ms edge", "opera", "firefox"
        );

        List<Integer> wordLengths = words.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());

        System.out.println("wordLengths = " + wordLengths);

        System.out.println("==================================");

        List<Integer> nums = List.of(1,2,3,4,5);

        // nums의 요소들을 각각 제곱해서 새로운 리스트를 얻어내고 싶다

        List<Integer> squares = nums.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());

        System.out.println("squares = " + squares);

        // Dish 메뉴의 총 칼로리 수

        System.out.println("==================================");

        int totalCalorie = Dish.menu.stream()
                .mapToInt(dish -> dish.getCalories())
                .sum();

        System.out.println("totalCalorie = " + totalCalorie);

        // 육류 메뉴 칼로리의 평균

        System.out.println("==================================");

        OptionalDouble meatDishAvg = Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .mapToInt(dish -> dish.getCalories())
                .average();

        // Optional은 자동 널체크 지원 : ifPresent()
        meatDishAvg
                .ifPresent(cal -> System.out.println("cal = " + cal));

        System.out.println("meatDishAvg = " + meatDishAvg);




    }
}

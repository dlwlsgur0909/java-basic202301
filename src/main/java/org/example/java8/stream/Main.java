package org.example.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
        요리 목록에서 칼로리가 400칼로리 보다 낮은 요리들만 추출해서
        칼로리가 낮은 순으로 오름차 정렬한 후
        그 요리의 이름들만 추출해서 리스트로 만들고 싶다.
     */

    // 스트림을 사용하지 않은 코드
    public static List<String> getHealthyDishName1(List<Dish> menu) {

        // 400cal 미만 요리만 담는 리스트
        List<Dish> lowCalorieDishes = new ArrayList<>();

        for(Dish d : menu) {
            if(d.getCalories()<400) {
                lowCalorieDishes.add(d);
            }
        }
        lowCalorieDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });
//        lowCalorieDishes.sort(Comparator.comparing(Dish::getCalories));


        List<String> dishNames = new ArrayList<>();
        for(Dish d : lowCalorieDishes) {
            dishNames.add(d.getName());
        }

        return dishNames;
    }

    // 스트림을 사용한 코드
    public static List<String> getHealthyDishName2(List<Dish> menu) {
        return menu.stream()
                .filter((dish) -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<String> dishName1 = getHealthyDishName1(Dish.menu);
        System.out.println("dishName1 = " + dishName1);

        List<String> dishName2 = getHealthyDishName2(Dish.menu);
        System.out.println("dishName2 = " + dishName2);





    }


}

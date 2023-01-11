package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {
    /**
     * @solution - try1 : 녹색 사과를 필터링 하는 메서드를 만들어야 함
     * @problem
     * - 만약 다른 색깔 사과를 필터링해야되는 경우에는?
     * - 새로운 메서드를 또 만들어야 한다?!
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * @solution - try2 : 색상을 파라미터화 한다
     * @problem
     * - 만약 필터링 기준이 색상이 아니라 무게라면?
     * - 두번째 파라미터로 무게 기준을 받는 메서드를 또 만들어?!?!
     * - 필터링 기준이 다양하다면?!
     */

    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == color) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * @solution - try3 : 동작을 파라미터화 한다  - 추상적 조건으로 필터링
     * @problem
     * - 과일이 사과가 아니라 오렌지라면???
     * - 과일이 아니라 가전제품이라면??
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * @solution - try4 : 제네릭 필터 메서드 생성
     */

    public static <T> List<T> filter(List<T> inventory, GenericPredicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t : inventory) {
            if(p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }





}

package org.example.java8.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = List.of(9, 4, 3, 2, 3, 6, 7);
        List<String> strs = List.of("apple", "banana", "홍길동");


        List<Person> pList = new ArrayList<>(
                List.of(
                    new Person("김철수", 33),
                    new Person("홍길동", 16),
                    new Person("박영희", 44),
                    new Person("김희수", 22)
                )
        );

//        pList.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                // Person 클래스에서 compareTo를 오버라이딩 하지 않아도 사용가능
//                // return o2.getAge() - o1.getAge();
//                // 이름 순
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // 위 sort를 람다식으로 변경
        pList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        pList.sort(Comparator.comparingInt(Person::getAge));
        System.out.println(pList);
        pList.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(pList);
        pList.sort(Comparator.comparing(Person::getName));
        System.out.println(pList);

    }
}

package org.example.java8.compare;

import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {

        /*
            비교 대상 객체 2개(this, o)를 전달 받아서
            비교 대상(o)이 더 크면 음수,
            같으면 0
            작으면 양수 리턴
         */


        return this.age - o.getAge();
    }
}

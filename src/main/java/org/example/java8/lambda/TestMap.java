package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestMap {

    public static <T, R> List<R> map(List<T> list, TestPredicate<T, R> p) {

        List<R> newList = new ArrayList<>();

        for(T target : list) {
            newList.add(p.change(target));
        }

        return newList;
    }

}

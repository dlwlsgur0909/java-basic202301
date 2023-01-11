package org.example.java8.lambda;

@FunctionalInterface
public interface TestPredicate<T, R> {

    R change(T t);



}

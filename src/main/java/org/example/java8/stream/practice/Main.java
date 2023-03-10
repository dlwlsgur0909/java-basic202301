package org.example.java8.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );


        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>

        transactions.stream()
                    .filter(transaction -> transaction.getYear()==2021)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


        System.out.println("================================================");


        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.
        // List<Trader>
        System.out.println("================================================");

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("================================================");


        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        // List<String>

        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted() // 정렬 리스트 대상이  String이나 숫자 타입이면 Comparator를 안써도 정렬이 된다
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("================================================");

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean prob5 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println("prob5 = " + prob5);

        System.out.println("================================================");

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력
        int cambridgeValueSum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();

        System.out.println("cambridgeValueSum = " + cambridgeValueSum);

        System.out.println("================================================");

        // 연습 7: 모든 거래에서 최고 거래액은 얼마인가?
        OptionalInt maxTransactionValue = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max();

        maxTransactionValue
                .ifPresent(maxValue -> System.out.println("maxValue = " + maxValue));

        System.out.println("================================================");

        // 연습 8: 가장 작은 거래액을 가진 거래정보 탐색
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparing(t -> t.getValue()));

        minTransaction
                .ifPresent(t -> System.out.println("minTransaction = " + t));

    }
}

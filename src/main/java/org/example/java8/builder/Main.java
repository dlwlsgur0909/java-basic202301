package org.example.java8.builder;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // 회원 객체 생성
//        Member m = new Member("abc1234", "1234");

        Member m = Member.builder()
                .account("abc1234")
                .password("1234")
                .age(22)
                .regDate(LocalDateTime.now())
                .build();


        Board b = Board.builder()
                .content("글 내용")
                .writer("작성자")
                .id(100L)
                .title("글 제목")
                .build();

        System.out.println("b = " + b);

    }
}

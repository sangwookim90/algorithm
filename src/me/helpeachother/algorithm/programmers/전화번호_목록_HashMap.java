package me.helpeachother.algorithm.programmers;

import java.util.Arrays;

public class 전화번호_목록_HashMap {

    public static void main(String[] args) {

        String[] pb = {"119", "97674223", "1195524421"};
        System.out.println(solution(pb));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;


        String pb0 = phone_book[0];
        String pb1 = phone_book[1];
        String pb2 = phone_book[2];
        
        System.out.println(pb0.compareTo(pb1));
        System.out.println(pb0.compareTo(pb2));
        


        return answer;
    }
}

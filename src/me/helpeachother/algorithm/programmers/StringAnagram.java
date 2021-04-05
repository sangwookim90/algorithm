package me.helpeachother.algorithm.programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {

    public static void main(String[] args) throws IOException {
        List<String> dictionary = new ArrayList<>();
        List<String> query = new ArrayList<>();

        dictionary.add("heater");
        dictionary.add("cold");
        dictionary.add("clod");
        dictionary.add("reheat");
        dictionary.add("docl");

        query.add("codl");
        query.add("heater");
        query.add("abcd");

        System.out.println(stringAnagram(dictionary,query));

    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();

        for(String word : query) {
            int count=0;
            char[] w = word.toCharArray();
            Arrays.sort(w);
            for(String dict : dictionary) {
                char[] d = dict.toCharArray();
                Arrays.sort(d);

                if(String.valueOf(w).equals(String.valueOf(d))) {
                    count++;
                }
            }

            answer.add(count);
        }

        return answer;

    }


}

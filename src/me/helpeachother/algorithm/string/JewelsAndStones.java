package me.helpeachother.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {

        String j = "aA";
        String s = "aAAbbbb";

        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.solve(j,s));

    }

    public int solve(String jew, String stone) {
        Set<Character> characters = new HashSet<>();
        for(char c : jew.toCharArray()) {
            characters.add(c);
        }
        int count=0;
        for(char c : stone.toCharArray()) {
            if(characters.contains(c)) {
                System.out.println(c);
                count++;
            }
        }

        return count;
    }


}

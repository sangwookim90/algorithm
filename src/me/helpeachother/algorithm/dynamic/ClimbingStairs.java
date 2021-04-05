package me.helpeachother.algorithm.dynamic;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

        int input=5;

        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(input));
    }


    public int climbStairs(int n) {
        return exp(0, n);
    }

    private int exp(int val, int input) {
        if(val==input) return 1;
        if(val>input) return 0;

        return exp(val+1, input) + exp(val+2, input);
    }
}

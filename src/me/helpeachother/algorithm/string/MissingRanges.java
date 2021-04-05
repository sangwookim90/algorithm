package me.helpeachother.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {

        int[] nums = {2,3,5,50,75};
        int lower=0;
        int upper=99;

        System.out.println(solve(nums,lower,upper));


    }

    static List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        String item = "";
        
        if (nums[0] > lower) {
            item = lower + "->" + (nums[0]-1);
            result.add(item);
        }

        for(int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                int term = term(nums[i - 1], nums[i]);

                if (term == 2) {
                    item = String.valueOf(nums[i] - 1);
                } else if (term > 2) {
                    item = (nums[i - 1] + 1) + "->" + (nums[i] - 1);
                }

                result.add(item);
            }
        }

        if(nums[nums.length-1] != upper) {
            item = (nums[nums.length-1]+1) + "->" + upper;
            result.add(item);
        }


        return result;
    }

    static int term(int n1, int n2) {
        return n2-n1;
    }

    static String makeRange(int low, int high) {
        return low==high ? String.valueOf(low) : (low + "->" + high);
    }
}

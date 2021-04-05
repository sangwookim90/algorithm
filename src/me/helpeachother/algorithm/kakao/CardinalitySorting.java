package me.helpeachother.algorithm.kakao;

import java.util.ArrayList;
import java.util.List;

public class CardinalitySorting {

    public static void main(String[] args) {
        int n=4;
        List<Integer> nums = new ArrayList<>();

        nums.add(31);
        nums.add(15);
        nums.add(7);
        nums.add(3);
        nums.add(2);

        System.out.println(cardinalitySort(nums));
    }

    public static List<Integer> cardinalitySort(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.size();
        int[][] trans = new int[size][2];

        for(int i=0; i<size; i++) {
            int count=0;
            char[] num = Integer.toBinaryString(nums.get(i)).toCharArray();
            
            for (int j=0; j<num.length; j++) {
                if(num[j]=='1') count++;
            }
            trans[i][0] = nums.get(i);
            trans[i][1] = count;
        }


        for(int i=0; i<size; i++) {
            for (int j = i; j < size; j++) {
                if (trans[i][1] > trans[j][1]) {
                    int[] tmp = trans[j];
                    trans[j] = trans[i];
                    trans[i] = tmp;
                }
            }
        }

        for(int i=0; i<trans.length; i++){
            result.add(trans[i][0]);
        }

        
        return result;
    }


}

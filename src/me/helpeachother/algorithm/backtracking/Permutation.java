package me.helpeachother.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute_dfs(input));

    }
    public List<List<Integer>> permute_dfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if(nums==null || nums.length==0) return result;
        dfs(nums, result, list);


        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur){

        // curs에 3개가 채워지면
        if(cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for(int i=0; i<nums.length; i++) {
            //if(cur.size()==nums.length) continue; // for 탈출  --> 가능한 조합 전체 구할 때
            if(cur.contains(nums[i])) continue; // 중복 제거

            // cur : {1} {1,2} {1,2,3}
            cur.add(nums[i]);
            dfs(nums, lists, cur);
            cur.remove(cur.size()-1);
        }


    }

    
    public List<Integer> exp(List<Integer> list, int[] nums, int idx) {
        if(idx>=nums.length) return list;
        list.add(nums[idx]);
        System.out.println("idx: " + idx);

        for(int i=0; i<nums.length; i++){
            System.out.println();
            if(!list.contains(nums[i])){
                System.out.println("nums["+i+"]: " + nums[i] + " idx: " + idx);
                return exp(list, nums, idx+1);
            }
        }
        return list;
    }

}

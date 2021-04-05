package me.helpeachother.algorithm.string;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        #3 TwoSum
        int[] nums = {2,8,11,14};
        int target = 16;
        int[] result = twoSum(nums, target);
        for(int i: result) {
            System.out.println(i);
        }

//        #4 Daily Temperature
//        int [] tempList = {73,74,75,71,60,72,76,73};
//        int[] result = dailyTemperatures(tempList);
//        for (int value : result) {
//            System.out.println(value);
//        }

//        #5 MergeInterval
//        Interval int1 = new Interval(1,3);
//        Interval int2 = new Interval(2,6);
//        Interval int3 = new Interval(8,10);
//        Interval int4 = new Interval(15,18);
//
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(int1);
//        intervals.add(int3);
//        intervals.add(int2);
//        intervals.add(int4);
//
//        List<Interval> result = merge(intervals);
//        for(Interval interval : result) {
//            System.out.println(interval.start+", "+interval.end);
//        }
    }

    static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        // 1. data structure
        List<Interval> result = new ArrayList<>();

        // 오름차순
        //Collections.sort(intervals, (a,b)->a.start-b.start);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval before = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(before.end >= current.start){
                before.end = Math.max(before.end, current.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    static void print(List<Interval> list){
        for(Interval interval: list) {
            System.out.println(interval.start + ", " + interval.end);
        }
    }


    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static int[] dailyTemperatures(int[] temperatures) {
        // 1. data structure
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        // 2. for, while
        for(int i = 0; i<temperatures.length-1; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
        }
        return result;
    }

    static int[] dailyTemperatures_practice(int[] temperatures) {
        // A와 다음 인덱스(B)의 값과 비교
        // gap 은 0으로 초기화
        // A < B 인경우, gap = B.idx - A.idx


        int[] result = new int[temperatures.length];

        for(int i = 0; i<temperatures.length-1; i++){
            int gap = 0;

            for(int j=i+1; j<temperatures.length; j++){
                if(temperatures[i] < temperatures[j]){
                    System.out.println("i: " + i + "/ j: " + j);
                    gap= j-i;
                    result[i] = gap;
                    break;
                }
            }

        }

        return result;
    }

    // #3 TwoSum
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                result[0] = value+1;
                result[1] = i+1;
            } else {
                map.put(target-nums[i], i);
            }
        }

        return result;
    }
    static int[] twoSum_practice(int[] nums, int target) {
        // 두개의 숫자를 순차적으로 뽑고
        // 더해보고
        // target과 같으면 인덱스 뽑아내기

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++){
                System.out.println("left: " + nums[i]);
                System.out.println("right: " + nums[j]);
                if (nums[i]+nums[j] == target) {
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        return null;
    }




}

package me.helpeachother.algorithm.string;

import java.util.*;

public class MeetingRoom2 {
    
    public static void main(String[] args) {

        Interval int1 = new Interval(0,30);
        Interval int2 = new Interval(4,9);
        Interval int3 = new Interval(5,15);
        Interval int4 = new Interval(10,16);

        Interval[] intervals = {int1, int2, int3, int4};
        int count = solve(intervals);
        
        System.out.println(count);
        
        
    }

    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0; }
        Interval(int s, int e) { start = s;
            end = e; }
    }

    static int solve(Interval[] intervals) {
        // 1. sorting

//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return 0;
//            }
//        });

        // 오름차순
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        // endtime에 대한 priority queue
        Queue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);

        if(intervals == null || intervals.length == 0) return 0;

        pq.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++) {

            if(pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i]);
            
        }
        return pq.size();
    }

    static void print(List<Interval> list){
        for(Interval interval: list) {
            System.out.println(interval.start + ", " + interval.end);
        }
    }
}

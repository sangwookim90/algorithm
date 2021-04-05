package me.helpeachother.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MeetingRoom {
    
    public static void main(String[] args) {
        //        #1 MeetingRoom
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 3);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(6, 20);

        System.out.println(meetingRoom(intervals));
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

    // #1 MeetingRoom
    static boolean meetingRoom(Interval[] intervals) {

        Arrays.sort(intervals, (a,b)->a.start-b.start);

        int start=0, end=0;

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i].start < end) return false;

            if(intervals[i].start > start) start = intervals[i].start;
            if(intervals[i].end > end) end = intervals[i].end;

        }



        return true;
    }
}

package me.helpeachother.algorithm.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 셔틀버스 {
    public static void main(String[] args) {

        // 셔틀 운행 횟수
        int n = 2;

        // 셔틀 운행 간격
        int t = 10;

        // 최대 탑승 인원
        int m = 2;

        // 크루 정류장 도착 타임테이블
        String[] timetable = {"09:10","09:09","08:00"};

        System.out.println(solve(n,t,m,timetable));


    }


    static String solve(int n, int t, int m, String[] timetable) {

        String answer = "";
        // timetable sort
        Arrays.sort(timetable);

        // 버스 도착 시간 계산
        String[] busTime = new String[n];
        for(int i=0; i<n; i++) {
            busTime[i] = getAddTime("09:00", t*i);
        }

        String lastBustTime = busTime[n-1];

        // 버스 순번
        int curPos = 0;
        // 현재 버스 탑승 인원
        int curAdded = 0;
        String busStop = "";

        for(int j=0; j<busTime.length; j++) {
            busStop=busTime[j];
            curAdded=0;

            //순차적으로 버스가 들어옴을 for로 처리
            for(int k=curPos; curPos<timetable.length; k++) {
                // 현재 버스 시간 이전에 도착한 사람이 있는 경우 && 현재 버스에 빈자리가 있는 경우
                if(getMinLong(busStop)>=getMinLong(timetable[k]) && curAdded<m) {
                    answer = timetable[curPos]; //마지막 탑승 가능한 사람 도착 시간 임시 저장
                    answer = getAddTime(answer, -1); // 마지막 탑승 가능자보다 1분 빨리오도록 저장
                    curPos++;
                    curAdded++;
                    // curAdded < m 버스 자리가 여유있고, 마지막 탑승객이면 현재 버스 시간에 맞게 나감
                    if(j== busTime.length-1 && k==timetable.length-1 && curAdded <m) {
                        answer = busTime[n-1];
                    }
                }
                // 현재 버스에 자리가 없는 경우
                else {
                    // 마지막 버스인데 탑승객이 전부 못타는 경우, 최종탑승자(answer)보다 빨리 와야 탈수 있음
                    if(j==busTime.length-1 && curPos >= 1) {
                        //마지막 탑승 가능한 사람 도착 시간 임시저장
                        answer = timetable[curPos-1];
                        answer = getAddTime(answer, -1);
                    }
                    break;
                }
            }

        }

        // 마지막 버스를 타도 여유가 있는 경우
        if("".equals(answer)||getMinLong(answer)>getMinLong(lastBustTime)) {
            answer = lastBustTime;
        }


        /**
         *  막차 시간의 직전 시간부터 막차 도착시간 사이에 도착하는 크루의 인원 수(crew) count
         *
         *  if(crew >= n) 이면, 미리 와야한다.
         *  else 막차 시간에 맞춰온다.
         *
         */



        return answer;
    }

    /**
     * hh:mm의 String을 입력받아 addMin만큼 더한 시간 리턴
     * @param hhmm
     * @param addMin
     * @return hhmm분에 addMin분 을 합산한 시간
     */
    private static String getAddTime(String hhmm, int addMin) {
        long temp = getMinLong(hhmm);
        temp = temp + addMin;
        int hh = (int)temp/60;
        int mm = (int)temp%60;
        return String.format("%02d", hh)+":"+String.format("%02d", mm);

    }

    /**
     * hh:mm 의 스트링을 입력받아 long형태의 분으로 리턴
     * 입력 String 01:30, 출력 long 90
     * @param hhmm
     * @return long타입의 분
     */
    private static long getMinLong(String hhmm) {
        String arr[] = hhmm.split(":");
        int hh = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1]);
        return hh*60+mm;
    }

}

package me.helpeachother.algorithm.programmers;

public class Greedy_체육복 {
    public static void main(String[] args) {

        int n = 5;
        int[] lost = new int[] {2,3,4};
        int[] reserve = new int[] {3};

        Greedy_체육복 greedy_체육복 = new Greedy_체육복();

        System.out.println(greedy_체육복.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l - 1]--;    // lost : -1
        for (int r : reserve)
            people[r - 1]++;    // reserve : +1

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) { // lost
                if (i - 1 >= 0 && people[i - 1] == 1) { // i-1 사람이 reserve인 경우
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) { // i+1 인 경우
                    people[i]++;
                    people[i + 1]--;
                } else
                    answer--;
            }
        }
        return answer;
    }


    public int solution_prac(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int has = n-lost.length;

        for (int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]+1==reserve[j] || lost[i]-1==reserve[j]) {
                    reserve[j]=-1;
                    lost[i]=-1;
                    has++;
                }
            }
        }

        answer = has;


        return answer;
    }

}

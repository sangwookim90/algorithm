package me.helpeachother.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_완전탐색 {

    public static void main(String[] args) {

//        int[] answer = {1,3,2,4,2};
//        int[] answer = {1,2,3,4,5};
        int[] answer = {1,2,5,2,2,1,2,5,2,2,1,2,5,2,2,1,2,5,2,2,1,2,5,2,2};
        System.out.println(solution(answer)[0]);

    }

    static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;

        return answer;
    }

    public static int[] solution_prac(int[] answers) {

        int[] person1= {1, 2, 3, 4, 5};
        int[] person2= {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answer1 = 0, answer2=0, answer3=0;

        for(int i=0; i<answers.length; i++) {
            if (answers[i] == person1[i%person1.length]) answer1++;
            if (answers[i] == person2[i%person2.length]) answer2++;
            if (answers[i] == person3[i%person3.length]) answer3++;
        }

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

        int maxScore = Math.max(answer1, Math.max(answer2,answer3));
        ArrayList<Integer> list = new ArrayList<>();
        if(answer1==maxScore) list.add(1);
        if(answer2==maxScore) list.add(2);
        if(answer3==maxScore) list.add(3);
        int size = list.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


}

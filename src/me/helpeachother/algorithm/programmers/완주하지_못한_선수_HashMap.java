package me.helpeachother.algorithm.programmers;

import java.util.*;

public class 완주하지_못한_선수_HashMap {


    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};

        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        
        System.out.println(solution(participant, completion));
        
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);



        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static String solution_prac(String[] participant, String[] completion) {
        String answer = "";

        List<String> list = new ArrayList<>();

        for(int i=0; i<participant.length; i++) {
            list.add(participant[i]);
        }

        for(int i=0; i<completion.length; i++) {
            if(list.contains(completion[i])) list.remove(completion[i]);
        }

        answer =list.get(0);

        return answer;
    }
}

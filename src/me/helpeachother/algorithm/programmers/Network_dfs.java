package me.helpeachother.algorithm.programmers;

public class Network_dfs {

    public static void main(String[] args) {
        int[][] computers = {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
//                {1,1,1,1},
//                {0,1,1,0},
                {0,0,0,1}
        };

        Network_dfs networkDfs = new Network_dfs();
        System.out.println(networkDfs.solution(4, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] chk = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if(!chk[i]) {
                System.out.println(i);
                dfs(computers, chk, i);
                answer++;
            }
        }

        System.out.println(answer);

        return answer;
    }

    private void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}

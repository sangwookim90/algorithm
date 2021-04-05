package me.helpeachother.algorithm.programmers;

public class TargetNumber_dfs {

    public static void main(String[] args) {

        int[] input = {1,1,1,1,1};
        int target = 3;

        TargetNumber_dfs targetNumberDfs = new TargetNumber_dfs();
        System.out.println(targetNumberDfs.solution(input, target));

    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);


        return answer;

    }

    private int dfs(int[] numbers, int node, int sum, int target) {

        if(node == numbers.length) {
            if(sum==target) return 1;
            return 0;
        }

        return dfs(numbers, node+1, sum-numbers[node], target) +
                dfs(numbers, node+1, sum+numbers[node], target);

    }
}

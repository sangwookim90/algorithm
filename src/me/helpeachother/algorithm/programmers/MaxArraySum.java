package me.helpeachother.algorithm.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxArraySum {

    public static void main(String[] args) {

//        int[] input = {3, 7, 4, 6, 5};
//                int[] input = {-2, 1, 3, -4, 5};
//        int[] input = {2,1,5,8,4};
        int[] input = {3,5,-7,8,10};

        System.out.println(maxSubsetSum(input));


    }

    static int maxSubsetSum(int[] arr) {
        int max = 0;

        int[] dp = new int[arr.length + 1];
        dp[0] = 0; dp[1] = arr[0]; dp[2] = arr[1];
        for(int i = 3; i <= arr.length; i++) {
            int tmp = Math.max(dp[i-2], dp[i-3]);
            if(0 <= arr[i-1]) dp[i] = Math.max(arr[i-1], tmp + arr[i-1]);
            else dp[i] = tmp;

            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum_prac(int[] arr) {

        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);

        for(int i=0; i<arr.length; i++) {
            dfs(queue, arr, i,arr[i], 0);
        }

        return queue.poll();
    }

    static void dfs(Queue<Integer> queue, int[] arr, int i, int sum, int count) {
//        System.out.println("===========================");
//        System.out.println("i: " + i + " sum: " + sum + " count: " + count);
        
        if(i>=arr.length) return;
        sum += arr[i];

        if(count>0) {
//            System.out.println("arr["+i+"]: " + arr[i]);
//            System.out.println("in queue : " + sum);
            queue.offer(sum);
        }
        for(int j=2; j<arr.length-i; j++) {
//            System.out.println("j: " + j);
            dfs(queue,arr,i+j,sum,count+1);
        }

    }


}

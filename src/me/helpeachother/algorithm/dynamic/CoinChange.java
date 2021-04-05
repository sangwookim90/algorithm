package me.helpeachother.algorithm.dynamic;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange a = new CoinChange();
        System.out.println(a.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;

        for(int i=1; i<max; i++) {
            for(int j=0; j<coins.length; j++) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }

        }

        return dp[amount]>amount ? -1: dp[amount];



    }


    public int coinChange_anw(int[] coins, int amount) {

        // data set
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            for(int j=0; j<coins.length; j++){
                if(i>=coins[j]) {
                    System.out.println("================= i: " + i +" ====================");
                    System.out.println("================= j: " + j +" ====================");
                    System.out.println("dp[i]: " + dp[i]);
                    System.out.println("dp[i-coin]: "+ dp[i-coins[j]]);
                    
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    System.out.println("dp: " + dp[i]);
                }
            }
        }
        return dp[amount]>amount ? -1: dp[amount];

    }

    public int coinChange_practice(int[] coins, int amount) {

        int cal = amount;
        int result[] = new int[coins.length];
        for(int coin : coins) {
            System.out.println("coin: " + coin);
            cal = amount-coin;
            System.out.println("cal(result): " + cal);
            if(cal==0) break;
            else {
            }
        }

        return cal;

    }

}

package me.helpeachother.algorithm.kakao;

public class 다트게임 {

    /**
     *  S: 1제곱 / D: 2제곱 / T: 3제곱
     *
     *  * 스타상 2배 (연속시, 중첩가능) / # 아차상 -
     *
     *
     */




    public static void main(String[] args) {
//        String dartResult = "1S2D*3T";
//        String dartResult = "1D2S#10S";
//        String dartResult = "1D2S0T";
//        String dartResult = "1S*2T*3S";
//        String dartResult = "1D#2S*3S";
//        String dartResult = "1T2D3D#";
        String dartResult = "1D2S3T*";

        System.out.println(solve(dartResult));
    }

    static int solve(String dartResult){
        int[] score = new int[3];
        char[] result = dartResult.toCharArray();
        int cnt=-1;

        for(int i=0; i<result.length; i++) {
            if(result[i]=='S') {
                score[cnt] = (int)Math.pow(score[cnt],1);
            } else if (result[i]=='D') {
                score[cnt] = (int)Math.pow(score[cnt],2);
            } else if (result[i]=='T') {
                score[cnt] = (int)Math.pow(score[cnt],3);
            } else if (result[i]=='*') {
                if(cnt > 0) {
                    score[cnt-1] *= 2;
                }
                score[cnt] *= 2;
            } else if (result[i]=='#') {
                score[cnt] *= -1;
            } else if(result[i]=='1' && result[i+1] =='0') {
                cnt++;
                score[cnt] = 10;
                i++;
            } else {
                cnt++;
                score[cnt] = result[i] - '0';
            }
        }
//
//        System.out.println(score[0]);
//        System.out.println(score[1]);
//        System.out.println(score[2]);

        return score[0] + score[1] + score[2];
    }


}

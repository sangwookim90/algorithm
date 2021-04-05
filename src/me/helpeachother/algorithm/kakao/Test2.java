package me.helpeachother.algorithm.kakao;

public class Test2 {

    public static void main(String[] args) {

        long a = 9;

        System.out.println(minOper(a));






    }

    static long minOper(long n) {

         char[] a = Long.toBinaryString(n).toCharArray();

         int result = 0;
         int count = 0;

         for(int i=1; i<a.length; i++) {
             if(a[i]=='0') {
                 System.out.println("!!! i: " + i);
                for(int j=a.length-1; j>i; j--) {

                    if(a[j]=='0') {
                        // 다시 0으로 돌아갈 것이기 때문에 카운트만 2번
                        System.out.println("!!! j: " +j);
                        count+=2;
                    } else {
                        // 1인 경우
                        System.out.println("!!!!! j: " +j);
                        count++;
                        a[j]='0';
                    }
                }

                a[i]='1';
                count++;
             }
             if(i==a.length-1)
             a[i-1] = '0';
             count++;
             System.out.println("i: " + i + " count: " + count);
             System.out.println("---------");

         }




         return count;

    }

    static void print(char[] a){
        for(char c : a) System.out.print(c);
        System.out.println();

    }

}

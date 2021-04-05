package me.helpeachother.algorithm.kakao;

public class 비밀지도 {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};


        String[] result = solve(arr1, arr2, n);
        System.out.print("{");
        for(int i=0; i<n; i++) {
            if(i!=0) System.out.print(", ");
            System.out.print(result[i]);
        }
        System.out.print("}");

    }


    static String[] solve(int[] arr1, int[] arr2, int n) {

        String[] result = new String[n];

        for(int i=0; i<n; i++) {
            String m = Integer.toBinaryString(arr1[i] | arr2[i])
                    .replace('1','#')
                    .replace('0',' ');
//            m = m.replace('1','#');
//            m = m.replace('0',' ');
            result[i] = m;
        }

        return result;

    }


}

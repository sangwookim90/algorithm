package me.helpeachother.algorithm.string;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String str = "8F3Z-2e-9-wabcdefadfadsf12dvcz";
        int k=2;

        System.out.println(solve(str, k));
    }

    /**
     *
     * 1) 하이픈제거, 대문자
     * 2) 끝에서 4자리 끊기
     *
     */


    public static String solve_prac(String str, int k){

        String result = "";
        str=str.toUpperCase();
        str=str.replace("-","");

        int start = str.length()%k;

        result=result.concat(str.substring(0,start));
        for(int i=0; i<str.length()/k; i++) {
            if(result!="") result=result.concat("-");
            result=result.concat(str.substring(start+k*i, start+k*(i+1)));
        }
        return result;
    }

    public static String solve(String str, int k) {
        String newStr = str.replace("-","");
        newStr = newStr.toUpperCase();
        
        int leng = newStr.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i=-0; i<leng; i++) {
            sb.append(newStr.charAt(i));
        }

        for(int i=k; i<leng; i=i+k) {
            sb.insert(leng-i, "-");
        }

        System.out.println("sb: " + sb);

        return sb.toString();
    }

}

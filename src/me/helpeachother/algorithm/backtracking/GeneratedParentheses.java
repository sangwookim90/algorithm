package me.helpeachother.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratedParentheses {

    public static void main(String[] args) {

        GeneratedParentheses generatedParentheses = new GeneratedParentheses();
        System.out.println(generatedParentheses.generateParenthesis_dfs(3));
    }

    public List<String> generateParenthesis_dfs(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n, "");

        return result;


    }

    private void dfs(List<String> result, String str, int left, int right, String str1) {
        if(left<0 || left>right) return;

        if(left==0 && right==0) {
            result.add(str);
            return;
        }

        dfs(result, str+'(', left-1, right, str1+"+");
        dfs(result, str+')', left, right-1, str1+"-");

    }

}

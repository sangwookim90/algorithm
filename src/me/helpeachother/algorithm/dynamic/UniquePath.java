package me.helpeachother.algorithm.dynamic;

public class UniquePath {

    public static void main(String[] args) {
        int m=7, n=3;
        UniquePath a = new UniquePath();
        System.out.println(a.uniquePaths(m,n));
    }

    public int uniquePaths(int m, int n){

        Integer[][] map = new Integer[m][n];

        for(int i=0; i<m; i++) {
            map[i][0] = 1;
        }
        for(int j=0; j<n; j++) {
            map[0][j] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        return map[m-1][n-1];
    }

}

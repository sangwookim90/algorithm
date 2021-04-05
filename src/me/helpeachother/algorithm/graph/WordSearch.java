package me.helpeachother.algorithm.graph;

public class WordSearch {

    public static void main(String[] args) {

        char[][] grid = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";

        WordSearch a = new WordSearch();
        System.out.println(a.solve(grid, word));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n;
    public boolean solve(char[][] grid, String word){
        if(grid==null || grid.length==0 || grid[0].length==0) return false;

        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int start, String word) {

        if(start==word.length()) return true;
        if(i<0||i>=m||j<0||j>=n) return false;
        if(visited[i][j]) return false;
        if(grid[i][j]!=word.charAt(start)) return false;

        // grid[i][j] = word.charAt(0)

        visited[i][j] = true;
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if (dfs(grid, visited, x, y, start+1, word)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;


    }



}

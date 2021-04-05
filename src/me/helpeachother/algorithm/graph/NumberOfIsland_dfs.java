package me.helpeachother.algorithm.graph;

public class NumberOfIsland_dfs {

    // dfs : 깊이우선탐색

    /**
     *  (0,0)이 1이면 들어간다.
     *
     */

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };
        
        NumberOfIsland_dfs a = new NumberOfIsland_dfs();
        System.out.println(a.solve(grid));
            
    }

    public int solve(char[][] grid) {
        print(grid);

        // 1. error managing
        if(grid == null || grid.length == 0 || grid[0].length ==0) return 0;

        // 2. 1인 것부터 찾는다.
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        print(grid);
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        System.out.println(i + " " + j);


        // 범위 내에서 '1' 이 아니면 패스
        if(i<0 || i>=m  || j<0 || j>=n || grid[i][j]!='1') return;
        // 1이면 X 표시
        grid[i][j]='X';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }

    
    public void print(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
//                System.out.print(" grid["+i+"]["+j+"]" + grid[i][j]);
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}

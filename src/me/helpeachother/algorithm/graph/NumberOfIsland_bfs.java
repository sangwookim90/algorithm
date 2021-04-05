package me.helpeachother.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_bfs {

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

        NumberOfIsland_bfs a = new NumberOfIsland_bfs();
        System.out.println(a.solve(grid));

    }

    public int solve(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public void bfs(char[][] grid, int x, int y) {
        System.out.println("bfs start, x: " + x + " y: "+y);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("queue size: " + size + " x: " + x + " y: " + y);
            int[] point = queue.poll();
            System.out.println("queue size after poll: " + queue.size());
            System.out.println("point: " + point[0] +"," + point[1]);
            for(int i=0; i<size; i++) {
                for(int[] dir: dirs) {
                    int x1 = point[0]+dir[0];
                    int y1 = point[1]+dir[1];
                    if(x1>=0 && y1>=0 && x1<grid.length && y1<grid[0].length && grid[x1][y1]=='1') {
                        System.out.println("x1: " + x1 + " y1: " + y1);
                        grid[x1][y1]='0';
                        queue.offer(new int[] {x1,y1});
                    }
                    System.out.println(x + " " + y);
                    print(grid);
                }
            }
        }

    }

    
    public void print(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
//                System.out.print(" grid["+i+"]["+j+"]" + grid[i][j]);
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("===================================");
    }
}

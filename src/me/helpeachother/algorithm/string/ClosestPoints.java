package me.helpeachother.algorithm.string;

import java.util.*;

public class ClosestPoints {

    public static void main(String[] args) {

        int[][] points = { {1,3}, {-2,2}};
        int k = 1;

        ClosestPoints closestPoints = new ClosestPoints();
        int[][] result = closestPoints.kClosest(points, k);
        
        for(int i=0; i<result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if(i!=0 || j!=0) System.out.print(", ");
                System.out.print(result[i][j]);
            }
        }

    }

    public static int[][] kClosest(int[][] points, int k) {

        // 거리 계산식으로 정렬
        Queue<int[]> pq = new PriorityQueue<>(
                (a,b)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1])
        );

        int[][] result = new int[k][2];
        

        List<Double> distances = new ArrayList<>();
        for(int i=0; i<points.length; i++) {
            pq.offer(points[i]);
        }

        int index = 0;
        while(index < k) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }



}

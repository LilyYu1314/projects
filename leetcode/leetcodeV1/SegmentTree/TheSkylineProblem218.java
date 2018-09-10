package SegmentTree;

import org.junit.Test;

import java.util.*;


//https://briangordon.github.io/2014/08/the-skyline-problem.html
public class TheSkylineProblem218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        for(int i =0 ;i<height.size();i++){
            for(int j =0; j<height.get(i).length;j++){
                int[] temp = height.get(i);
                System.out.print(temp[j]+"   ");
            }
            System.out.println();
        }

        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        System.out.println("排序后");
        for(int i =0 ;i<height.size();i++){
            for(int j =0; j<height.get(i).length;j++){
                int[] temp = height.get(i);
                System.out.print(temp[j]+"   ");
            }
            System.out.println();
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;

        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }

        return result;
    }

    @Test
    public void testTheSkylineProblem218() {
        //System.out.println("Hello World!");
        int[][] buildings = {{2, 9, 10}, {3 ,7 ,15}, {5 ,12 ,12}, {15, 20 ,10}, {19 ,24, 8}};
        List<int[]> result= this.getSkyline(buildings);
        System.out.println("result: "+ result);
    }
}

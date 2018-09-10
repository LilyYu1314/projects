package Heap;

import org.junit.Test;

import java.util.*;

public class TheSkylineProblem218 {

    public List<int[]> getSkyline(int[][] buildings) {
        Map<Integer, List<int[]>> cps = new TreeMap<>(); // ordered by the critical points
        for (int[] b : buildings) {
            cps.putIfAbsent(b[0], new LinkedList<>());
            cps.putIfAbsent(b[1], new LinkedList<>());
            cps.get(b[0]).add(b);
            cps.get(b[1]).add(b);
            //System.out.println("b[0]: "+b[0]); System.out.println("cps.get(b[0]): "+cps.get(b[0]));
            //System.out.println();
            //System.out.println("b[1]: "+b[1]); System.out.println("cps.get(b[1]): "+cps.get(b[1]));
        }

        // heap for the currently active buildings
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] b1, int[] b2) {
                return Integer.compare(b2[2], b1[2]);
            }
        });

        List<int[]> res = new ArrayList<>();
        // iterate from left to right over the critical points
        for (Map.Entry<Integer, List<int[]>> entry : cps.entrySet()) {
            int c = entry.getKey();
            List<int[]> bs = entry.getValue();

            for (int[] b : bs) {
                if (c == b[0]) { // this critical point is a left edge of building `b`
                    heap.add(b);
                } else { // right edge
                    heap.remove(b);
                }
            }

            if (heap.isEmpty()) {
                // the heap is empty, so the skyline is 0
                res.add(new int[]{c, 0});
            } else {
                int h = heap.peek()[2];
                if (res.isEmpty() || res.get(res.size() - 1)[1] != h) {
                    // only add the highest rectangle if it different than before
                    res.add(new int[]{c, h});
                }
            }
        }

        return res;
    }


    @Test
    public void testTheSkylineProblem218() {
        //System.out.println("Hello World!");
        int[][] buildings = {{2, 9, 10}, {3 ,7 ,15}, {5 ,12 ,12}, {15, 20 ,10}, {19 ,24, 8}};
        List<int[]> result= this.getSkyline(buildings);
        System.out.println("result: "+ result);
    }
}
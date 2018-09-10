package Greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        Interval firstInterval = new Interval(0, 30);
        Interval secondInterval = new Interval(5, 10);
        Interval thirdInterval = new Interval(15, 20);
        Interval[] intervals ={firstInterval,secondInterval,thirdInterval};

        /*Interval firstInterval2 = new Interval(7, 10);
        Interval secondInterval2 = new Interval(2, 4);
        Interval[] intervals2 ={firstInterval2,secondInterval2};*/

        int result = this.minMeetingRooms(intervals);
        System.out.println("result: "+result);
    }
}

package StringSummary.HashMapSummary;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals_56 {
    //Approach 2: Sorting

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            //return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();

        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    //Complexity Analysis
    //Time complexity : O(nlgn)O(nlgn)
    //
    //Other than the sort invocation, we do a simple linear scan of the list,
    // so the runtime is dominated by the O(nlgn)O(nlgn) complexity of sorting.
    //
    //Space complexity : O(1)O(1) (or O(n)O(n))
    //
    //If we can sort intervals in place, we do not need more than constant additional space.
    //Otherwise, we must allocate linear space to store a copy of intervals and sort that.
}


    //And you don't have to write a nested Comparator class, an anonymous class will work

   /* Collections.sort(intervals, new Comparator(){
    @Override
    public int compare(Interval a, Interval b) {
    return a.start - b.start;
    }
    });*/
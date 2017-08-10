/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for(Interval in : intervals)
            System.out.print(in.start + " ");
        int count = 0;
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i + 1].start){
                count++;
                if(intervals[i].end > intervals[i + 1].end) {
                    intervals[i].start = Integer.MIN_VALUE;
                    continue;
                }
                intervals[i + 1].start = intervals[i].start;
                intervals[i + 1].end = intervals[i].end;
                intervals[i].start = Integer.MIN_VALUE;
            }
        }
        return count;
    }
}
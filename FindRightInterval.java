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
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0; i < intervals.length; i++)
            map.put(intervals[i].start, i);
        int[] rs = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            Map.Entry<Integer, Integer> pair = map.ceilingEntry(intervals[i].end);
            rs[i] = pair == null ? -1 : pair.getValue();
        }
        return rs;
    }
}
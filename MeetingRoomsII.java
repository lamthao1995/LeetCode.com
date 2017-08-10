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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        minHeap.offer(intervals[0].end);
        int count  = 1;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < minHeap.peek()){
                count++;
            }else{
                minHeap.poll();
            }
            minHeap.offer(intervals[i].end);
        }
        return count;
    }
}
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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0) return intervals;
        ArrayList<Interval> rs = new ArrayList<>();
        quickSort(0, intervals.size() - 1, intervals);
        int i = 0; int j = 0;
        
        while(i < intervals.size() - 1){
            j = i + 1;
            if(intervals.get(i).end >= intervals.get(j).start && intervals.get(i).start <= intervals.get(j).start){
                intervals.get(j).start = Math.min(intervals.get(i).start, intervals.get(j).start);
                intervals.get(j).end = Math.max(intervals.get(i).end, intervals.get(j).end);
                intervals.get(i).start = Integer.MAX_VALUE;
            }
            i++;
        }
        for( i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start != Integer.MAX_VALUE){
                rs.add(intervals.get(i));
            }
        }
        return rs;
    }
    public void quickSort(int L, int H, List<Interval> intervals){
        int mid = intervals.get((L + H)/2).start;
        int i = L;
        int j = H;
        do{
             while(intervals.get(i).start < mid) i++;
             while(intervals.get(j).start > mid) j--;
             if(i <= j){
                 Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
                 intervals.get(i).start = intervals.get(j).start; intervals.get(i).end = intervals.get(j).end;
                 intervals.get(j).start = temp.start; intervals.get(j).end = temp.end;
                 j--;
                 i++;
             }
        }while(i < j);
        if(L < j) quickSort(L, j, intervals);
        if(i < H) quickSort(i, H, intervals);
    }
    
}
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
    final int MARK = 2000000;
    List<Interval> rs = new ArrayList<>();
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        if(size == 0) {
            rs.add(newInterval);
            return rs;
        }
        intervals.add(newInterval);
        quickSort(0, size, intervals);
        int i = 0;
        while(i <= size - 1){
            int j = i + 1;
            //System.out.println(j);
            if(intervals.get(i).start <= intervals.get(j).end){
                if(intervals.get(i).end >= intervals.get(j).start){
                    intervals.get(j).start = intervals.get(i).start;
                    intervals.get(j).end = Math.max(intervals.get(j).end, intervals.get(i).end);
                    intervals.get(i).start = MARK;
                } 
            }
            i++;
        }
    
        for(Interval x : intervals){
            if(x.start != MARK){
                rs.add(x);
            }
        }
        quickSort(0, rs.size() - 1, rs);
        return rs;
    }
    public void quickSort(int L, int H, List<Interval> intervals){
        int i = L; int j = H;
        int mid = intervals.get((L + H) / 2).start;
        do{
            while(intervals.get(i).start < mid) i++;
            while(intervals.get(j).start > mid) j--;
            if(i <= j){
                Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
                //
                intervals.get(i).start = intervals.get(j).start;
                intervals.get(i).end = intervals.get(j).end;
                //
                intervals.get(j).start = temp.start;
                intervals.get(j).end = temp.end;
                i++;
                j--;
            }
        }while(i <= j);
        if(L < j) quickSort(L, j, intervals);
        if(i < H) quickSort(i, H, intervals);
    }
    
}
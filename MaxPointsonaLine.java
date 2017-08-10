/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> map = new HashMap();
            int samePoint = 0;
            for(int j = 0; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                    samePoint++;
                else{
                    double slope = Double.MAX_VALUE;
                    Point p1 = points[i], p2 = points[j];
                    if(points[i].x != points[j].x)
                        slope = (double)(p1.x - p2.x)/(double)(p1.y - p2.y);
                    int count = map.getOrDefault(slope,0);
                    map.put(slope,count+1);
                }
               
            }
            result = Math.max(result, samePoint);
           // System.out.println("So key: " + map.size());
             for(Integer count : map.values()){
                result = Math.max(result, count + samePoint);
             }
        }
        return result;
    }
}
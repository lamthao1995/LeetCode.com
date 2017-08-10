public class Solution {
    public List<Point> outerTrees(Point[] points) {
        int len = points.length;
        Set<Point> hull = new HashSet();
        int l = 0;
        for(int i = 1; i < len; i++){
            if(points[i].x < points[l].x)
                l = i;
        }
        hull.add(points[l]);
           
        Point cur = points[l];
        int curIndex = l;
        do{
            Point next = points[0];
            int next_index = 0;
            for(int i = 0; i < len; i++){
                if(curIndex == i) continue;
                int cross = orientation(cur, points[i], next);
                if(next_index == curIndex || 
                   cross == 2 || 
                   (cross == 0  &&  distance(points[i], cur) > distance(next, cur))){
                    next = points[i];
                    next_index = i;
                }
            }
            for (int i = 0; i < len; i++) {
                if (i == curIndex) continue;
                int cross = orientation(cur, points[i], next);
                if (cross == 0) {
                    hull.add(points[i]);
                }
            }
            cur = next;
            curIndex = next_index;
            
        }while(curIndex != l);
        
        return new ArrayList<>(hull);
    }
    public double distance(Point p1, Point p2){
        return (double) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
    public int orientation(Point p, Point q, Point r){
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if(val == 0) return 0;
        else return (val > 0) ? 1 : 2;//2a + b = 4
    }//4a + b = 2
}
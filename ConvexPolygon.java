public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        boolean gotPos = false, gotNe = false;
        for(int i = 0; i < points.size(); i++){
            List<Integer> A = points.get(i);
            List<Integer> B = points.get((i + 1) % points.size());
            List<Integer> C = points.get((i + 2) % points.size());
            int cross = getCrossProduct(A, B, C);
            if(cross > 0){
                gotPos = true;
            }else if(cross < 0){
                gotNe = true;
            }
            if(gotPos && gotNe)
                return false;
        }
        return true;
    }
    public int getCrossProduct(List<Integer> x, List<Integer> o, List<Integer> y){
        int cross = (o.get(0) - x.get(0)) * (o.get(1) - y.get(1))
                    - (o.get(1) - x.get(1)) * (o.get(0) - y.get(0));
        return cross;
    }
}
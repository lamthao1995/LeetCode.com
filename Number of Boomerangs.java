public class Solution {
    int total = 0;
    public int numberOfBoomerangs(int[][] points) {
         Map<Integer, Set<int[]>> map = new HashMap();
        for(int i = 0; i < points.length; i++){
            int[] p = points[i];
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                int[] q = points[j];
                int dis = getDis(p, q);
                if(!map.containsKey(dis)) map.put(dis, new HashSet<int[]>());
                map.get(dis).add(q);
            }
            for(int key : map.keySet()){
                Set<int[]> set = map.get(key);
                int size = set.size();
                if(size >= 2)
                    total += size * (size - 1);
            }
            map.clear();
        }
        return total;
    }
    public static int getDis(int[] p, int[] q){
        int a = p[0] - q[0];
        int b = p[1] - q[1];
        return a * a + b * b;
    }
}
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> rs = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        //dis, index
        for(int i = 0; i < arr.size(); i++){
            int dis_ = Math.abs(arr.get(i) - x);
            if(!map.containsKey(dis_)){
                map.put(dis_, new ArrayList<>());
            }
            map.get(dis_).add(i);
        }
        for(int distance : map.keySet()){
            if(k == 0) break;
            List<Integer> tmp = map.get(distance);
            for(int i = 0; i < tmp.size(); i++){
                if(k == 0) break;
                rs.add(arr.get(tmp.get(i)));
                k--;
            }
        }
        Collections.sort(rs);
        return rs;
    }
}
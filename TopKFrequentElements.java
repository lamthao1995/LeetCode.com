public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(int key : map.keySet()){
            int frequence = map.get(key);
            if(bucket[frequence] == null){
                bucket[frequence] = new ArrayList<>();
            }
            bucket[frequence].add(key);
        }
        List<Integer> rs = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && rs.size() < k; i--){
            if(bucket[i] != null ) rs.addAll(bucket[i]);
        }
        return rs;
    }
}
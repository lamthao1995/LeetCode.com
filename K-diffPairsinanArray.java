public class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map = new HashMap();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        for(int x : map.keySet()){
            if(k != 0){
                if(map.containsKey(x + k)){
                    count += 1;
                }
            }else{
                if(map.get(x) >= 2)
                    count += 1;
            }
            
        }
        return count;
    }
}
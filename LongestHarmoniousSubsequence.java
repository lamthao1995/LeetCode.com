public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key + 1)){
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }
 
}
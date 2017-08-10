public class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int majorityElement(int[] nums) {
        int len = nums.length;
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x) > len / 2) return x;
        }
        return -1;
    }
}
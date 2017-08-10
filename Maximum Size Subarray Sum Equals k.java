public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                int len = i - map.get(sum - k);
                max = Math.max(len, max);
            }
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}
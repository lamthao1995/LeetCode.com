public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        for(int i = 1; i < nums.length; i++){
                if(nums[i] == 0 && nums[i - 1] == 0) return true;
        }
        if(k == 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        map.put(sum, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum = sum % k;
            if(map.containsKey(sum)){
                if(i - map.get(sum) >= 2) return true;
            }else{
                map.put(sum, i);
            }
        }
        return false;
    }
}
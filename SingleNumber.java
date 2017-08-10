public class Solution {
    public int singleNumber(int[] nums) {
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            start = start ^ nums[i];
        }
        return start;
        
    }
}
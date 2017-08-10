public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int id = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[i - 1]) nums[id++] = nums[i];
        }
        return id;
    }
}
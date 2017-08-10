public class Solution {
    public void moveZeroes(int[] nums) {
       for(int first = 0, cur = 0; cur < nums.length; cur++){
           if(nums[cur] != 0){
               swap(first++, cur, nums);
           }
       }
    }
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
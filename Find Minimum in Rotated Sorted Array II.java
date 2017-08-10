public class Solution {
    public int findMin(int[] nums) {
        return binary(0, nums.length - 1, nums);
    }
    public int binary(int left, int right, int[] nums){
        if(left == right)
            return nums[left];
        if(right == left + 1)
            return Math.min(nums[right], nums[left]);
        int mid = left + (right - left) / 2;
        if(nums[right] > nums[left]){
            return nums[left];
        }else if(nums[right] == nums[left]){
            return binary(left + 1, right, nums);
        }else if(nums[mid] >= nums[left]){
            return binary(mid, right, nums);
        }else{
            return binary(left, mid, nums);
        }
    }
}
public class Solution {
    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int rs = 0;
        for(int i = 0; i < len; i = i + 2){
            rs += nums[i];
        }
        return rs;
    }
}
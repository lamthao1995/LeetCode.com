public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = target + 10000000;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                int sum = nums[i] + nums[end] + nums[start];
                if(sum < target){
                    start++;
                }else{
                    end--;
                }
                if(Math.abs(target - sum) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}
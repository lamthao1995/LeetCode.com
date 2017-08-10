public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int total = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    total += end - start;
                    start++;
                }else{
                    end--;
                }
            }
        }
        return total;
    }
}
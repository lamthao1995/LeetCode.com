public class Solution {
    boolean check = false;
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4)
            return false;
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        int[] sums = {0, 0, 0, 0};
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 4 != 0){
            return false;
        }
        int target = sum / 4;
        search(sums, nums, target, 0);
        return check;
    }
    private void search(int[] sum, int[] nums, int target, int index){
        if(sum[0] == target && sum[1] == target && sum[2] == target){
            check = true;
        }
        if(check == true)
            return;
        if(index == nums.length)
            return;
        for(int i = 0; i < 4; i++){
            if(sum[i] + nums[index] > target) continue;
            sum[i] += nums[index];
            search(sum, nums, target, index + 1);
            sum[i] -= nums[index];
        }
       
    }
}
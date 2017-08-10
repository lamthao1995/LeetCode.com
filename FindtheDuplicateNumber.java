public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            nums[i]--;
        }
        int slow = nums[len - 1], fast = nums[nums[len - 1]];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = len - 1;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow + 1;
    }
}
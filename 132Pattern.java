public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        Stack<Integer> stack = new Stack();
        for(int j = nums.length - 1; j >= 0; j--){
            if(nums[j] > min[j]){
                while(!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if(!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
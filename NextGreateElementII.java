public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] rs = new int[len];
        Stack<Integer> stack = new Stack();
        for(int i = 2 * len - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % len]){
                stack.pop();
            }
            rs[i % len] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }
        return rs;
    }
}
// public class Solution {

//     public int[] nextGreaterElements(int[] nums) {
//         int[] res = new int[nums.length];
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 2 * nums.length - 1; i >= 0; --i) {
//             while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
//                 stack.pop();
//             }
//             res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
//             stack.push(i % nums.length);
//         }
//         return res;
//     }
// }
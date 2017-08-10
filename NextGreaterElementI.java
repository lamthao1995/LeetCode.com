public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        int[] rs = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++)
            map.put(findNums[i], i);
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            } 
            if(map.containsKey(nums[i])){
                rs[map.get(nums[i])] = stack.empty() ? -1 : nums[stack.peek()];
            }
            stack.push(i);
        }
        return rs;
    }
}
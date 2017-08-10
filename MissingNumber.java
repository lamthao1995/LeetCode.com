public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] trace = new int[2 * n + 1];
        for(int i = 0; i <= n; i++){
            trace[i] = i;
        }
        int count = 0;
        for(int i = n + 1; i < trace.length; i++){
            trace[i] = nums[count++];
        }
        int start = trace[0];
        for(int i = 1; i < trace.length; i++){
            start = start ^ trace[i];
        }
        return start;
    }
}
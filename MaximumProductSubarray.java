public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0)
            return 0;
        int maxPre = nums[0];
        int minPre = nums[0];
        int maxSoFar = nums[0];
        int maxhere, minhere;
        for(int i = 1; i < len; i++){
            maxhere = max(maxPre * nums[i], minPre * nums[i], nums[i]);
            minhere = min(maxPre * nums[i], minPre * nums[i], nums[i]);
            maxSoFar = Math.max(maxhere, maxSoFar);
            maxPre = maxhere;
            minPre = minhere;
        }
        return maxSoFar;
    }
    public int max(int a, int b, int c){
        if(a < b)
            a = b;
        if(a < c)
            a = c;
        return a;
    }
    public int min(int a, int b, int c){
        if(a > b)
            a = b;
        if(a > c)
            a = c;
        return a;
    }
}
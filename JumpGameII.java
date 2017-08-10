public class Solution {
 
    public int jump(int[] nums) {
     int curEnd = 0, jump = 0, max = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = max(max, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = max;
            }
        }
        return jump;
    }
    public int max(int a, int b){
        return a > b ? a : b;
    }
 
}
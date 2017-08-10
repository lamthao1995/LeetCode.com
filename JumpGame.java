public class Solution {
    
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > reachable) return false;
            reachable = max(reachable, i + nums[i]);
        }
        return true;
    }
    public int max(int x, int y){
        return x > y ? x : y;
    }
   
}
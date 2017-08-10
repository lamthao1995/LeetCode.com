public class Solution {
    
    public int[] productExceptSelf(int[] nums) {
    	int common = 1;
         int numOf0 = 0;
        for(int x : nums){
            if(x == 0) numOf0++;
            else common = common * x;
        }
        if(numOf0 >= 2){
            for(int i = 0; i < nums.length; i++){
                nums[i] = 0;
            }
        }else if(numOf0 == 1){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    nums[i] = common;
                }else{
                    nums[i] = 0;
                }
            }
        }else{
             for(int i = 0; i < nums.length; i++){
                    nums[i] = common / nums[i];
                }
            
        }
        return nums;
    }
}
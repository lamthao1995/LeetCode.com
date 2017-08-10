public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int x : nums){
            xor ^= x;
        }
        int last = xor & (~(xor - 1));
        int num1 = 0, num2 = 0;
        for(int x : nums){
            if((last & x) == 0){
                num1 ^= x;
            }else{
                num2 ^= x;
            }
        }
        return new int[]{num1, num2};
    }
   
    
}
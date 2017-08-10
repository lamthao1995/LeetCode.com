public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, leftZeros = 0, rightZeros = 0;
        for(int i = 0; i < nums.length; i++){
            rightZeros++;
            if(nums[i] == 0){
                leftZeros = rightZeros;
                rightZeros = 0;
            }
            max = Math.max(max, rightZeros + leftZeros);
        }
        return max;
    }
}
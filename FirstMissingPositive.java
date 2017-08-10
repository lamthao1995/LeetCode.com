public class Solution {
    public int firstMissingPositive(int[] nums) {
     
       int n = nums.length;
         if(n == 0) return 1;
        for(int i = 0; i < n; i++)
        {
            //swap
            while(true){
                if(nums[i] <= 0 || nums[i] >n ){
                    break;
                }
               // System.out.println("N = " + n);
                // handle with duplicate
                if(nums[i] == nums[nums[i] - 1]){
                    break;
                }
                   // System.out.println("nums = " + nums[i]);
                   int temp = nums[i];
                   nums[i] = nums[temp - 1];
                   nums[temp - 1] = temp;
                
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
       // System.out.println("Arrrays: " + Arrays.toString(nums));
        return n + 1;
    }
}
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] test = nums;
        int length = nums.length;
        int result = 0;
        int[] temp = new int[length];
        for(int i = 0; i < length; i++){
            temp[i] = test[i];
        }
        Arrays.sort(temp);
        int start = 0, end = 0;
        for(int i = 0; i < length; i++){
           if(temp[i] != test[i]){
               start = i;
               break;
           }
        }
        for(int i = length - 1; i >= 0; i--){
            if(temp[i] != test[i]){
                end = i;
                break;
            }
        }
        if(end != start){
             result = end - start + 1;     
        }
       
        return result;
    }
}
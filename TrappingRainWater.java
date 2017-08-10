public class Solution {
    public int trap(int[] height) {
        
        int count = 0;
       int left = 0; int right = height.length - 1;
       int maxLeft = 0; int maxRight = 0;
       while(left <= right){
           if(height[left] < height[right]){
               if(maxLeft <= height[left]){
                   maxLeft = height[left];
               }else{
                   count = count + maxLeft - height[left];
               }
               left++;
           }else{
               if(maxRight <= height[right]){
                   maxRight = height[right];
               }else{
                   count = count + maxRight - height[right];
               }
               right--;
           }
       }
        return count;
    }
}
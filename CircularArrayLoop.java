public class Solution {
    public boolean circularArrayLoop(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) == nums.length || nums[i] == 0) continue;
            if(nums[i] < 0){
                if(moveBack(nums, i))
                    return true;
            }else{
                if(moveForward(nums, i))
                    return true;
            }
        }
        return false;
    }
    public boolean moveBack(int nums[], int index){
        if(nums[index] == -1)
            return false;
        boolean isCircle = false;
        int len = nums.length;
        int start = index;
        while(!isCircle || start <= index){
            if(nums[start] >= 0 || -nums[start] > len)
                return false;
           int old = start;
            start = (start >= -nums[start]) ? start + nums[start] : (len - (-nums[start] - start));
             nums[old] = 0;
            if(start == index){
                return true;
            }else if(start > index){
                isCircle = true;
            }
        }
        return false;
    }
    public boolean moveForward(int nums[], int index){
        boolean isCircle = false;
        int len = nums.length;
        int start = index;
        while(!isCircle || start >= index){
            if(nums[start] <= 0 || nums[start] > len)
                return false;
            int old = start;
            start = (start + nums[start]) % len;
            nums[old] = 0;
            if(start == index){
                return true;
            }else if(start < index){
                isCircle = true;
            }
        }
        return false;
    }
}
public class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (n + "").toCharArray();
        int i = nums.length - 2, j;
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i < 0)
            return -1;
        j = nums.length - 1;
        while(j >= 0 && nums[j] <= nums[i]){
            j--;
        }
        swap(i, j, nums);
        reverse(i + 1, nums.length - 1, nums);
        try{
            return Integer.parseInt(new String(nums));
        }catch(Exception e){
            return -1;
        }
        
    }
    public void swap(int x, int y, char[] nums){
        char tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
    public void reverse(int left, int right, char[] nums){
        while(left < right){
            char tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            right--;
            left++;
        }
    }
}

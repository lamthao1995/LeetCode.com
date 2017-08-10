public class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }
    public int binary(int[] num, int target, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(num[mid] == target) return mid;
        if(num[start] <= num[mid]){
            if(num[mid] >= target && num[start] <= target){
                return binary(num, target, start, mid - 1);
            }else{
                return binary(num, target, mid + 1, end);
            }
        }else{
            if(num[mid] <= target && num[end] >= target){
                 return binary(num, target, mid + 1, end);
            }else{
                 return binary(num, target, start, mid - 1);
            }
        }
    }
}
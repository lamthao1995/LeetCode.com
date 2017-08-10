public class Solution {
    public boolean search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }
    public boolean binary(int[] num, int target, int start, int end){
        if(start > end) return false;
        int mid = (start + end) / 2;
        if(num[mid] == target) return true;
        if(num[start] < num[mid]){
            if(target <= num[mid] && target >= num[start]){
                return binary(num, target, start, mid - 1);
            }else{
                return binary(num, target, mid + 1, end);
            }
        }else if(num[start] > num[mid]){
            if(num[mid] < target && num[end] >= target){
                return binary(num, target, mid + 1, end);
            }else{
                return binary(num, target, start, mid - 1);
            }
        }else{
            //start++
            return binary(num, target, start + 1, end);
        }
    }
}
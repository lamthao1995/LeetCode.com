public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || k < 0 || nums.length == 0){
            throw new IllegalArgumentException("Illegal arguments");
        }
        int len = nums.length;
        if(k == 0) return;
        k = k % len;
        int order = len - k;
        reserve(nums, 0, order - 1);
        reserve(nums, order, nums.length - 1);
        reserve(nums, 0, nums.length - 1);
    }
    public void reserve(int[] arr, int start, int end){
        int left = start, right = end;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }
    }
}
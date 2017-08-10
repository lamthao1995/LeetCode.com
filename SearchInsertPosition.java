public class Solution {
    public int searchInsert(int[] nums, int target) {
       return binary(0, nums.length - 1, target, nums);
    }
    public int binary(int L, int H, int target, int[] arr){
        int mid = (L + H) / 2;
        if(arr[mid] == target) return mid;
        if(L == H){
            if(arr[mid] < target) return mid + 1;
            else return mid;
        }
        if(L == mid){
            if(arr[mid] < target) {
                if(target > arr[H]) return H + 1;
                else return H;
            }
            else return mid;
        }
      
        if(arr[mid] < target){
            return binary(mid + 1, H, target, arr);
        }else{
            return binary(L, mid - 1, target, arr);
        }
    }
}
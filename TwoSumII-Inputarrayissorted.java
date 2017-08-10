public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            int index = search(numbers, 0, len - 1, target - numbers[i], i);
            if(index != -1){
                rs[0] = i + 1;
                rs[1] = index + 1;
                return rs;
            }
        }
        return rs;
    }
    public int search(int[] arr, int L, int H, int target, int old){
        if(L > H) return -1;
        int mid = (L + H) >> 1;
        if(arr[mid] == target){
            if(mid == old){
                if(mid > 0 && arr[mid - 1] == target) return mid - 1;
                if(mid <= H && arr[mid + 1] == target ) return mid + 1;
                return -1;
            }
            return mid;
        }
        else if(arr[mid] > target){
            return search(arr, L, mid - 1, target, old);
        }else{
            return search(arr, mid + 1, H, target, old);
        }
    }
}
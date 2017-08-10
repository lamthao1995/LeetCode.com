public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int start = 0;
        while(start < len){
            swap(arr, start, start + k - 1);
            start += 2 * k;
            
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int left, int right){
        if(right >= arr.length) 
            right = arr.length - 1;
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }
    }
}
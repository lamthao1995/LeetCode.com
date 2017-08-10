public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int end = s.length() - 1, start = 0;
        while(start < end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            end--;
            start++;
        }
        return new String(arr);
    }
}
public class Solution {
    public int[] plusOne(int[] digits) {
        int hold = 1;
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--){
            int num = digits[i];
            if(num + hold >= 10){
                digits[i] = (hold + num) % 10;
                hold = 1;
            }else{
                digits[i] = hold + num;
                hold = 0;
            }
        }
        if(hold == 0) return digits;
        else{
            int[] arr = new int[len + 1];
            arr[0] = hold;
            for(int i = 1; i <= len; i++){
                arr[i] = digits[i - 1];
            }
            return arr;
        }
    }
}
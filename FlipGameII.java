public class Solution {
    public boolean canWin(String s) {
        return helper(s.toCharArray());
    }
    public boolean helper(char[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == '+' && arr[i - 1] == '+'){
                arr[i] = '-';
                arr[i - 1] = '-';
                boolean win = helper(arr);
                arr[i] = '+';
                arr[i - 1] = '+';
                if(!win){
                    return true;
                }
            }
        }
        return false;
    }
}
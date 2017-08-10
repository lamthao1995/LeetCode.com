public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        String pattern = "00 11 88 696";
        while(left <= right){
            if(!pattern.contains(num.charAt(left++) + "" + num.charAt(right--)))
                return false;
        }
        return true;
    }
}
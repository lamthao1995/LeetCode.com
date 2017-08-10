public class Solution {
    public String shortestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(end >= 0){
            if(s.charAt(end) == s.charAt(start)){
                start++;
            }
            end--;
        }
        if(start == s.length())
            return s;
        String suffix = s.substring(start, s.length());
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, start));
        return prefix + mid + suffix;
    }
}//dcbaabcd
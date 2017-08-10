public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1, max = 0;
        for(int k = 1; k < s.length(); k++){
            if(s.charAt(k) == s.charAt(k - 1))
                continue;
            if(j >= 0 && s.charAt(j) != s.charAt(k)){
                max = Math.max(k - i, max);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, max);
    }
}
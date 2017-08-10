public class Solution {
    int[] low = new int[26];
    int[] up = new int[26];
    public int longestPalindrome(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 97) low[c - 'a']++;
            else up[c - 'A']++;
        }
        for(int i = 0; i < 26; i++){
            res += (low[i] / 2) * 2;
            res += (up[i] / 2) * 2;
        }
        return res == s.length() ? res : res + 1;
    }
}
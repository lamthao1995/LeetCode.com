public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int startIndex = -1, iIndex = -1;
        while(i < s.length()){
            if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
                i++;
                j++;
            }else if (j < p.length() && p.charAt(j) == '*'){
                startIndex = j++;
                iIndex = i;
            }else if (startIndex != -1){
                j = startIndex + 1;
                i = ++iIndex;
            }else{
                return false;
            }
        }
        while(j < p.length() && p.charAt(j) == '*')
            j++;
        return j == p.length();
    }
}
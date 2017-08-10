public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        int len = s.length();
        if(len == 0) return 0;
        int indexStart = len - 1;
        while(indexStart >= 0){
            if(s.charAt(indexStart) != ' ') break;
            indexStart--;
        }
        if(indexStart < 0) return 0;
        int end = indexStart;
        while(indexStart >= 0){
            if(s.charAt(indexStart) == ' ') break;
            indexStart--;
        }
        return end - indexStart;
        
    }
}
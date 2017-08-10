public class Solution {
    public int strStr(String haystack, String needle) {
            int hashP = needle.hashCode();
            int lenOfP = needle.length();
            for(int i = 0; i <= haystack.length() - lenOfP; i++){
                String temp = haystack.substring(i, i + lenOfP);
                if(temp.hashCode() == hashP){
                    if(temp.equals(needle)){
                        return i;
                    }
                }
            }
            return -1;
    }
    
}
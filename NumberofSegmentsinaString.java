public class Solution {
    public int countSegments(String s) {
        int len = s.length();
        int cur = 0, count = 0;
        while(cur < len){
            while(cur < len && s.charAt(cur) == ' ')
                cur++;
            if(cur < len)
                count++;
            while(cur < len && s.charAt(cur) != ' ')
                cur++;
        }
        return count;
    }
}
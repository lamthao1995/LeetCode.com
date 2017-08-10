public class Solution {
    public void reverseWords(char[] s) {
        int cur = 0, len = s.length;
        while(cur < len){
            if(s[cur] == ' '){
                cur++;
                continue;
            }
            int start = cur;
            while(start < len && s[start] != ' ')
                start++;
            if(start - 1 < len)
                reverse(cur, start - 1, s);
            cur = start;
        }
        reverse(0, len - 1, s);
    }
    public void reverse(int left, int right, char[] s){
        while(left < right){
            char tmp = s[left];
            s[left] =s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
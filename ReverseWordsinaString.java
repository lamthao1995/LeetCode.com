public class Solution {
    public String reverseWords(String s) {
        if(s.equals("")) return "";
        char c[] = s.toCharArray();
        int start = 0;
        int len = s.length();
        while(start < len){
            int end = start;
            while(end < len && char[e])
            while(end < len && c[end] != ' ') end++;
            reverse(c, start, end - 1);
            start = end + 1;
        }
        reverse(c, 0, len - 1);
        System.out.print(Arrays.toString(c));
        start = 0;
        while(start < len){
            int end = start;
            while(end < len && c[end] == ' ') end++;
            while(end < len && c[end] != ' '){
                str.append(c[end]);
                end++;
            }
            str.append(" ");
            start = end + 1;
        }
        return str.toString().trim();
        
    }
    public void reverse(char[] c, int start, int end){
        while(start < end){
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
    }
}
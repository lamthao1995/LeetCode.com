public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.equals("")) return "";
        String[] str = s.split(" ");
        String rs = "";
        for(String tmp : str){
            char[] c = tmp.toCharArray();
            int left = 0, right = tmp.length() - 1;
            while(left < right){
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            rs = rs + String.valueOf(c) + " ";
        }
        return rs.trim();
    }
}
public class Solution {
    public String convertToTitle(int n) {
        String result = "";
        while(n > 0){
           char c = (char) ((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            result = c + result;
        }
        return result;
    }
}
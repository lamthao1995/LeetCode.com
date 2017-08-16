public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLen = 0;
        for(int i = 0; i < p.length(); i++){
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))){
                maxLen++;
            }else{
                maxLen = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLen);
        }
        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += count[i];
        }
        return sum;
    }
}
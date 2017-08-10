public class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int index = (int)s.charAt(i) - 'A';
            maxCount = Math.max(maxCount, ++window[index]);
            while(i - start + 1 - maxCount > k){
                window[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
            
        }
        return maxLength;
    }
}
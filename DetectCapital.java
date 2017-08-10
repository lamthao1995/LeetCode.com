public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0)
            return false;
        int[] trace = new int[26];
        int lenOfW = word.length();
        for(int i = 0; i < lenOfW; i++){
            int index = (int)word.charAt(i) - 'a';
            if(index < 0 || index >= 26) continue;
            trace[index]++;
        }
        int total = 0;
        for(int i = 0; i < 26; i++)
            total += trace[i];
        if(total == lenOfW)
            return true;
        int firstE = word.charAt(0) - 'a';
        if(total == lenOfW - 1 && (firstE < 0 || firstE > 25))
            return true;
        if(total == 0)
            return true;
        return false;
    }
}
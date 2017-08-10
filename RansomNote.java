public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ran = new int[26];
        int[] maga = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            ran[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++)
            maga[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++){
            if(ran[i] > maga[i])
                return false;
        }
        return true;
    }
}
public class Solution {
    int[] trace = new int[26];
    public char findTheDifference(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            trace[toInt(s.charAt(i))]++;
        }
        for(int i = 0; i < t.length(); i++){
            trace[toInt(t.charAt(i))]--;
        }
        for(int i = 0; i < 26; i++){
            if(trace[i] != 0){
                return toChar(i); 
            }
        }
        return 'a';
    }
    public int toInt(char c){
        return (int)c - (int)'a';
    }
    public char toChar(int key){
        return (char) (key + (int)'a');
    }
}
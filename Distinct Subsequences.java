public class Solution {
    public int numDistinct(String s, String t) {
        int[][] mem = new int[1 + t.length()][1 + s.length()];
        for(int i = 0; i <= s.length(); i++){
            mem[0][i] = 1;
        }
        for(int i = 0; i < t.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(t.charAt(i) == s.charAt(j)){
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                }else{
                    mem[i+ 1][j + 1] = mem[i + 1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
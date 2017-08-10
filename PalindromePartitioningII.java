public class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int cut[] = new int[len];
        for(int j = 0; j < len; j++){
            cut[j] = j;
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if(i > 0){
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    }else{
                        cut[j] = 0;
                    }
                
                }
                
            }
        }
        return cut[len - 1];
    }
}
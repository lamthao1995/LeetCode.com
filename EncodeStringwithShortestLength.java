public class Solution {
    String[][] dp;
    public String encode(String s) {
        int len = s.length();
        dp = new String[len][len];
        for(int l = 0; l < len; l++){
            for(int i = 0; i < len - l; i++){
                int j = i + l;
                String sub = s.substring(i, j + 1);
                dp[i][j] = sub;
                if(j - i >= 4){
                    dp[i][j] = sub;
                    for(int k = i; k < j; k++){
                        if((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()){
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for(int k = 0; k < sub.length(); k++){
                        String repeat = sub.substring(0, k + 1);
                        if(repeat != null && sub.length() % repeat.length() == 0
                          && sub.replaceAll(repeat, "").length() == 0){
                            String ss = (sub.length() / repeat.length()) + "[" + dp[i][i + k]  + "]";
                            if(ss.length() < dp[i][j].length()){
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
                
            }
        }
        return dp[0][len - 1];
    }
}
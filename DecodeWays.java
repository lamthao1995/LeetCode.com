public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if(Integer.parseInt(s.substring(0, 2)) > 26){
            if(s.charAt(1) != '0'){
                dp[1] = 1;
            }else{
                dp[1] = 0; 
            }
        }else{
            if(s.charAt(1) != '0'){
                dp[1] = 2;
            }else{
                dp[1] = 1;
            }
        }
        for(int i = 2;i < len; i++){
            if(s.charAt(i) != '0'){
                 dp[i] += dp[i - 1];   
            }
            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            if(val <= 26 && val >= 10){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
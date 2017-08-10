public class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        
        return f[len];
        
    }
   
}
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1; i <= len/2; i++){
            if(len % i != 0) continue;
            if(check(s.substring(0, i), s)){
                return true;
            }
        }
        return false;
        
    }
    public boolean check(String pattern, String s){
        int hashP = pattern.hashCode();
        int lenP = pattern.length();
        for(int i = 0; i <= s.length() - lenP; i++){
            String tmp = s.substring(i, i + lenP);
            if(tmp.hashCode() == hashP){
                if(tmp.equals(pattern))
                    i += lenP - 1;
                else
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
    
}
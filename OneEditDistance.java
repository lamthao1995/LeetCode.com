public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int lenS = s.length();
        int lenT = t.length();
        if(Math.abs(lenS - lenT) > 1)
            return false;
        int indexS = 0, indexT = 0;
        int count = 0;
        while(indexS < lenS && indexT < lenT){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
                indexT++;
            }else{
                count++;
                if(count > 1)
                    return false;
                if(lenS > lenT){
                    indexS++;
                }else if(lenS < lenT){
                    indexT++;
                }else{
                    indexS++;
                    indexT++;
                }
            }
        }
        if(indexT < lenT || indexS < lenS)
            count++;
        return count == 1;
    }
}
public class Solution {
    public boolean checkRecord(String s) {
        int numOfLate = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                numOfLate++;
                if(numOfLate > 1) return false;
            }
            if(i >= 2 && s.charAt(i) == 'L' 
                        && s.charAt(i - 1) == 'L' 
                            && s.charAt(i - 2) == 'L')
                return false;
        }
        return true;
    }
}
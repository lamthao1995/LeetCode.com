public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> (b.length() - a.length()));
        int numberOfE = strs.length;
        int res = -1;
       for(int i = 0; i < numberOfE; i++){
           boolean flag = true;
           for(int j = 0; j < numberOfE; j++){
               if(i == j)
                   continue;
               if(isSubsequence(strs[i], strs[j])){
                   flag = false;
                   break;
               }
           }
           if(flag)
               return strs[i].length();
       }
        return res;
    }
    private boolean isSubsequence(String s1, String s2){
        int j = 0;
        for(int i = 0; i < s2.length() && j < s1.length(); i++){
            if(s2.charAt(i) == s1.charAt(j)){
                j++;
            }
        }
        return j == s1.length();
    }
}
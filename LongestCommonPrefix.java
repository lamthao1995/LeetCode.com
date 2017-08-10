public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String s = "";
        boolean stop = false;
        int i = 0;
        while(stop == false){
            //System.out.println("i = " + i);
            if(i >= strs[0].length()) break;
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                try{
                    if(c != strs[j].charAt(i)){
                    return s;
                    }
                } catch(Exception e){
                    stop = true;
                    break;
                }
            }
            if(stop == false) s = s + c;
            i++;
        }
        return s;
    }
}
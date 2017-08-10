public class Solution {
    public boolean isPalindrome(String s) {
       //cach khac
       int len = s.length();
       if(len == 1) return true;
       int i = 0, j = len - 1;
       while(i <= j){
           while(valid(i, s) == false) i++;
           while(valid(j, s) == false) j--;
           if(i <= j){
               if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
               i++;
               j--;
           }
       }
       return true;
    }
    public boolean valid(int index, String s){
        if(index >= s.length() || index < 0) return true;
        char c = Character.toLowerCase(s.charAt(index));
        if(Character.isLetter(c) || Character.isDigit(c)) return true;
        else return false;
    }
    public boolean check(String s){
         String refined = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)){
                refined = refined + c;
            }
        }
        int len = refined.length();
        //System.out.println(refined);
        for(int i = 0; i < refined.length() / 2; i++){
            if(refined.charAt(i) != refined.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }
}
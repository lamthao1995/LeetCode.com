public class Solution {
    public boolean isNumber(String s) {
        int cur = 0, len = s.length();
        if(len == 0) return false;
        while(cur < len && s.charAt(cur) == ' ') cur++;
        if(cur < len && 
          (s.charAt(cur) == '+' || s.charAt(cur) == '-'))
            cur++;
        boolean isNum = false;
        boolean expo = false;
        while(cur < len && Character.isDigit(s.charAt(cur))){
            cur++;
            expo = true;
            isNum = true;
        }
        if(cur < len && s.charAt(cur) == '.'){
            cur++;
            while(cur < len && Character.isDigit(s.charAt(cur))){
                cur++;
                isNum = true;
            }
        }
        if(cur < len && s.charAt(cur) == 'e'){
            if(cur > 0 && expo == false && s.charAt(cur - 1) == '.') return false;
            if(cur == 0) return false;
            char c = s.charAt(cur - 1);
            if(c != '.' && Character.isDigit(c) == false) return false;
            cur++;
            isNum = false;
            if(cur < len && 
              (s.charAt(cur) == '+' || s.charAt(cur) == '-'))
                cur++;
            while(cur < len && Character.isDigit(s.charAt(cur))){
                cur++;
                isNum = true;
            }  
        }
        while(cur < len && s.charAt(cur) == ' ') cur++;
        return (isNum && cur == len);
        
    }
}
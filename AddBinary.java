public class Solution {
    public String addBinary(String a, String b) {
    	int hold = 0;
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                b = "0" + b;
            }
        }else{
            for(int i = 0; i < lenB - lenA; i++){
                a = "0" + a;
            }
        }
        String rs = "";
        for(int i = a.length() - 1; i >= 0; i--){
            int cA = Integer.parseInt(a.charAt(i) + "");
            int cB = Integer.parseInt(b.charAt(i) + "");
            if(hold == 0){
                if(cA + cB == 1){
                    rs = "1" + rs;
                }else if(cA + cB == 2){
                    rs = "0" + rs;
                    hold = 1;
                }else{
                    rs = "0" + rs;
                }
            }else{
                if(cA + cB == 2){
                    rs = "1"+rs;
                    hold = 1;
                }else if(cA + cB == 1){
                    rs = "0" + rs;
                    hold = 1;
                }else{
                    rs = "1" + rs;
                    hold = 0;
                }
            }
        }
        if(hold == 1) rs = "1" + rs;
        return rs;
        
    }
    
}
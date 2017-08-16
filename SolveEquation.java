public class Solution {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        String leftP = strs[0], rightP = strs[1];
        int start = 0;
        int coffL = 0, valL = 0;
        int lenL = leftP.length();
        while(start < lenL){
            String num = "";
            int sign = 1;
            if(start < lenL && leftP.charAt(start) == '-'){
                sign = -1;
                start++;
            }else if(start < lenL && leftP.charAt(start) == '+'){
                start++;
            }
            while(start < lenL && Character.isDigit(leftP.charAt(start))){
                num = num + leftP.charAt(start);
                start++;
            }
            if(start < lenL && leftP.charAt(start) == 'x'){
                if(num.equals("")) 
                   num = "1";
                coffL += sign * Integer.parseInt(num);
                start++;
            }else{
                valL += sign * Integer.parseInt(num);
            }
             
        }
       // System.out.println("Coff left = " + coffL +" and val left = " + valL);
        start = 0;
        int lenR = rightP.length();
        int coffR = 0, valR = 0;
         while(start < lenR){
            String num = "";
            int sign = 1;
            if(start < lenR && rightP.charAt(start) == '-'){
                sign = -1;
                start++;
            }else if(rightP.charAt(start) == '+'){
                start++;
            }
            while(start < lenR && Character.isDigit(rightP.charAt(start))){
                num = num + rightP.charAt(start);
                start++;
            }
            if(start < lenR && rightP.charAt(start) == 'x'){
                 if(num.equals("")) 
                   num = "1";
                coffR += sign * Integer.parseInt(num);
                 start++;
            }else{
                valR += sign * Integer.parseInt(num);
            }
             
        }
        // System.out.println("Coff right = " + coffR +" and val right = " + valR);
        if(coffR == coffL && valR == valL){
            return "Infinite solutions";
        }else if(coffR == coffL && valR != valL){
            return "No solution";
        }else{
            return "x=" + ((valR - valL) / (coffL - coffR));
        }
    }
}
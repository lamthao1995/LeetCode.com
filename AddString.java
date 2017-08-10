public class Solution {
    public String addStrings(String num1, String num2) {
        int distance = num1.length() - num2.length();
        if(distance > 0){
            for(int i = 1; i <= distance; i++){
                num2 = "0" + num2;
            }
        }else{
            for(int i = 1; i <= -distance; i++){
                num1 = "0" + num1;
            }
        }
        String rs = "";
        int hold = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int digit2 = Character.getNumericValue(num2.charAt(i));
            int sum = hold + digit1 + digit2;
            hold = sum / 10;
            rs = (sum % 10) + rs;
        }
        if(hold != 0) rs = hold + rs;
        return rs;
    }
}
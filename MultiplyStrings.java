public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.charAt(0) == '0') return "0";
        if(num2.length() == 1 && num2.charAt(0) == '0') return "0";
        String rs = "0";
        int counter = -1;
        for(int i = num1.length() - 1; i >= 0; i--){
            counter++;
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int hold = 0;
            String temp = "";
            for(int j = num2.length() - 1; j >= 0; j--){
                int digit2 = Character.getNumericValue(num2.charAt(j));
                int tmp = digit1 * digit2 + hold;
                hold = tmp / 10;
                temp = (tmp % 10) + temp;
            }
            if(hold != 0) temp = hold + temp;
            for(int a = 0; a < counter; a++) temp = temp + "0";
            rs = add(rs, temp);
           
        }
        
        return rs;
    }
    public String add(String num1, String num2){
         //System.out.println( "and num1 = " + num1 +" num2 = " + num2);
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
        //System.out.println("rs = " + rs+ " and num1 = " + num1 +" num2 = " + num2);
        return rs;
    }
}
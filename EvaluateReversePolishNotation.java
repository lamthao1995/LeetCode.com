public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<String> stack = new Stack();
        for(String s : tokens){
           if(!s.equals("/") && !s.equals("*") && !s.equals("+") && !s.equals("-")){
               stack.push(s);
           }else{
               int num1 = Integer.parseInt(stack.pop());
               int num2 = Integer.parseInt(stack.pop());
               int rs = 0;
               if(s.equals("*")){
                   rs = num1 * num2;
               }else if(s.equals("/")){
                   rs = num2 / num1;
               }else if(s.equals("+")){
                   rs = num1 + num2;
               }else{
                   rs = num2 - num1;
               }
               stack.push(rs + "");
           }
        }
        return Integer.parseInt(stack.pop());
    }
}
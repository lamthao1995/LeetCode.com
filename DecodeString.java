public class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        String integers = "0123456789";
        Stack<String> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            String c = s.charAt(i) + "";
            if(c.equals("]")){
                String tmp = "";
                while(!stack.peek().equals("[")){
                    tmp = stack.pop() + tmp; 
                }
                stack.pop();
                String number = "";
                System.out.println("Size : " + stack.size());
                while(stack.isEmpty() == false && integers.contains(stack.peek())){
                    number = stack.pop() + number;
                }
                int num = Integer.parseInt(number);
                String temp = tmp;
                for(int j = 1; j < num; j++){
                    temp = temp + tmp;
                }
                stack.push(temp);
            }else{
                stack.push(c);
            }
        }
        String rs = "";
        while(!stack.isEmpty()){
            rs = stack.pop() + rs;
        }
        return rs;
    }
}
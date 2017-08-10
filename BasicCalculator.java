public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int cur = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        Stack<int[]> changeSign = new Stack();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ')'){
                while(!changeSign.isEmpty() && (char)changeSign.peek()[0] != '(')
                    changeSign.pop();
                int start = -1;
                if(!changeSign.isEmpty())
                        start = changeSign.peek()[1];
                changeSign.pop();
                boolean isMinus = false;
                while(!changeSign.isEmpty() && (char)changeSign.peek()[0] != '('){
                    if((char)changeSign.peek()[0] == '-'){
                        isMinus = true;
                        break;
                    }
                    if((char)changeSign.peek()[0] == '+')
                        break;
                    changeSign.pop();
                }
                if(isMinus == true && start != -1){
                    //System.out.println("vao roi");
                   for(;start <= i; start++){
                         if(arr[start] == '-'){
                             arr[start] = '+';
                         }else if(arr[start] == '+'){
                             arr[start] = '-';
                         }
                   } 
                }
                
            }else{
                int d[] = new int[]{(int)arr[i], i};
                changeSign.push(d);
            }
        }
        //
        Stack<String> stack = new Stack();
        while(cur < len){
            while(cur < len && (arr[cur] == ' ' || arr[cur] == '(' || arr[cur] == ')'))
                cur++;
            int start = cur;
            while(start < len && Character.isDigit(arr[start]) == true)
                start++;
            if(start <= len){
                String number = s.substring(cur, start);
                stack.push(number);
            }
            //find a sign
            while(start < len && (arr[start] == ' ' || arr[start] == '(' || arr[start] == ')'))
                start++;
            if(start < len){
                String sign = arr[start] + "";
                stack.push(sign);
            }
            cur = start + 1;    
        }
        while(stack.size() != 1){
            int num1 = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int num2 = Integer.parseInt(stack.pop());
            int rs = 0;
            if(stack.isEmpty()){
                if(sign.equals("+")){
                    rs = num1 + num2;
                 }else{
                    rs = num2 - num1;
                 }
                return rs;
            }
            if(stack.peek().equals("+")){
                 if(sign.equals("+")){
                    rs = num1 + num2;
                 }else{
                    rs = num2 - num1;
                 }
            }else{
                if(sign.equals("+")){
                    rs = num2 - num1;
                 }else{
                    rs = num2 + num1;
                 }
            }
            stack.push(rs + "");
        }
         return Integer.parseInt(stack.get(0));
        //return 1;
    }
}
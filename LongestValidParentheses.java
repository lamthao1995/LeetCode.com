public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    result = Math.max(result, i - stack.peek());
            }
        }
         return result;
    }
}
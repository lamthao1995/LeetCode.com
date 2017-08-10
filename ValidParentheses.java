public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ')' && c != ']' && c!= '}'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char popC = stack.pop();
                if(popC == '('){
                    if(c != ')') return false;
                }else if(popC == '['){
                    if(c != ']') return false;
                }else{
                    if(c != '}') return false;
                }
            }
        }
        if(stack.isEmpty() == false) return false;
        else return true;
    }
}
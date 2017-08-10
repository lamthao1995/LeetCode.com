public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k)
            return "0";
        Stack<Character> stack = new Stack();
        int cur = 0;
        while(cur < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(cur)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(cur));
            cur++;
        }
        while(k-- > 0){
            stack.pop();
        }
        StringBuilder bf = new StringBuilder();
        while(stack.size() > 0)
            bf.append(stack.pop());
        bf.reverse();
        while(bf.length() > 1 && bf.charAt(0) == '0')
            bf.deleteCharAt(0);
        return bf.toString();
    }
}
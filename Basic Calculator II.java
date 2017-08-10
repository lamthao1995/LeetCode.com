public class Solution {
    public int calculate(String s) {
        List<String> arr = new ArrayList<>();
        int cur = 0;
        int len = s.length();
        while(cur < len){
            while(cur < len && s.charAt(cur) == ' ') cur++;
            int start = cur;
            while(start < len && Character.isDigit(s.charAt(start))) start++;
            arr.add(s.substring(cur, start));
            //add sign
            while(start < len && s.charAt(start) == ' ') start++;
            if(start < len) arr.add(s.charAt(start) + "");
            cur = start + 1;
        }
        HashSet<String> set = new HashSet();
        set.add("/"); set.add("*"); set.add("+"); set.add("-");
        Stack<String> stack = new Stack<>();
        ///ki phap ba lan
        Queue<String> rs = new LinkedList<>();
        for(int i = 0; i < arr.size(); i++){
            String tmp = arr.get(i);
            if(!set.contains(tmp)){
                rs.add(tmp);
            }else{
                while(!stack.isEmpty() && getValue(stack.peek()) >= getValue(tmp)){
                    rs.add(stack.pop());
                }
                stack.add(tmp);
            }
        }
        while(!stack.isEmpty()){
            rs.add(stack.pop());
        } 
        for(int i = 0; i < arr.size(); i++){
            String tmp = rs.poll();
            if(set.contains(tmp)){
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                int r = 0;
                if(tmp.equals("/")){
                    r = num2 / num1;
                }else if(tmp.equals("*")){
                    r = num1 * num2;
                }else if(tmp.equals("+")){
                    r = num1 + num2;
                }else{
                    r = num2 - num1;
                }
                stack.push(r + "");
            }else{
                stack.push(tmp);
            }
        }
        if(stack.size() == 0) return 0;
        return Integer.parseInt(stack.pop());
    }
    public int getValue(String s){
        if(s.equals("/") || s.equals("*"))
            return 2;
        else return 1;
    }
}
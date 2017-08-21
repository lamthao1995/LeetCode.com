class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>();
        skip.add(".."); skip.add(""); skip.add(".");
        for(String dir : path.split("/")){
            if(dir.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!skip.contains(dir)){
                stack.push(dir);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res; 
    }
}
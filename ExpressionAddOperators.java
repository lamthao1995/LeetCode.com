public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rs = new ArrayList<>();
        helper(rs, "", 0, 0, 0, (long)target, num);
        return rs;
    }
    public void helper(List<String> result, String pattern, int index, long eval, 
                       long multi, long target, String s){
        if(index == s.length()){
            if(eval == target){
                result.add(pattern);
            }
            return;
        }
        String number = "";
        for(int i = index; i < s.length(); i++){
            if(i != index && s.charAt(index) == '0') break;
            number = number + s.charAt(i);
            long cur = Long.parseLong(number);
            if(index == 0){
                helper(result, pattern + cur, i + 1, cur, cur, target, s);
                continue;
            }
            helper(result, pattern + "+" + cur, i + 1, eval + cur, cur, target, s);
            helper(result, pattern + "-" + cur, i + 1, eval - cur, -cur, target, s);
            helper(result, pattern + "*" + cur, i + 1, eval - multi + multi * cur, multi * cur, target, s);
        }
    }
    
}
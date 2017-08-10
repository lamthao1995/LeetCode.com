public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }
    public void dfs(List<String> rs, String s, int left, int right){
        if(left > right)
            return;
        if(left == 0 && right ==0){
            rs.add(s);
            return;
        }
        
        if(left > 0)
            dfs(rs, s + "(", left - 1, right);
        if(right > 0)
            dfs(rs, s + ")", left, right - 1);
    }
}
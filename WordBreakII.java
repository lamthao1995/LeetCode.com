public class Solution {
    List<String> rs = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        ArrayList<String>[] contain = new ArrayList[len + 1];
        contain[0] = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(contain[i] == null) continue;
            for(int j = i + 1; j <= len; j++){
                String sub = s.substring(i, j);
                if(wordDict.contains(sub)){
                    if(contain[j] == null){
                        contain[j] = new ArrayList<>();
                    }
                    contain[j].add(sub);
                }
            }
        }
        if(contain[len] == null)
            return rs;
        dfs(contain, "", len);
        return this.rs;
        
    }    
    public void dfs(List<String>[] contain, String s, int index){
            if(index == 0)
                this.rs.add(s.trim());
            else{
                for(String tmp : contain[index]){
                    dfs(contain, tmp + " " + s, index - tmp.length());
                }
            }
       
    }
}
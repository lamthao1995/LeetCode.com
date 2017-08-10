public class Solution {
    int trace[];
    List<String> rs = new ArrayList<>();
    public List<String> generateAbbreviations(String word) {
        int len = word.length();
        trace = new int[len];
        backtrack(word, 0);
        return rs;
    }
    public void backtrack(String word, int k){
        if(k == word.length()){
            record(word);
            return;
        }
        for(int i = 0; i <= 1; i++){
            if(i == 0){
                backtrack(word, k + 1);
            }else{
                trace[k] = 1;
                backtrack(word, k + 1);
                trace[k] = 0;
            }
        }
    }
    public void record(String s){
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while(cur < s.length()){
            while(cur < s.length() && trace[cur] == 0){
                sb.append(s.charAt(cur));
                cur++;
            }
            int count = 0;
            while(cur < s.length() && trace[cur] == 1){
                count++;
                cur++;
            }
            if(count > 0)
                sb.append(count + "");
        }
        rs.add(sb.toString());
    }
}
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rs = new ArrayList<>();
        if(strs == null) return rs;
        HashMap<Integer, List<String>> hash = new HashMap<>();
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            int valueOfTemp = String.valueOf(temp).hashCode();
            if(!hash.containsKey(valueOfTemp)){
                List<String> ps = new ArrayList<>();
                ps.add(s);
                hash.put(valueOfTemp, ps);
            }else{
                List<String> ps = hash.get(valueOfTemp);
                ps.add(s);
                hash.put(valueOfTemp, ps);
                
            }
        }
        for(int x : hash.keySet()){
            rs.add(hash.get(x));
        }
        return rs;
    }
}
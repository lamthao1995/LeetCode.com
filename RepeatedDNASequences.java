public class Solution {
    int fixLength = 10;
    List<String> result = new ArrayList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if(len < 10) return result;
        HashMap<String, Integer> s1 = new HashMap<>();
        for(int i = 0; i <= len - fixLength; i++){
            String temp = s.substring(i, i + fixLength);
            if(s1.containsKey(temp)){
               s1.put(temp, s1.get(temp) + 1);
               if(s1.get(temp) == 2){
                   result.add(temp);
               }
            }else{
                s1.put(temp, 1);
            }
        }
        return result;
    }
}
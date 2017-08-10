public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0|| words == null || words.length == 0)
            return result;
        Map<String, Integer> map = new HashMap();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        int len = words[0].length();
        for(int j = 0; j < len; j++){
            Map<String, Integer> curMap = new HashMap();
            int start = j;
            int count = 0;
            
            for(int i = j; i <= s.length() - len; i += len){
                String sub = s.substring(i, i + len);
                if(map.containsKey(sub)){
                    curMap.put(sub, curMap.getOrDefault(sub, 0) + 1);
                    count++;
                    
                    while(curMap.get(sub) > map.get(sub)){
                        String left = s.substring(start, start + len);
                        curMap.put( left, curMap.get(left) - 1);
                        count--;
                        start += len;
                    }
                    if(count == words.length){
                        result.add(start);
                        String left = s.substring(start, start + len);
                        curMap.put(left, curMap.get(left) - 1);
                        count--;
                        start += len;
                    }
                }else{
                    curMap.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }
        return result;
    }
}
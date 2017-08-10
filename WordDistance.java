public class WordDistance {
    HashMap<String, List<Integer>> map = new HashMap();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int l1 = 0, l2 = 0;
        while(l1 < list1.size() && l2 < list2.size()){
            if(list1.get(l1) < list2.get(l2)){
                min = Math.min(min, (list2.get(l2) - list1.get(l1)));
                l1++;
            }else{
                min = Math.min(min, (-list2.get(l2) + list1.get(l1)));
                l2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
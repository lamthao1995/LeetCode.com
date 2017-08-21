class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap();
        for(String s : strings){
            int len = s.length();
            if(!map.containsKey(len)){
                map.put(len, new ArrayList<String>());
            }
            map.get(len).add(s);
        }
       // System.out.println("Size: " + map.get(2).size());
        for(int key : map.keySet()){
            List<String> list = map.get(key);
            Set<String> visited = new HashSet();
            for(int i = 0; i < list.size(); i++){
                List<String> arr = new ArrayList<>();
                if(visited.contains(list.get(i)))
                    continue;
                visited.add(list.get(i));
                arr.add(list.get(i));
                for(int j = i + 1; j < list.size(); j++){
                    if(isSameGroup(list.get(i), list.get(j))){
                        arr.add(list.get(j));
                        visited.add(list.get(j));
                    }
                }
                res.add(arr);
            }
        }
        return res;
        
    }
    private boolean isSameGroup(String s1, String s2){
        Integer diff = null;
        Integer prev = null;
        for(int i = 0; i < s1.length(); i++){
            if(prev != null && prev != diff){
                return false;
            }
            if(diff != null)
                prev = diff;
            diff = s1.charAt(i) - s2.charAt(i);
            if(diff < 0){
                diff = diff + 26;
            }
        }
        if(diff != null && prev != null && diff != prev)
            return false;
        return true;
    }
}
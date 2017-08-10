public class Solution {
    public Map<String, Integer> hash = new HashMap<String, Integer>();
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> str = new ArrayList<>(); 
        int max_key = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            hash.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++){
            if(hash.containsKey(list2[i])){
                int temp = hash.get(list2[i]) + i;
                if(temp < max_key){
                    max_key = temp;
                    str = new ArrayList<>();
                    str.add(list2[i]);
                }else if(temp == max_key){
                    str.add(list2[i]);
                }
            }
        }
        String[] rs = new String[str.size()];
        for(int i = 0; i < rs.length; i++){
            rs[i] = str.get(i);
        }
        return rs;
    }
}
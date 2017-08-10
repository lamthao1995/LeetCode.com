public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums1){
            if(!map.containsKey(x)){
                map.put(x, 1);
            }
        }
        int counter = 0;
        for(int x : nums2){
            if(map.containsKey(x)){
                if(map.get(x) == 1){
                    map.put(x, 0);
                    counter++;
                }
            }
        }
        int rs[] = new int[counter];
        counter = 0;
        for(int x : map.keySet()){
            if(map.get(x) == 0){
                rs[counter++] = x;
            }
        }
        return rs;
    }
}
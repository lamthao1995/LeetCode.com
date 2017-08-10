public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums1){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x : nums2){
            if(map.containsKey(x)){
                int num = map.get(x);
                if(num > 0){
                    arr.add(x);
                    map.put(x, map.get(x) - 1);
                }
            }
        }
        int[] rs = new int[arr.size()];
        for(int i = 0; i < rs.length; i++){
            rs[i] = arr.get(i);
        }
        return rs;
    }
}
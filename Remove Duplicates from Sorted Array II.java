public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int removeDuplicates(int[] nums) {
        for(int key : nums){
            if(map.containsKey(key) == false){
                map.put(key,1);
            }else{
                int numOfE = map.get(key);
                numOfE++;
                if(numOfE >= 2){
                    map.put(key, 2);
                }
            }
        }
        int counter = 0;
        TreeSet<Integer> set = new TreeSet();
        for(int x : map.keySet()){
            set.add(x);
        }
        for(int key : set){
             int numOfE = map.get(key);
             for(int i = 0; i < numOfE; i++){
                 nums[counter++] = key;
             }
              
        }
        return counter;
    }
}
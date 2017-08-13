public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap(); // store index as value, score as key
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);    
        }
        String[] rs = new String[nums.length];
        int counter = nums.length - 1;
        for(int key : map.keySet()){
            if(counter > 2){
                rs[map.get(key)] = (counter + 1) + "";
            }else{
                if(counter == 0){
                    rs[map.get(key)] = "Gold Medal";
                }else if(counter == 1){
                     rs[map.get(key)] = "Silver Medal";
                }else{
                     rs[map.get(key)] = "Bronze Medal";
                }
            }
            counter--;
        }
        return rs;
    }
}
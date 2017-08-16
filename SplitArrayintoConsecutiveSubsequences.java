public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        HashMap<Integer, Integer> append = new HashMap();
        
        for(int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for(int i : nums){
            if(freq.getOrDefault(i, 0) == 0) continue;
            if(append.getOrDefault(i, 0) > 0){
                append.put(i, append.get(i) - 1);
                append.put(i + 1, append.getOrDefault(i + 1, 0) + 1);
            }else if(freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0){
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                append.put(i + 3, append.getOrDefault(i + 3, 0) + 1);
            }else
                return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
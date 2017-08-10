public class Solution {
    HashMap<Integer, Integer> s = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int trace[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            s.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(trace[i] == 1) continue;
            if(s.containsKey(nums[i])){
                trace[i] = 1;
                int key = nums[i] + 1;
                int counter = 1;
                while(s.containsKey(key)){
                    int index = s.get(key);
                    trace[i] = 1;
                    key++;
                    counter++;
                }
                key = nums[i] - 1;
                while(s.containsKey(key)){
                    int index = s.get(key);
                    trace[index] = 1;
                    key--;
                    counter++;
                }
                if(counter > max) max = counter;
            }
        }
        return max;
        
        
    }
}
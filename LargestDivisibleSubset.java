public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        int[] count = new int[len];
        int[] trace = new int[len];
        Arrays.fill(count, 1);
        Arrays.fill(trace, -1);
        int maxSize = 0;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(count[i] < count[j] + 1){
                        count[i] = count[j] + 1;
                        trace[i] = j;
                    }
                }
            }
            if(count[maxSize] < count[i])
                maxSize = i;
        }
        int k = maxSize;
        while(k >= 0){
            res.add(nums[k]);
            k = trace[k];
        }
        return res;
        
        
    }
}
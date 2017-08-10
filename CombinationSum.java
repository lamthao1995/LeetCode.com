public class Solution {
    int sum = 0;
    int len = 0;
    int[] trace;
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.len = candidates.length;
        if(this.len == 0) return rs;
        trace = new int[100000];
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return rs;
    }
    public void backtrack(int[] nums, int k, int target){
        for(int i = 0; i < this.len; i++){
            sum += nums[i];
            trace[k] = nums[i];
            if(sum == target){
                //rootRecord
                rootRecord(k);
    
            }else if(sum < target){
                backtrack(nums, k + 1, target);
            }
            sum -= nums[i];
        }
    }
    public void rootRecord(int k){
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            arr.add(trace[i]);
            if(i > 0 && trace[i] < trace[i - 1]) return;
        }
        rs.add(arr);
    }
    
}
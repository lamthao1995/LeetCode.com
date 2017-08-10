public class Solution {
    int sum = 0;
    int[] trace;
    int len = 0;
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.len = candidates.length;
        trace = new int[this.len];
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int sum = target - candidate[i] - candidates[j];
                int index = findIndex(j + 1, len - 1, candidates, sum);
                if(index != -1){
                    List<>
                }
            }
        }
        return this.arr;
        
    }
    public void record(){
        
    }
    public int findIndex(int L, int H, int[] nums, int val){
        if(L > H) return -1;
        int mid = (L + H);
        if(nums[mid] == val){
            return mid;
        }else if(nums[mid] > val){
            return findIndex(L, mid - 1, nums, val);
        }else{
            return findIndex(mid + 1, H, nums, val);
        }
    }
}
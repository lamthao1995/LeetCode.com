public class Solution {
    int trace[];
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        trace = new int[len];
        dotask(nums, len, 0);
        return rs;
    }
    public void dotask(int[] nums, int len, int k){
       for(int i = 0; i <= 1; i++){
           trace[k] = i;
           if(k == len - 1){
               record(nums);
           }else if(k < len - 1){
               dotask(nums, len, k + 1);
           }
       }
    }
    public void record(int[] nums){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < trace.length; i++){
            if(trace[i] != 0) arr.add(nums[i]);
        }
        this.rs.add(arr);
    }
}
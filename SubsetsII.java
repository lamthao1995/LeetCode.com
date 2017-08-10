public class Solution {
    int trace[];
    int len = 0;
    List<List<Integer>> rs = new ArrayList<>();
    HashSet<List<Integer>> hash = new HashSet();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        trace = new int[len];
        bk(nums, 0, len);
        return this.rs;
    }
    public void bk(int[] num, int k, int len){
        for(int i = 0; i <= 1; i++){
            trace[k] = i;
            if(k == len -1 ){
                record(num);
            }else if(k < len - 1){
                bk(num, k + 1, len);
            }
        }
    }
    public void record(int num[]){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            if(trace[i] == 1){
                arr.add(num[i]);
            }
        }
        if(hash.contains(arr) == false){
            this.rs.add(arr);
            hash.add(arr);
        }
    }
}
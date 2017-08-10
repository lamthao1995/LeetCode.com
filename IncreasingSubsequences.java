public class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(new ArrayList<>(), 0, nums);
        return new ArrayList<>(result);
    }
    public void backTrack(List<Integer> rs, int k, int nums[]){
        if(k == nums.length){
            List<Integer> clone = new ArrayList<>(rs);
            if(clone.size() > 1)
                result.add(clone);
            return;
        }
        for(int i = 0; i <= 1; i++){
            if(i == 1){
                if(!rs.isEmpty() && rs.get(rs.size() - 1) > nums[k])
                    continue;
                rs.add(nums[k]);
                backTrack(rs, k + 1, nums);
                rs.remove(rs.size() - 1);
            }else{
                backTrack(rs, k + 1, nums);
            }
        }
    }
}
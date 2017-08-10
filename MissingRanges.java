public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long uppe = (long) upper, lowe = (long) lower;
        List<String> rs = new ArrayList<>();
        int cur = 0, len = nums.length;
        if(len == 0){
            record(lowe - 1, uppe + 1, rs);
            return rs;
        }
        while(cur < len && nums[cur] < lowe) cur++;
        if(cur < len && nums[cur] > lowe){
            record(lowe - 1, nums[cur], rs);
        }
        while(cur < len && nums[cur] <= uppe){
            if(cur > 0)
                record(nums[cur - 1], nums[cur], rs);
            cur++;
        }
        if(nums[len - 1] <= uppe){
            record(nums[len - 1], uppe + 1, rs);
        }
        return rs;
    }
    public void record(long a, long b, List<String> rs){
        if((b - a) > 2){
            String tmp = (a + 1) + "->" + (b - 1);
            rs.add(tmp);
        }else if((b - a) == 2){
            rs.add((a + 1) + "");
        }
    }
}

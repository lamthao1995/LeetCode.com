public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || k < 0 || nums.length < 2)
            return false;
        TreeSet<Integer> tree = new TreeSet();
        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            if(tree.floor(c) != null && tree.floor(c) + t >= c) 
                return true;
            if(tree.ceiling(c) != null && tree.ceiling(c) - t <= c)
                return true;
            tree.add(c);
            if(i >= k){
                tree.remove(nums[i - k]);
            }
        }
        return false;
    }
}
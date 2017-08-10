public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int x : nums){
            if(set.contains(x)) return true;
            else set.add(x);
        }
        return false;
    }
}
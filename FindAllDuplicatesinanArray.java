public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return arr;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                arr.add(index + 1);
            else
                nums[index] = -nums[index];
        }
        return arr;
    }
}
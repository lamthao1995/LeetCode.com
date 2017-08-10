public class Solution {
    private int[] originalArr;
    private Random random;
    public Solution(int[] nums) {
        this.originalArr = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.originalArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(originalArr == null)
            return null;
        int[] a = originalArr.clone();
        for(int j = 1; j < a.length; j++)
            swap(j, random.nextInt(j + 1), a);
        return a;
    }
    private void swap(int x, int y, int[] nums){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] counts = new int[32];
        for(int i : nums){
            int counter = 0;
            while(i > 0){
                if((i & 1) == 1){
                    counts[counter]++;
                }
                counter++;
                i >>= 1;
            }
        }
        int count = 0;
        for(int i : counts){
            count += i * (nums.length - i);
        }
        return count;
    }
}
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
         List<Long> cand = new ArrayList<>();
        cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
        cand.add(0L);
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand.add(sum[i]);
            cand.add(lower + sum[i - 1] - 1);
            cand.add(upper + sum[i - 1]);
        }
        Collections.sort(cand); // finish discretization
        int[] bit = new int[cand.size()];
        for (int i = 0; i < sum.length; i++) updateBit(bit, Collections.binarySearch(cand, sum[i]), 1);
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            updateBit(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
            ans += getSum(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
            ans -= getSum(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
        }
        return ans;
    }
    public int getSum(int bit[], int i){
        int sum = 0;
         for (; i > 0; i -= i & -i) sum += bit[i];
        return sum;
    }
    public void updateBit(int[] bit, int i, int val){
        for (; i < bit.length; i += i & -i) bit[i] += val;
    }
    // public int[] constructBit(int[] arr){
    //     int n = arr.length;
    //     int[] bit = new int[n];
    //     for(int i = 0; i < n; i++)
    //         updateBit(bit, n, i, arr[i]);
    //     return bit;
    // }
}
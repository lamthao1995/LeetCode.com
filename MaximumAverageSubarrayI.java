public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        max = (double)sum / k;
        int counter = 0;
        for(int i = k; i < len; i++){
            sum -= nums[counter++];
            sum += nums[i];
            max = max((double)sum / k, max);
        }
        return max;
    }
    public double max(double a, double b){
        return a > b ? a : b;
    }
}
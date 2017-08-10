public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        double error = Integer.MAX_VALUE;
        double prev = max;
        while(error > 0.00001){
            double mid = (max + min) * 0.5;
            if(check(nums, k, mid)){
                min = mid;
            }else{
                max = mid;
            }
            error = Math.abs(prev - mid);
            prev = mid;
           
        }
        return min;
    }
    public boolean check(int[] num, int k, double mid){
        double sum = 0, minsum = 0;
        for(int i = 0; i < k; i++){
            sum += num[i] - mid;
        }
        if(sum >= 0)
            return true;
        double prev = 0;
        for(int i = k; i < num.length; i++){
            sum += num[i] - mid;
            prev += num[i - k] - mid;
            minsum = Math.min(prev, minsum);
            if(sum >= minsum)
                return true;
        }
        return false;
    }
}
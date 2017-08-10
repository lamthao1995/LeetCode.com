public class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i]--;
        }
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int sum = 0; int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumIndex.containsKey(sum)){
                max = max(max, i - sumIndex.get(sum));
            }else{
                sumIndex.put(sum, i);
            }
        }
        return max;
    }
    public int max(int a, int b){
        return a > b ? a : b;
    }
}
public class Solution {
     public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int numOfE = nums.length;
        int[][] trace = new int[numOfE][numOfE];
        for(int len = 1; len <= numOfE; len++){
            for(int start = 0; start <= numOfE - len; start++){
                //caculate end and start
                int end = start + len - 1;
                int bestCoin = 0;
                for(int curr = start; curr <= end; curr++){
                    int coin = 0;
                    coin += (start != curr ? trace[start][curr - 1] : 0);
                    coin += (end != curr ? trace[curr + 1][end] : 0);
                    coin += getCoin(start - 1, nums) * nums[curr] * getCoin(end + 1, nums);
                    if(coin > bestCoin) bestCoin = coin;
                }
                trace[start][end] = bestCoin;
            }
        }
        return trace[0][numOfE - 1];
    }
    public int getCoin(int index, int[] nums){
            if(index < 0 || index >= nums.length){
                return 1;
            }else{
                return nums[index];
            }
        }
}
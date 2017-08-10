public class Solution {
    int max = -1;
    public int arrayNesting(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            dfs(nums, i, 1);
        }
        return max;
    }
    public void dfs(int[] arr, int k, int count){
        if(arr[k] == -1) return;
        int temp = arr[k];
        arr[k] = -1;
        if(count > max) max = count;
        dfs(arr, temp, count + 1);
    }
}
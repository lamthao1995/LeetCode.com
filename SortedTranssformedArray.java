public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int rs[] = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int index = a >= 0 ? end : start;
        while(start <= end){
            if(a >= 0){
                rs[index--] = getVal(nums[start], a, b, c) > getVal(nums[end], a, b, c) 
                            ? getVal(nums[start++], a, b, c) : getVal(nums[end--], a, b, c);
            }else{
                rs[index++] = getVal(nums[start], a, b, c) <= getVal(nums[end], a, b, c) 
                            ? getVal(nums[start++], a, b, c) : getVal(nums[end--], a, b, c);
            }
        }
        return rs;
    }
    public int getVal(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}
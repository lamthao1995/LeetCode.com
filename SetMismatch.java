public class Solution {
    public int[] findErrorNums(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int len = nums.length;
        int num1 = 0, num2 = 0;
        for(int x : nums){
            sum += x;
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x) == 2)
                num1 = x;
        }
        num2 = len * (len + 1) / 2 - sum + num1;
        return new int[]{num1, num2};
    }
}
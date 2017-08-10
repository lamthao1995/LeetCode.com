public class Solution {
    int[] trace;
    String rs = "";
    public String getPermutation(int n, int k) {
       int pos = 0;
       List<Integer> nums = new ArrayList<>();
       int[] fact = new int[n + 1];
       fact[0] = 1;
       for(int i = 1; i <= n; i++){
           fact[i] = i * fact[i - 1];
       }
       for(int i = 1; i <= n; i++)
            nums.add(i);
       k--;
       for(int i = 1; i <= n; i++){
           int index = k / fact[n - i];
           rs = rs + nums.get(index);
           nums.remove(index);
           k -= index * fact[n - i];
       }
       
       return rs;
    }
}
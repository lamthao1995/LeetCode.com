public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet();
        while(true){
            n = getNewNum(n);
            if(n == 1) return true;
            else{
                if(s.contains(n)) return false;
                else s.add(n);
            }
        }
    }
    public int getNewNum(int x){
        if(x == 0) return 0;
        int sum = 0;
        while(x != 0){
            int mod = x % 10;
            sum += mod * mod;
            x = x / 10;
        }
        return sum;
    }
}
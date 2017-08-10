public class Solution {
    final int MOD = 1337;
    int[] trace = new int[10];
    public int superPow(int a, int[] b) {
        if(a == 1 || a == 0) return a;
        int pow = 0;
        int result = 1;
        a = a % MOD;
        trace[0] = 1;
        for(int i = 1; i < 10; i++){
            trace[i] = (trace[i - 1] * a ) % MOD;
        }
       
        for(int i = 0; i < b.length; i++){
            pow = b.length - i - 1;
            if(b[i] == 0) continue; 
            int x = trace[b[i]];
            result *= superP(x, pow);
            result = result  % MOD;
        }
        return result;
    }
    public int superP(int a, int pow){
        if(pow == 0) return a;
        int aPart = superP(a, pow - 1);
        int rs = 1;
        for(int i = 0; i < 10; i++){
            rs = rs * aPart;
            rs = rs % MOD;
        }
        return rs;
    }
}
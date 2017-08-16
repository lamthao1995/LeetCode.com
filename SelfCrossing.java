public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if(len < 4) return false;
        for(int i = 3; i < len; i++){
            if(x[i] >= x[i - 2] && x[i -1] <= x[i - 3]) 
                return true;
            if(i >= 4){
                if(x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                    return true;
            }
            if(i >= 5){
                if(x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4] 
                   && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                    return true;
            }
        }
        return false;
    }
}
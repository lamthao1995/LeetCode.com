public class Solution {
    int[][] trace;
    public String frequencySort(String s) {
        int len = s.length();
        trace = new int[128][2];
        for(int i = 0; i < len; i++){
            int index = (int)s.charAt(i);
            trace[index][1]++;
            trace[index][0] = index;
        }
        StringBuilder rs = new StringBuilder();
        quick(0, 127);
        for(int i = 127; i >= 0; i--){
            int fre = trace[i][1];
            if(fre > 0){
                Character c = (char) (trace[i][0]);
                for(int j = 1; j <= fre; j++){
                    rs.append(c);
                }
            }
        }
        return rs.toString();
    }
    public void quick(int L, int H){
        int mid = trace[(L + H) / 2][1];
        int s = L, e = H;
        do{
            while(trace[s][1] < mid) s++;
            while(trace[e][1] > mid) e--;
            if(e >= s){
                int temp = trace[s][1];
                trace[s][1] = trace[e][1];
                trace[e][1] = temp;
                
                temp = trace[s][0];
                trace[s][0] = trace[e][0];
                trace[e][0] = temp;
                e--; s++;
            }
        }while(s <= e);
        if(L < e) quick(L, e);
        if(s < H) quick(s, H);
    }
}
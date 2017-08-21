public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] rapport = new int[102];
        int[] rest = new int[102];
        Arrays.fill(rapport, -1);
        Arrays.fill(rest, -1);
        int b = -1, posRest = 0, rap = 0;
        int last = -1;
        rapport[0] = rest[0] = 0;
        for(int i = 1; i <= s2.length() + 1; i++){
            int j;
            for(j = 0; j < s1.length(); j++){
                if(s2.charAt(posRest) == s1.charAt(j)){
                    posRest++;
                    if(posRest == s2.length()){
                        rap++;
                        posRest = 0;
                    }
                }
            }
            for(int k = 0; k < i; k++){
                if(posRest == rest[k]){
                    b = k;
                    last = i;
                    break;
                }
            }
            rapport[i] = rap;
            rest[i] = posRest;
            if(b >= 0) break;
        }
        int interval = last - b;
        if(b >= n1)
            return rapport[n1] / n2;
        return ((n1 - b) / interval * (rapport[last] - rapport[b]) + rapport[(n1 - b) % interval + b]) / n2;
            
            
    }
}
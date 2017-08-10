public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] d = new int[l1 + 1][l2 + 1];
        for(int i = 1; i <= l1; i++){
             d[i][0] = i;
        }
        for(int i = 1; i <= l2; i++){
            d[0][i] = i;
        }
        for(int i = 1; i <= l2; i++){
            for(int j = 1; j <= l1; j++){
                int cost = 1;
                if(word1.charAt(j - 1) == word2.charAt(i - 1)){
                    cost = 0;
                }
                d[j][i] = min(d[j - 1][i] + 1,
                              d[j][i - 1] + 1,
                              d[j - 1][i - 1] + cost);
            }
        }
        return d[l1][l2];
    }
    public int min(int a, int b, int c){
        int min = a;
        if(min > c) min = c;
        if(min > b) min = b;
        return min;
    }
}
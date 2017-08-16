public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexS = 0, indexG = 0;
        int count = 0;
        while(indexS < s.length && indexG < g.length){
            if(s[indexS] >= g[indexG]){
                indexS++;
                indexG++;
                count++;
            }else{
                indexS++;
            }
        }
        return count;
    }
}
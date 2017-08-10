public class Solution {
    public int arrangeCoins(int n) {
        int level = 1;
        while(n >= level){
            n -= level;
            level++;
        }
        return level - 1;
    }
}
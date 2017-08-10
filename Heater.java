public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max = heaters[0];
        for(int i = 1; i < heaters.length; i++){
            max = Math.max(max, heaters[i] - heaters[i - 1] - 1);
        }
        return (max % 2 == 0) ? max / 2 : (max / 2 + 1);
    }
}
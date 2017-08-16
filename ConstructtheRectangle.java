public class Solution {
    public int[] constructRectangle(int area) {
        int W = 0, L = 0;
        for(int i = (int)Math.sqrt(area); i >= 1; i--){
            if(area % i == 0){
                L = i;
                W = area / i;
                break;
            }
        }
        return new int[]{W, L};
    }
}
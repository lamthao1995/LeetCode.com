public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int d = Integer.MIN_VALUE;
        int totalDis = 0;
        for(int[] nut : nuts){
            totalDis += 2 * dis(nut, tree);
            d = Math.max(d, dis(nut, tree) - dis(nut, squirrel));
        }
        return totalDis - d;
    }
    private int dis(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
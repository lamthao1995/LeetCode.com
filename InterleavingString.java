public class Solution {
    boolean result = false, interupt = false;
    String s1, s2, s3;
    int l1, l2, l3;
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int lengthC1 = c1.length, lengthC2 = c2.length;
        if(lengthC1 + lengthC2 != c3.length) return false;
        return bfs(c1, c2, c3, 0, 0, 0, new boolean[lengthC1 + 1][lengthC2 + 1]);
        
    }
    public boolean bfs(char[] c1, char[] c2, char[] c3, int indexC1, int indexC2, int indexC3, boolean[][] isValid){
        if(isValid[indexC1][indexC2]) return false;
        if(indexC3 == c3.length) return true;
        boolean check = 
            indexC1 < c1.length && c1[indexC1] == c3[indexC3] && bfs(c1, c2, c3, indexC1 + 1, indexC2, indexC3 + 1, isValid) ||
            indexC2 < c2.length && c2[indexC2] == c3[indexC3] && bfs(c1, c2, c3, indexC1, indexC2 + 1, indexC3 + 1, isValid);
        if(!check) isValid[indexC1][indexC2] = true;
        return check;
    }
    
}
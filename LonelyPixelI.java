public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int rows = picture.length;
        int cols = picture[0].length;
        int[] rowB = new int[rows];
        int[] colsB = new int[cols];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(picture[i][j] == 'B'){
                    ++rowB[i];
                    ++colsB[j];
                }
            }
        }
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(picture[i][j] == 'B' && rowB[i] == 1 && colsB[j] == 1){
                   count++;
                }
            }
        }
        return count;
    }
}
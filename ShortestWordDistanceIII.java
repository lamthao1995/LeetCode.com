public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            int prev = -1;
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    if(prev == -1){
                        prev = i;
                    }else{
                        min = Math.min(min, i - prev);
                        prev = i;
                    }
                }
            }
            return min;
        }else{
            int i1 = -1, i2 = -1;            
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1))
                    i1 = i;
                else if(words[i].equals(word2))
                    i2 = i;
                if(i1 != -1 && i2 != -1)
                    min = Math.min(min, Math.abs(i1 - i2));
            }
            return min;
        }
    }
}
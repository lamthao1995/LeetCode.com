public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        int[] mask = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                mask[i] |= (1 << (c - 'a'));
            }
        }
        int result = 0;
        for(int i = 0; i < mask.length; i++){
            for(int j = i + 1; j < mask.length; j++){
                if((mask[i] & mask[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
public class Solution {
    public boolean validWordSquare(List<String> words) {
        int len = words.size();
        for(int i = 0; i < len; i++){
            String tmp = words.get(i);
            if(tmp.length() - 1 >= len)
                return false;
            for(int j = 0; j < tmp.length(); j++){
                if(words.get(j).length() <= i)
                    return false;
                if(tmp.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
}
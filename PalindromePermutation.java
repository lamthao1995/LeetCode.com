public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean isOdd = false;
        for(char c : map.keySet()){
            int totalC = map.get(c);
            if(totalC % 2 == 1 && isOdd)
                return false;
            if(totalC % 2 == 1)
                isOdd = true;
        }
        return true;
        
    }
}
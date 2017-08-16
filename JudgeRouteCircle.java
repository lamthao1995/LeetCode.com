public class Solution {
    public boolean judgeCircle(String moves) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('R', -1);
        map.put('L', 1);
        map.put('U', 100000);
        map.put('D', -100000);
        int count = 0;
        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            count += map.get(c);
        }
        if(count == 0) return true;
        return false;
    }
}
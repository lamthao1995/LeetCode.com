public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map1 = new HashMap();
        HashMap<Character, Character> map2 = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if(map1.containsKey(cS)){
                if(map1.get(cS) != cT)
                    return false;
            }else{
                map1.put(cS, cT);
            }
            if(map2.containsKey(cT)){
                if(map2.get(cT) != cS)
                    return false;
            }else{
                map2.put(cT, cS);
            }
        }
        return true;
        
    }
}
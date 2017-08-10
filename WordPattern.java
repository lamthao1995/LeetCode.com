public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(arr[i]))
                    return false;
            }else if(map.containsValue(arr[i])){
                return false;
            }
            map.put(c, arr[i]);
        }
        return true;
    }
}
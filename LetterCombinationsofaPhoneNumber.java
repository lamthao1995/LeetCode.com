public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        ArrayList<String> rs = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return rs;
        
        getString(digits, new ArrayList<Character>(), rs, map);
        return rs;
        
    }
    public void getString(String digits, List<Character> temp, 
                          List<String> rs, Map<Integer, String> map){
        if(digits.length() == 0){
            char[] arr = new char[temp.size()];
            for(int i = 0; i < temp.size(); i++){
                arr[i] = temp.get(i);
            }
            rs.add(String.valueOf(arr));
            return;
        }
        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for(int i = 0; i < letters.length(); i++){
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, rs, map);
            temp.remove(temp.size() - 1);
        }
            
    }
}
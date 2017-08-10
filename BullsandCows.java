public class Solution {
    public String getHint(String secret, String guess) {
        int countBull = 0, countCow = 0;
        //check bull
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2){
                countBull++;
            }else{
                map.put(c1, map.getOrDefault(c1, 0) + 1);
            }
        }
        //check cow
        for(int i = 0; i < secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 != c2){
                if(map.containsKey(c2)){
                    countCow++;
                    if(map.get(c2) == 1)
                        map.remove(c2);
                    else{
                        map.put(c2, map.get(c2) - 1);
                    }
                }
            }
        }
        return countBull + "A" + countCow + "B";
    }
}
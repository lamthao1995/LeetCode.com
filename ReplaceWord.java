public class Solution {
    public static Comparator<String> SORTSTR = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return o1.length() - o2.length();
            }
        };
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, SORTSTR);
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            for(String s : dict){
                if(s.length() > words[i].length()) break;
                String tmp = "";
                tmp = words[i].substring(0, s.length());
                if(tmp.equals(s)){
                    words[i] = tmp;
                    break;
                }
            }
        }
        String rs = words[0]; 
        for(int i = 1; i < words.length; i++){
            rs = rs + " " + words[i];
        }
        return rs;
        
    }
    
    
}
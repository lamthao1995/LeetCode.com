public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare(String a, String b){
                if(a.length() != b.length())
                    return -a.length() + b.length();
                return a.compareTo(b);
            }
        });
        for(String tmp : d){
            if(isSubWord(s, tmp))
                return tmp;
        }
        return "";
    }
    public boolean isSubWord(String s, String p){
        int j = 0;
        for(int i = 0; i < s.length() && j < p.length(); i++){
            if(s.charAt(i) == p.charAt(j))
                j++;
        }
        return j == p.length();
    }
}
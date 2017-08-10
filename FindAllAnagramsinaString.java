public class Solution {
    int trace[] = new int[26];
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr = new ArrayList<>();
        if(s == null || p == null) return arr;
        if(s.length() < p.length()) return arr;
        for(int i = 0; i < p.length(); i++){
            int index = (int)p.charAt(i) - 'a';
            trace[index]++;
            index = (int)s.charAt(i) - 'a';
            trace[index]--;
        }
        boolean check = true;
        for(int i = 0; i < 26; i++){
            if(trace[i] != 0){
                check = false;
            }
        }
        if(check) arr.add(0);
        int counter = 0;
        trace[s.charAt(counter) - 'a']++;
        for(int i = p.length(); i < s.length(); i++){
            counter++;
            trace[s.charAt(i) - 'a']--;
            record(counter, arr);
            trace[s.charAt(counter) - 'a']++;
        }
        return arr;
    }
    public void record(int index, List<Integer> arr){
        for(int i = 0; i < 26; i++){
            if(trace[i] != 0) return;
        }
        arr.add(index);
    }
}
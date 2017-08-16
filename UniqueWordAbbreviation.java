public class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abbre = abbreProduce(s);
            Set<String> set = map.containsKey(abbre) ? map.get(abbre) : new HashSet();
            set.add(s);
            map.put(abbre, set);
        }
    }
    
    public boolean isUnique(String word) {
        String abbre = abbreProduce(word);
        Set<String> set = map.getOrDefault(abbre, null);
        return set == null || (set.size() == 1 && set.contains(word));
    }
    private String abbreProduce(String s){
        int len = s.length();
        if(len <= 2)
            return s;
        return s.charAt(0) + Integer.toString(len - 2) + s.charAt(len - 1);
    }
}
//  private final Map<String, Set<String>> abbrDict = new HashMap<>();

//     public ValidWordAbbr(String[] dictionary) {
//         for (String s : dictionary) {
//             String abbr = toAbbr(s);
//             Set<String> words = abbrDict.containsKey(abbr)
//                 ? abbrDict.get(abbr) : new HashSet<>();
//             words.add(s);
//             abbrDict.put(abbr, words);
//         }
//     }

//     public boolean isUnique(String word) {
//         String abbr = toAbbr(word);
//         Set<String> words = abbrDict.get(abbr);
//         return words == null || (words.size() == 1 && words.contains(word));
//     }

//     private String toAbbr(String s) {
//         int n = s.length();
//         if (n <= 2) {
//             return s;
//         }
//         return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
//     }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
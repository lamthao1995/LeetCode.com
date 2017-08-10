public class Solution {
    public String removeDuplicateLetters(String s) {
         HashMap<Character, ArrayList<Integer>> counts = new HashMap<Character, ArrayList<Integer>>();
        ArrayList<Character> keys = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!counts.containsKey(c)) {
                counts.put(c, new ArrayList<Integer>());
                keys.add(c);
            }
            counts.get(c).add(i);
        }
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        while (!counts.isEmpty()) {
            boolean found = true;
            for (int i = 0; i < keys.size(); i++) {
                int index = counts.get(keys.get(i)).get(0);
                for (int j = 0; j < keys.size(); j++) {
                    ArrayList<Integer> count = counts.get(keys.get(j));
                    if (count.get(count.size() - 1) < index) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    sb.append(keys.get(i));
                    counts.remove(keys.get(i));
                    keys.remove(i);
                    for (int j = 0; j < keys.size(); j++) {
                        ArrayList<Integer> count = counts.get(keys.get(j));
                        while (count.get(0) < index) {
                            count.remove(0);
                        }
                    }
                    break;
                }
                found = true;
            }
        }
        return sb.toString();
    }
}
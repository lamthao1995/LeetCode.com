public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int maxVal = map[25] - 1, slot = maxVal * n;
        for(int i = 24; i >= 0 && map[i] > 0; i--){
            slot -= Math.min(map[i], maxVal);
        }
        if(slot <= 0)
            return tasks.length;
        return slot + tasks.length;
    }
}
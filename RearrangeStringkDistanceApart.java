public class Solution {
    public String rearrangeString(String s, int k) {
        if(k <= 1) return s;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> wait = new LinkedList();
        while(maxHeap.size() > 0){
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            wait.offer(cur);
            if(k > wait.size())
                continue;
            Map.Entry<Character, Integer> front = wait.poll();
            if(front.getValue() > 0)
                maxHeap.offer(front);
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
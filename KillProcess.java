public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> rs = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap();
        int len = pid.size();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(ppid.get(i))){
                map.put(ppid.get(i), new HashSet<Integer>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList();
        queue.add(kill);
        rs.add(kill);
        while(queue.size() > 0){
            int key = queue.poll();
            Set<Integer> set = map.get(key);
            if(set == null) continue;
            for(int i : set){
                queue.add(i);
                rs.add(i);
            }
            //set.clear();
        }
        return rs;
    }
}
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0){
            return -1;
        }
        Set<String> visited = new HashSet();
        Set<String> bankSet = new HashSet();
        for(String s : bank){
            bankSet.add(s);
        }
        char[] charSet = {'A', 'T', 'G', 'C'};
        Queue<String> queue = new LinkedList();
        queue.add(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String s = queue.poll();
                if(s.equals(end))
                    return level;
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char tmp = arr[i];
                    for(char c : charSet){
                        arr[i] = c;
                        String newS = new String(arr);
                        if(!visited.contains(newS) && bankSet.contains(newS)){
                            queue.add(newS);
                            visited.add(newS);
                        }
                    }
                    arr[i] = tmp;
                }
            }
            level++;
        }
        return -1;
    }
}
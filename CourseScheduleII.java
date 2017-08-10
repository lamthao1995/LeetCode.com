public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return new int[0];
        int len = prerequisites.length;
        if(len == 0){
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }
        int pCounter[] = new int[numCourses];
        for(int i = 0; i < len; i++){
            pCounter[prerequisites[i][0]]++;
        }
        LinkedList<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(pCounter[i] == 0){
                queue.add(i);
            }
        }
        int numNoPre = queue.size();
        int[] rs = new int[numCourses];
        int j = 0;
        while(!queue.isEmpty()){
            int c = queue.remove();
            rs[j++] = c;
            
            for(int i = 0; i < len; i++){
                if(prerequisites[i][1] == c){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] == 0){
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }
            }
        }
        if(numNoPre == numCourses)
            return rs;
        else{
            return new int[0];
        }
        
    }
}
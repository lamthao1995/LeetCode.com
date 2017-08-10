public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            throw new IllegalArgumentException("Illegal input");
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0)
            return true;
        int[] pCounter = new int[numCourses];
        for(int i = 0; i < len; i++){
            pCounter[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(pCounter[i] == 0){
                queue.add(i);
            }
        }
        //number of courses having no prequisites
        int numNoPre = queue.size();
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i = 0; i < len; i++){
                if(prerequisites[i][1] == top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] == 0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
            
    }
}
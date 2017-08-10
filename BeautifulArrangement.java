public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        backtrack(visited, 1, N);
        return count;
    }
    public void backtrack(int[] visited, int pos, int N){
        if(pos > N){
            count++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(visited[i] == 0 && (pos % i == 0 || i % pos  == 0)){
                visited[i] = 1;
                backtrack(visited, pos + 1, N);
                visited[i] = 0;
            }
        }
    }
}
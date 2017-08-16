public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int len = Capital.length;
        for(int i = 0; i < len; i++)
            minHeap.offer(new int[]{Capital[i], Profits[i]});
        for(int i = 0; i < k; i++){
            while(minHeap.size() > 0 && minHeap.peek()[0] <= W){
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.size() == 0) break;
            W += maxHeap.poll()[1];
        }
        return W;
    }
}
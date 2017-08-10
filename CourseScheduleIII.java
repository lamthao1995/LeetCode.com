public class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0;
        for(int[] c : courses){
            if(time + c[0] <= c[1]){
                maxHeap.offer(c[0]);
                time += c[0];
            }else if(!maxHeap.isEmpty() && maxHeap.peek() > c[0]){
                time += c[0] - maxHeap.poll();
                maxHeap.offer(c[0]);
            }
        }
        return maxHeap.size();
    }
}
public class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if(n <= 0) return new double[0];
        double[] rs = new double[n];
        for(int i = 0; i <= nums.length; i++){
            if(i >= k){
                rs[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if(i < nums.length){
                addNum(nums[i]);
            }
        }
        return rs;
        
    }
    public void remove(int num){
        double median = getMedian();
        if(num < median){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
       
    }
    public void addNum(int num){
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
    public double getMedian(){
        if(minHeap.isEmpty() && maxHeap.isEmpty())
            return 0.0;
        if(minHeap.size() == maxHeap.size()){
            return (double) ((long)minHeap.peek() + (long)maxHeap.peek()) / 2.0;
        }else{
            return (double) minHeap.peek();
        }
    }
}
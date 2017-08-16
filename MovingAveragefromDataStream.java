public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue = new LinkedList();
    double sum = 0;
    int maxSize;
    public MovingAverage(int size) {
        this.maxSize = size;
    }
    
    public double next(int val) {
        if(queue.size() < this.maxSize){
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }else{
            sum -= queue.poll();
            sum += val;
            queue.add(val);
            return sum / this.maxSize;
        }
           
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
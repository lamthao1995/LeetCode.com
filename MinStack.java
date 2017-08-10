public class MinStack {
   
    Stack<Integer> min = new Stack();
    Stack<Integer> stack = new Stack();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()) min.push(x);
        else{
            if(min.peek() > x){
                min.push(x);
            }else{
                min.push(min.peek());
            }
        }
    }
    
    public void pop() {
        if(min.isEmpty()) return;
        min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
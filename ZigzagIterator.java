public class ZigzagIterator {
    private Queue<Integer> q1 = new LinkedList();
    private Queue<Integer> q2 = new LinkedList();
    boolean isQ1 = true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        for(int i : v1)
            q1.add(i);
        for(int i : v2)
            q2.add(i);
    }

    public int next() {
        if(q1.isEmpty())
            return q2.poll();
        else if(q2.isEmpty())
            return q1.poll();
        if(isQ1){
            isQ1 = false;
            return q1.poll();
        }else{
            isQ1 = true;
            return q2.poll();
        }
    }

    public boolean hasNext() {
        return !q1.isEmpty() || !q2.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
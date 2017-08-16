public class LRUCache {
    private int cap;
    private HashMap<Integer, Node> map = new HashMap();
    private Node head = null, end = null;
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node newNode = new Node(key, value);
            if(map.size() >= cap){
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }
    private void remove(Node n){
        if(n.pre != null){
            n.pre.next = n.next;
        }else{
           head = n.next; 
        }
        if(n.next != null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
    }
    private void setHead(Node n){
        n.next = head;
        n.pre = null;
        if(head != null){
            head.pre = n;
        }
        head = n;
        if(end == null){
            end = head;
        }
    }
    public static class Node{
        int key, value;
        Node next, pre;
        public Node(int key, int value){
            this.value = value;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
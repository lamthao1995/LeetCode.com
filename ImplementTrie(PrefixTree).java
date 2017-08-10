public class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0, this.root);
    }
    public Node insert(String word, int index, Node r){
        char c = word.charAt(index);
        if(r == null) {
            r = new Node(c);
            if(root == null){
                this.root = r;
            }
        }
        if(c < r.c){
            r.left = insert(word, index, r.left);
        }else if(c > r.c){
            r.right = insert(word, index, r.right);
        }else if(index < word.length() - 1){
            r.middle = insert(word, index + 1, r.middle);
        }else{
            r.isEnd = true;
        }
        return r;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0, this.root);
    }
    public boolean search(String s, int index, Node r){
        if(r == null) return false;
        char c = s.charAt(index);
        if(c < r.c){
            return search(s, index, r.left);
        }else if(c > r.c){
            return search(s, index, r.right);
        }else if(index < s.length() - 1){
            return search(s, index + 1, r.middle);
        }else{
            if(r.isEnd == true) return true;
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0, this.root);
    }
    public boolean startsWith(String s, int index, Node r){
         if(r == null) return false;
        char c = s.charAt(index);
        if(c < r.c){
            return startsWith(s, index, r.left);
        }else if(c > r.c){
            return startsWith(s, index, r.right);
        }else if(index < s.length() - 1){
            return startsWith(s, index + 1, r.middle);
        }else{
           return true;
        }
    }
    public class Node{
        char c;
        boolean isEnd = false;
        Node right, left, middle;
        public Node(char c){
            this.c = c;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
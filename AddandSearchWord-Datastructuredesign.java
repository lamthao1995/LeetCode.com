public class WordDictionary {
    Node root = new Node();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = this.root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(cur.isExist(c) == false){
                cur.setNode(c);
            }
            cur = cur.getNode(c);
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
       return search(word, 0, this.root);
    }
    public boolean search(String s, int index, Node r){
        Node cur = r;
        if(index == s.length() && cur.isEnd == true) return true;
        boolean check = false;
        for(int i = index; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != '.'){
                if(cur.isExist(c) == false) return false;
                cur = cur.getNode(c);
                if(cur.isEnd == true && i == s.length() - 1) return true;
      
            }else{
                for(Node x : cur.child){
                    if(x != null){
                        check = check | search(s, i + 1, x); 
                    }
                }
                break;
            }
        }
        return check;
    }
    class Node{
        Node child[] = new Node[26];
        boolean isEnd = false;
        public Node(){
            
        }
        public boolean isExist(char c){
            int index = (int)c - 'a';
            if(this.child[index] == null) return false;
            return true;
        }
        public void setNode(char c){
            int index = (int)c - 'a';
            this.child[index] = new Node();
        }
        public Node getNode(char c){
            int index = (int)c - 'a';
            return this.child[index];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
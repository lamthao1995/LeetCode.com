public class Solution {
    int[][] trace;
    int rows, cols;
    List<String> rs = new ArrayList<>();
    HashSet<String> hash = new HashSet();
    String temp = "";
    public List<String> findWords(char[][] board, String[] words) {
        TrieTree trie = new TrieTree();
        for(String x : words){
            trie.insert(x);
        }
        //System.out.println(trie.search("aab"));
        rows = board.length; cols = board[0].length;
          trace = new int[rows][cols];
        for(int i = 0; i < 26; i++){
            char c = (char)(i + 'a');
            if(trie.root.isExist(c)){
                for(int x = 0; x < rows; x++){
                    for(int y = 0; y < cols; y++){
                        if(board[x][y] == c){
                            backtrack(x, y, board, trie.root);
                        }
                    }
                }
            }
        }
        return rs;
        
    }
    public void backtrack(int x, int y, char[][] b, Node tr){
        if(x < 0 || y < 0 || x >= rows || y >= cols) return;
        if(trace[x][y] != 0 || tr.isExist(b[x][y]) == false) return;
        trace[x][y] = 1;
        String t = temp;
        char c = b[x][y];
        temp = temp + c;
        if(tr.getNode(c).isEnd == true){
            if(this.hash.contains(temp) == false){
                this.rs.add(temp);
                hash.add(temp);
            }
        }
            backtrack(x + 1, y, b, tr.getNode(c));
            backtrack(x - 1, y, b, tr.getNode(c));
            backtrack(x, y + 1, b, tr.getNode(c));
            backtrack(x, y - 1, b, tr.getNode(c));
        
        temp = t;
        trace[x][y] = 0;
        
    }
    public class TrieTree{
        Node root = new Node();
        public TrieTree(){
        }
        public void insert(String s){
            Node cur = this.root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(cur.isExist(c) == false) cur.setNode(c);
                cur = cur.getNode(c);
            }
            cur.isEnd = true;
        }
        public boolean search(String s){
            Node cur = this.root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!cur.isExist(c)) return false;
                if(i == s.length() - 1){
                     if(cur.isEnd == false)
                     return false;
                }
                cur = cur.getNode(c);
            }
            return true;
        }
    }
    public class Node{
        Node[] child = new Node[26];
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
            return this.child[(int)c - 'a'];
        }//a b
         //a a
        public char getKet(int x){
            return (char)(x + (int)'a');
        }
    }
}
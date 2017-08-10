public class Solution {
    List<String> rs = new ArrayList<>();
    Node root = new Node();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int len =  words.length;
        for(int i = 0; i < len; i++){
            String s = words[i];
            Node temp = root;
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(temp.isExisted(c) == false){
                    temp.setKey(c);
                }
                temp = temp.getNode(c);
                }
                temp.setLeaf();
        }
        
        for(String s : words){
            if(test(s, 0, root, 0)){
                rs.add(s);
            }
        }
        return rs;
    }
    public boolean test(String s, int index , Node root, int counter){
        Node cur = root;
        for(int i = index; i < s.length(); i++){
            char c = s.charAt(i);
            if(cur.isExisted(c) == false) return false;
            if(cur.getNode(c).isLeaf){
               if(i == s.length() - 1) return counter >= 1;
               if(test(s, i + 1, root, counter + 1)) return true;
            }
            cur = cur.getNode(c);
        }
        return false;
    }
    public static class Node{
        Node[] leaf = new Node[26];
        boolean isLeaf = false;
        public Node(){
        }
        public boolean isExisted(char c){
            int index = (int)c - (int)'a';
            if(this.leaf[index] == null) return false;
            return true;
        }
        public void setKey(char c){
            this.leaf[(int) c - (int)'a'] = new Node();
        }
        public Node getNode(char c){
            return this.leaf[(int)c - (int)'a'];
        }
        public void setLeaf(){
            this.isLeaf = true;
        }
    }
    
}
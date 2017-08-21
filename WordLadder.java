public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        Queue<WordNode> queue = new LinkedList();
        queue.add(new WordNode(beginWord, 1));
        Set<String> dict = new HashSet();
        for(String s : wordDict)
            dict.add(s);
        if(dict.contains(endWord) == false)
            return 0;
        
        while(!queue.isEmpty()){
            WordNode node = queue.poll();
            String word = node.word;
            if(word.equals(endWord)){
                return node.numStep;
            }
            
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c){
                        arr[i] = c;
                    }
                    
                    String newWord = new String(arr);
                    if(dict.contains(newWord)){
                        queue.add(new WordNode(newWord, node.numStep + 1));
                        dict.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
    public static class WordNode{
        String word;
        int numStep;
        public WordNode(String word, int numStep){
            this.word = word;
            this.numStep = numStep;
        }
    }
}
public class StringIterator {
    Queue<int[]> queue = new LinkedList();
    public StringIterator(String compressedString) {
        int len = compressedString.length();
        int start = 0;
        while(start < len){
            char c = compressedString.charAt(start++);
            String num = "";
            while(start < len && Character.isDigit(compressedString.charAt(start))){
                num = num + compressedString.charAt(start++);
            }
            int freq = Integer.parseInt(num);
            queue.add(new int[]{(int)c, freq});
           // System.out.println("Character = " + c + " and freq = " + freq);
        }
    }
    
    public char next() {
        if(!hasNext())
            return ' ';
        int[] tmp = queue.peek();
        tmp[1]--;
        char c = (char) tmp[0];
        if(tmp[1] == 0) queue.poll();
        return c;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
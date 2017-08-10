public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       Queue<Integer> s = new LinkedList();
        int len = flowerbed.length;
       for(int i = 0 ; i < len; i++){
           if(flowerbed[i] == 1) s.add(i);
       }
       int result = 0;
       if(s.size() == 0){
            result = len / 2 + (len % 2); 
            if(n > result) return false;
            else return true;
       }
       
       int start = s.poll();
       result = getF(start - 1);
        int end = start;
       while(s.size() > 0){
           end = s.poll();
           result += getF(end - start - 3);
           start = end;
       } 
        result += getF(len - 2 - end);
        if(result >= n) return true;
        else return false;
        
    }
    public int getF(int n){
        if(n < 0) return 0;
        return (n / 2 + (n % 2));
    }
}
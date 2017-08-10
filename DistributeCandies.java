public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet();
        int len = candies.length;
        for(int x : candies){
            set.add(x);
        }
        if(set.size() >= len / 2){
            return len/2;
        }else{
            return set.size();
        }
    }
}
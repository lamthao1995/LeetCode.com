public class Solution {
    public int hammingDistance(int x, int y) {
        int counter = 0;
        for(int i = 0; i < 32; i++){
            if(getBit(i, x) != getBit(i, y)) counter++;
        }
        return counter;
    }
    public int getBit(int index, int x){
        int k = 1 << index;
        //System.out.println(k);
        if((x & k) != 0) return 1;
        else return 0;
    }
}
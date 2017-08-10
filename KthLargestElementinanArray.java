public class Solution {
    static int[] x;
    public int findKthLargest(int[] nums, int k) {
        x = new int[nums.length];
        x = nums;
        QuickSort(0, x.length - 1);
        return x[x.length - k];
    }
    public void QuickSort(int L, int H){
        int y = x[(L + H) / 2];
        int i = L; 
        int j = H;
        do{
            while(x[i] < y) i++;
            while(x[j] > y) j--;
            if(i <= j){
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                j--;
                i++;
            }
        } while(i <= j);
        if(L < j) QuickSort(L, j);
        if(i < H) QuickSort(i, H);
        
    }
}
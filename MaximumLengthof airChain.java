public class Solution {
     public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        qs(0, pairs.length - 1, pairs);
        return maxChainLength(pairs, pairs.length);
    }
     int maxChainLength(int[][] arr, int n)
    {
       int i, j, max = 0;
       int mcl[] = new int[n];
       for ( i = 0; i < n; i++ )
          mcl[i] = 1;
       for ( i = 1; i < n; i++ )
          for ( j = 0; j < i; j++ )
             if ( arr[i][0] > arr[j][1] && mcl[i] < mcl[j] + 1)
                mcl[i] = mcl[j] + 1;
       for ( i = 0; i < n; i++ )
          if ( max < mcl[i] )
             max = mcl[i];
      
       return max;
    }
    public void qs(int L, int H, int[][] pairs){
        int i = L, j = H;
        int mid = pairs[(L + H) / 2][0];
        do{
            while(pairs[i][0] < mid) i++;
            while(pairs[j][0] > mid) j--;
            if(i <= j){
                int tmp = pairs[i][0];
                pairs[i][0] = pairs[j][0];
                pairs[j][0] = tmp;
                                   
                tmp = pairs[i][1];
                pairs[i][1] = pairs[j][1];
                pairs[j][1] = tmp;
                i++;
                j--;
            }
        }while(i <= j);
        if(L < j) qs(L, j, pairs);
        if(i < H) qs(i, H, pairs);
    }
    
}
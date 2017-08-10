public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] trace = new int[m + n];
        int counter = 0;
        int i = 0; int j = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                trace[counter++] = nums1[i++];
            }else{
                trace[counter++] = nums2[j++];
            }
        }
        if(i < m){
           while(i < m){
               trace[counter++] = nums1[i++];
           } 
        }else{
            while(j < n){
                trace[counter++] = nums2[j++];
            }
        }
        for(i = 0; i <  trace.length; i++){
            nums1[i] = trace[i];
        }
    }
}
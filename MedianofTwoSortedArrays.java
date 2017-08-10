public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] trace = new int[len];
        int counter = 0;
        int i = 0; int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                trace[counter++] = nums1[i++];
            }else{
                trace[counter++] = nums2[j++];
            }
        }
        if(i == nums1.length){
            while(j < nums2.length){
                trace[counter++] = nums2[j++];
            }
        }else{
            while(i < nums1.length){
                trace[counter++] = nums1[i++];
            }
        }
        if(len % 2 == 1){
            return (double)trace[len / 2];
        }else{
            return (double)(trace[len/2] + trace[len/2 - 1]) / 2;
        }
    }
}
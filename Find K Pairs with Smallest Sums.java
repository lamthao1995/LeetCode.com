public class Solution {
   
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int p1 = 0, p2 = 0;
        int counter = 1;
        List<int[]> rs = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return rs;
        while(counter <= k){
            int[] d = new int[2];
            if(p1 >= nums1.length || p2 >= nums2.length) break;
            if(nums1[p1] >= nums2[p2]){
                d[0] = nums2[p2];
                d[1] = nums1[p1];
                p1++;
            }else{
                d[0] = nums1[p1];
                d[1] = nums2[p2];
                p2++;
            }
            rs.add(d);
            counter++;
        }
        return rs;
    }
}
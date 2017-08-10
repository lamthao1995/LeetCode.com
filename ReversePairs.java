public class Solution {
    int helper[];
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        helper = new int[len];
        return mergeCount(0, len - 1, nums);
    }
    public int mergeCount(int left, int right, int[] nums){
        if(left >= right)
            return 0;
        int mid = (left + right) / 2;
        int count = mergeCount(left, mid, nums) + 
                        mergeCount(mid + 1, right, nums);
        int j = mid + 1;
        for(int i = left; i <= mid; i++){
            while(j <= right && (long)nums[i] > 2 * (long)nums[j]){
                j++;
            }
            count += j - (mid + 1);
        }
        merge(left, right, nums);
        return count;
        
    }
    //  if (start < end) {
    //     int mid = (start + end) / 2;
    //     int count = mergesort_and_count(A, start, mid) + mergesort_and_count(A, mid + 1, end);
    //     int j = mid + 1;
    //     for (int i = start; i <= mid; i++) {
    //         while (j <= end && A[i] > A[j] * 2LL)
    //             j++;
    //         count += j - (mid + 1);
    //     }
    //     merge(A, start, mid, end);
    //     return count;
    // }
    // else
    //     return 0;
    public void merge(int left, int right, int[] nums){
        int mid = (left + right) / 2;
        int k = left;
        int len = right - left + 1;
        int i = left, j = mid + 1;
        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                helper[k++] = nums[i++];
            }else{
                helper[k++] = nums[j++];
            }
        }
        if(i <= mid){
           while(i <= mid)
               helper[k++] = nums[i++];
        }else{
            while(j <= right)
                helper[k++] = nums[j++];
        }
        for(i = left; i <= right; i++){
            nums[i] = helper[i];
        }
    }
}
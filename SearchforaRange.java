public class Solution {
    static int num = 0;
    static int K = 0;
    static int[] arr1;
    public int[] searchRange(int[] nums, int target) {
        arr1 = new int[2];
        num = nums.length;
        K = target;
        arr1[0] = -1;
        arr1[1] = -1;
        if(num < 1) return arr1;
        if(nums[0] > K || nums[num - 1] < K) return arr1;
        do_task1(nums, 0, num - 1);
        do_task2(nums, 0, num - 1);
        return arr1;
    }
    public static void do_task1(int arr[], int i, int j){
        if(i > j) return;
        if(arr[0] == K){
            System.out.println("Chi so duoi: " + 0);
             arr1[0] = 0;
            return;
        }
        
        int mid = (i + j) / 2;
         System.out.println("chi so**: " + (mid + 1));
         if(mid == num - 1){
              if(arr[mid] == K)  arr1[0] = num - 1;
           
            return;
        }
        if(arr[mid + 1] == K && arr[mid] < arr[mid + 1]) {
            System.out.println("chi so**: " + (mid + 1));
            arr1[0] = (mid + 1);
            return;
        }
        else{
            if(arr[mid] >= K) do_task1(arr, i, mid - 1);
            else do_task1(arr, mid + 1, j);
        }
        
    }
     public static void do_task2(int arr[], int i, int j){
         if(i> j) return;
          if(arr[num - 1] == K){
            System.out.println("Chi so tren: " + (num - 1));
             arr1[1] = num - 1;
            return;
        }
        int mid = (i + j) / 2;
        if(mid == 0){
             if(arr[mid] == K) arr1[1] = 0;
            
            return;
        }
        if(arr[mid -1] == K && arr[mid] > arr[mid - 1]) {
            System.out.println("chi so**: " + (mid - 1));
            arr1[1] = mid - 1;
            return;
        }
        else{
            if(arr[mid] <= K) do_task2(arr, mid + 1, j);
            else do_task2(arr, i , mid - 1);
        }
     }
}
public class Solution {
    final Comparator<int[]> arrayComparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    };
    public int[] twoSum(int[] nums, int target) {
        int[] d = new int[2];
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, arrayComparator);
        //for(int i = 0; i < nums.length; i++){
          //  System.out.println(" " + arr[i][0] + " index: " + arr[i][1]);
        //}
        for(int i = 0; i < nums.length; i++){
            int goal = target - arr[i][0];
            int index = binary(0, nums.length - 1, arr, goal, i);
           // System.out.println(index + " goal = " + goal);
            if(index != -1){
                d[0] = arr[i][1];
                d[1] = index;
                return d;
            }
        }
        return d;
    }
    public int binary(int L, int H, int[][] num, int target, int index){
        if(L > H) return -1;
        int mid = (L + H) / 2;
        if(num[mid][0] == target){
            if(mid == index) return -1;
            return num[mid][1];
        }else if(num[mid][0] > target){
            return binary(L, mid - 1, num, target, index);
        }else{
            return binary(mid + 1, H, num, target, index);
        }
    }
}
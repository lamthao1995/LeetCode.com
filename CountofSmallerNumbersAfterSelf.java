public class Solution {
    List<Integer> rs = new ArrayList<>();
    int helper[][];
    int num[][];
    int counts[];
    int sum = 0;
    public List<Integer> countSmaller(int[] nums) {
        counts = new int[nums.length];
        helper = new int[nums.length][2];
        num = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++)
        {
            num[i][0] = nums[i];
            num[i][1] = i;
        }
        mergeCount(0, nums.length - 1, num);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < counts.length; i++)
            res.add(counts[i]);
        return res;
    }
    public void mergeCount(int left, int right, int[][] nums){
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        mergeCount(left, mid, nums); 
        mergeCount(mid + 1, right, nums);
        int count = 0;
        int j = mid + 1;
        for(int i = left; i <= mid; i++){
            while(j <= right && nums[j][0] < nums[i][0])
                j++;
            count = j - (mid + 1);
            counts[nums[i][1]] += count;
        }
        merge(left, right, nums);
    }
    public void merge(int left, int right, int[][] nums){
        int i = left, mid = (left + right) / 2, j = mid + 1;
        int k = left;
        while(i <= mid && j <= right){
            if(nums[i][0] < nums[j][0]){
                helper[k][0] = nums[i][0];
                helper[k++][1] = nums[i++][1];
            }else{
                helper[k][0] = nums[j][0];
                helper[k++][1] = nums[j++][1];
            }
        }
        while(i <= mid){
              helper[k][0] = nums[i][0];
              helper[k++][1] = nums[i++][1];
        }
            
        while(j <= right){
             helper[k][0] = nums[j][0];
             helper[k++][1] = nums[j++][1];
        }
           
        
        for(i = left; i <= right; i++){
            nums[i][0] = helper[i][0];
            nums[i][1] = helper[i][1];
        }
    }
}
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < len - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1;
                int end = len - 1;
                while(start < end){
                    int check = nums[i] + nums[j] + nums[start] + nums[end];
                    if(check == target){
                        //record
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]); arr.add(nums[j]); arr.add(nums[start]); arr.add(nums[end]);
                        rs.add(arr);
                        int startV = nums[start];
                        int endV = nums[end];
                        while(end > start && startV == nums[start]) start++;
                        while(end > start && endV == nums[end]) end--;
                    }else if(check < target){
                        start++;
                    }else{
                        end--;
                    }
                   
                    
                }
            }
        }
        return rs;
    }
}
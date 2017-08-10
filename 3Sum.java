public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
     	Arrays.sort(nums);
        int numOfElement = nums.length;
        for(int i = 0; i < numOfElement; i++){
            //if(i == 0 || nums[i] != nums[i - 1]){
             	for(int j = i + 1; j < numOfElement; j++){
                	//if(j == i + 1 || nums[j - 1] != nums[j]){
                    	if(nums[i] + nums[j] == -2) System.out.println("co ma");
                        int target = 0 - nums[j] - nums[i];
                        if(checkB(j + 1, numOfElement - 1, nums, target)){
                            ArrayList<Integer> arr = new ArrayList<>();
                            arr.add(nums[i]); arr.add(nums[j]); arr.add(target);
                            rs.add(arr);
                       // }
                    }
            	//}   
            }
        }
        return rs;
    }
    public boolean isValid(int i, int j, int[] arr){
        if(i == 0) return true;
        if(j == i + 1) return true;
        if(arr[j] == arr[j - 1]) return false;
        return true;
    }
    public boolean checkB(int L, int H, int[] nums, int target){
       	if(L > H) return false;
        int mid = (L + H) / 2;
        if(nums[mid] == target) return true;
        else if(nums[mid] > target){
            return checkB(mid + 1, H, nums, target);
        }else{
            return checkB(L, mid - 1, nums, target);
        }
    }
}
public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    int length;
    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        backtrack(length - 1, nums, 0);
        return rs;
    }
    public void backtrack(int r, int nums[], int l){
            if(r == l){
                //System.out.println("ghi nghiem ma");
                ArrayList<Integer> arr = new ArrayList<>();
                for(int a = 0; a < this.length; a++){
                    arr.add(nums[a]);
                }
                rs.add(arr);
            }else{
                for(int i = l ; i <= r; i++){
                    //swap
                    int temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;
                    backtrack(r, nums, l + 1);
                    
                    nums[i] = nums[l];
                    nums[l] = temp;
                }
            }
           

    }
}
public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    HashSet<String> s = new HashSet();
    int length;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.length = nums.length;
        dotask(nums, 0, length - 1);
        return rs;
    }
    public void dotask(int[] nums, int low, int end){
        if(low == end){
            //ghi nghiem
            String str = "";
            for(int i = 0; i < this.length; i++){
                str = str + nums[i] + "";
            }
            //System.out.println("Ket qua: " + str);
            if(s.contains(str)) return;
            else s.add(str);
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < this.length; i++){
                arr.add(nums[i]);
            }
            this.rs.add(arr);
        }
        else
        {
            for(int i = low; i <= end; i++){
                //swap
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
              
             
               dotask(nums, low + 1, end);
               //comeback
          
               nums[low] = nums[i];
               nums[i] = temp;
            }    
        }
    }
}
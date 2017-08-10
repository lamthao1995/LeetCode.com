public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rs = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return rs;
        if(nums.length == 1)
            rs.add(nums[0] + "");
        int pre = nums[0];//previous element
        int first = pre;//first element of each range
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == pre + 1){
                if(i == nums.length - 1){
                    rs.add(first + "->" + nums[i]);
                }
            }else{
                if(first == pre){
                    rs.add(first + "");
                }else{
                    rs.add(first + "->" + pre);
                }
                if(i == nums.length - 1){
                    rs.add(nums[i] + "");
                }
                first = nums[i];
            }
            pre = nums[i];
        }
        return rs;
    }
}
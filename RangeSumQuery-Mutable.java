public class NumArray {
    int[] bit;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        bit = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            init(i, nums[i]);
    }
    
    public void update(int i, int val) {
        int dif = val - this.nums[i];
        this.nums[i] = val;
        i++;
        while(i < bit.length){
            bit[i] += dif;
            i += i & (-i);
        }
    }
    public void init(int i, int val){
        i++;
        while(i < bit.length){
            bit[i] += val;
            i += i & (-i);
        }
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    public int getSum(int index){
        int sum = 0;
        index++;
        while(index > 0){
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */